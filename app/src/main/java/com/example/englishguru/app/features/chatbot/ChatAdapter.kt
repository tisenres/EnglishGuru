package com.example.englishguru.app.features.chatbot

// ChatAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mychatbot.Message
import com.example.mychatbot.R

class ChatAdapter(private val messages: List<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val USER_MESSAGE = 1
    private val BOT_MESSAGE = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            USER_MESSAGE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_user_message, parent, false)
                UserMessageViewHolder(view)
            }
            BOT_MESSAGE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_bot_message, parent, false)
                BotMessageViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messages[position]
        when (holder.itemViewType) {
            USER_MESSAGE -> (holder as UserMessageViewHolder).bind(message)
            BOT_MESSAGE -> (holder as BotMessageViewHolder).bind(message)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].isUser) USER_MESSAGE else BOT_MESSAGE
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    inner class UserMessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val messageTextView: TextView = itemView.findViewById(R.id.userMessageTextView)

        fun bind(message: Message) {
            messageTextView.text = message.text
        }
    }

    inner class BotMessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val messageTextView: TextView = itemView.findViewById(R.id.botMessageTextView)

        fun bind(message: Message) {
            messageTextView.text = message.text
        }
    }
}
