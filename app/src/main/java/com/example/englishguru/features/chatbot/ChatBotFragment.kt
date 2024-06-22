package com.example.englishguru.features.chatbot

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import com.example.englishguru.databinding.FragmentChatBotBinding

const val OPENAI_URL = "https://chat.openai.com/"

class ChatBotFragment : Fragment() {

    private lateinit var binding: FragmentChatBotBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBotBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        val webView = binding.webView

        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        webView.loadUrl(com.example.englishguru.features.chatbot.OPENAI_URL)

        webSettings.apply {
            useWideViewPort = true
            loadWithOverviewMode = true
            builtInZoomControls = true
            displayZoomControls = false
            domStorageEnabled = true
        }

        webView.webChromeClient = WebChromeClient()
    }
}