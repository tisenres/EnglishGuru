package com.example.englishguru.app.features.chatbot

data class Message(val text: String, val isUser: Boolean)

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.englishguru.R
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ai.api.AIConfiguration
import ai.api.android.AIDataService
import ai.api.model.AIRequest
import ai.api.model.AIResponse

class WordChatFragment : Fragment() {

    private val messages = mutableListOf<Message>()
    private lateinit var adapter: ChatAdapter
    private lateinit var aiDataService: AIDataService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView: RecyclerView = findViewById(R.id.chatRecyclerView)
        val messageInput: EditText = findViewById(R.id.messageInput)
        val sendButton: Button = findViewById(R.id.sendButton)

        adapter = ChatAdapter(messages)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        val config = AIConfiguration("YOUR_DIALOGFLOW_CLIENT_ACCESS_TOKEN",
            AIConfiguration.SupportedLanguages.English,
            AIConfiguration.RecognitionEngine.System)

        aiDataService = AIDataService(config)

        sendButton.setOnClickListener {
            val userMessage = messageInput.text.toString()
            sendMessage(Message(userMessage, true))
            sendRequest(userMessage)
            messageInput.text.clear()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_word_chat, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WordChatFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WordChatFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}