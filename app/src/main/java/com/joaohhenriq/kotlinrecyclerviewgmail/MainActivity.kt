package com.joaohhenriq.kotlinrecyclerviewgmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.joaohhenriq.kotlinrecyclerviewgmail.adpater.EmailAdapter
import com.joaohhenriq.kotlinrecyclerviewgmail.model.email
import com.joaohhenriq.kotlinrecyclerviewgmail.model.fakeEmails
import com.mooveit.library.Fakeit
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: EmailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Fakeit.init()

        setContentView(R.layout.activity_main)

        adapter = EmailAdapter(fakeEmails())
        recycler_view_main.adapter = adapter
        recycler_view_main.layoutManager = LinearLayoutManager(this)

        floating_button.setOnClickListener {
            addEmail()
            recycler_view_main.scrollToPosition(0)
        }
    }

    private fun addEmail() {
        val sdf = SimpleDateFormat("dd/MM/YYYY", Locale("pt", "BR")).parse(
            Fakeit.dateTime().dateFormatter()
        )

        adapter.emails.add(0, email {
            stared = false
            unread = true
            user = Fakeit.name().firstName()
            subject = Fakeit.company().name()
            date = SimpleDateFormat("d MMM", Locale("pt", "BR")).format(sdf)
            preview = mutableListOf<String>().apply {
                repeat(10) {
                    val newWord: String = Fakeit.lorem().words()
                    add(newWord)
                }
            }.joinToString( " " )
        })

        adapter.notifyItemInserted(0)
    }
}