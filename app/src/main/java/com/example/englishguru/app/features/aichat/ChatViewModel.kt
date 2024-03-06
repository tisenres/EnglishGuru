package com.example.englishguru.app.features.aichat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.asTextOrNull
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChatViewModel(
    generativeModel: GenerativeModel
) : ViewModel() {
    private val chat = generativeModel.startChat(
        history = listOf(
            content(role = "user") { text("Do you have any questions?") },
            content(role = "model") { text("Hi, I'm Guru and I will assist you giving personal training and exercises to improve your English.\n\nDo you have any questions?") },
        )
    )

    private val _uiState: MutableStateFlow<ChatUiState> =
        MutableStateFlow(
            ChatUiState(chat.history.map { content ->
                ChatMessage(
                    text = content.parts.first().asTextOrNull() ?: "",
                    participant = if (content.role == "user") Participant.USER else Participant.MODEL,
                    isPending = false
                )
            })
        )

    val uiState: StateFlow<ChatUiState> =
        _uiState.asStateFlow()


    fun sendMessage(userMessage: String) {
        _uiState.value.addMessage(
            ChatMessage(
                text = userMessage,
                participant = Participant.USER,
                isPending = true
            )
        )

        viewModelScope.launch {
            try {
                val response = chat.sendMessage(userMessage)

                _uiState.value.replaceLastPendingMessage()

                response.text?.let { modelResponse ->
                    _uiState.value.addMessage(
                        ChatMessage(
                            text = modelResponse,
                            participant = Participant.MODEL,
                            isPending = false
                        )
                    )
                }
            } catch (e: Exception) {
                _uiState.value.replaceLastPendingMessage()
                _uiState.value.addMessage(
                    ChatMessage(
                        text = e.localizedMessage,
                        participant = Participant.ERROR
                    )
                )
            }
        }
    }
}
