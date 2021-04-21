package com.joaohhenriq.kotlinrecyclerviewgmail.adpater

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.core.util.isNotEmpty
import androidx.recyclerview.widget.RecyclerView
import com.joaohhenriq.kotlinrecyclerviewgmail.R
import com.joaohhenriq.kotlinrecyclerviewgmail.model.EmailModel
import kotlinx.android.synthetic.main.email_item.view.*

class EmailAdapter(val emails: MutableList<EmailModel>) :
    RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    val selectedItems = SparseBooleanArray()
    private var currentSelectedPosition: Int = -1

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

                if(emailModel.selected) {
                    itemView.txt_icon.background = itemView.txt_icon.oval(
                        Color.rgb(26, 115, 233)
                    )
                    itemView.background = GradientDrawable().apply {
                        shape = GradientDrawable.RECTANGLE
                        cornerRadius = 32f
                        setColor(Color.rgb(232, 240, 253))
                    }
                } else {
                    itemView.background = GradientDrawable().apply {
                        shape = GradientDrawable.RECTANGLE
                        cornerRadius = 32f
                        setColor(Color.WHITE)
                    }
                }

//                if(selectedItems.isNotEmpty()) {
//                    //animate
//                }
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
        holder.itemView.setOnClickListener {
            if(selectedItems.isNotEmpty()) {
                onItemClick?.invoke(position)
            }
        }

        holder.itemView.setOnLongClickListener {
            onItemLongClick?.invoke(position)
            return@setOnLongClickListener true
        }

        if(currentSelectedPosition == position) currentSelectedPosition = -1
    }

    fun toggleSelection(position: Int) {
        currentSelectedPosition = position
        if(selectedItems[position, false]){
            selectedItems.delete(position)
            emails[position].selected = false
        } else {
            selectedItems.put(position, true)
            emails[position].selected = true
        }

        notifyItemChanged(position)
    }

    fun deleteEmails() {
        emails.removeAll()
    }

    var onItemClick: ((Int) -> Unit)? = null
    var onItemLongClick: ((Int) -> Unit)? = null
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