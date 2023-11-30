package com.example.englishguru.app.features.chatbot

import com.example.englishguru.databinding.FragmentWordChatBinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ai.api.AIConfiguration
import ai.api.android.AIDataService
import ai.api.model.AIRequest
import ai.api.model.AIResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val KEY = "7b69e2c78edcd78c31b391afdcd2750dde1f7d6c"

class WordChatFragment : Fragment() {

    private val messages = mutableListOf<Message>()
    private lateinit var adapter: ChatAdapter
    private lateinit var aiDataService: AIDataService
    private lateinit var binding: FragmentWordChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ChatAdapter(messages)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWordChatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.chatRecyclerView.adapter = adapter
        binding.chatRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.sendButton.setOnClickListener {
            val userMessage = binding.messageInput.text.toString()
            sendMessage(Message(userMessage, true))
            sendRequest(userMessage)
            binding.messageInput.text.clear()
        }

        val config = AIConfiguration(KEY,
            AIConfiguration.SupportedLanguages.English,
            AIConfiguration.RecognitionEngine.System)

        aiDataService = AIDataService(config)
    }

    private fun sendMessage(message: Message) {
        messages.add(message)
        adapter.notifyDataSetChanged()
    }

    private fun sendRequest(query: String) {
        val request = AIRequest()
        request.setQuery(query)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response: AIResponse = aiDataService.request(request)
                val botMessage = response.result.fulfillment.speech

                CoroutineScope(Dispatchers.Main).launch {
                    sendMessage(Message(botMessage, false))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}