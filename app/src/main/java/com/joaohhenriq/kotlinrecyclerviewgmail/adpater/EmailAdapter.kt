package com.joaohhenriq.kotlinrecyclerviewgmail.adpater

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import com.joaohhenriq.kotlinrecyclerviewgmail.R
import com.joaohhenriq.kotlinrecyclerviewgmail.model.EmailModel
import kotlinx.android.synthetic.main.email_item.view.*

class EmailAdapter(val emails: MutableList<EmailModel>) :
    RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    inner class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(emailModel: EmailModel) {
            with(emailModel) {
                val hash = user.hashCode()
                itemView.txt_icon.text = user.first().toString()
                itemView.txt_icon.background = itemView.oval(Color.rgb(hash, hash / 2, 0))
                itemView.txt_user.text = user
                itemView.txt_subject.text = subject
                itemView.txt_preview.text = preview
                itemView.txt_date.text = date

                itemView.txt_user.setTypeface(
                    Typeface.DEFAULT,
                    if (unread) Typeface.BOLD else Typeface.NORMAL
                )
                itemView.txt_subject.setTypeface(
                    Typeface.DEFAULT,
                    if (unread) Typeface.BOLD else Typeface.NORMAL
                )
                itemView.txt_date.setTypeface(
                    Typeface.DEFAULT,
                    if (unread) Typeface.BOLD else Typeface.NORMAL
                )

                itemView.img_star.setImageResource(
                    if (stared) R.drawable.ic_baseline_star_24
                    else R.drawable.ic_baseline_star_border_24
                )
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_item, parent, false)
        return EmailViewHolder(view)
    }

    override fun getItemCount(): Int = emails.size

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.bind(emails[position])
    }
}

fun View.oval(@ColorInt color: Int): ShapeDrawable {
    val oval = ShapeDrawable(OvalShape())
    with(oval) {
        intrinsicHeight = height
        intrinsicWidth = width
        paint.color = color
    }

    return oval
}