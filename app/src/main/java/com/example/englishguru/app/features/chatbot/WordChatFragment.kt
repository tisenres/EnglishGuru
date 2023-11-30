//package com.example.englishguru.app.features.chatbot
//
//import ai.api.android.AIConfiguration;
//import com.example.englishguru.databinding.FragmentWordChatBinding
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.LinearLayoutManager
//import android.os.Handler
//import android.os.Looper
//import android.util.Log
//
//const val KEY = "\n" +
//        "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDJ9ybQ2AxaYdT2\n" +
//        "GjylgUiV11uzMkgl/BjMPt4csk+DCVXV08jfJ4F7sMnib84em4Q6Lhb3ilReESiq\n" +
//        "F/fCB/z8ilCeh+TzemSVQ10thayONGKCWHVe9S9y4wTOQFLC1sSFzXsvE/2/xS8f\n" +
//        "dwNhjII+v4S8kAjJYKNVkWZ97dEWoa6q+xjZfJ+m+Jcvwz06MdCiNWJJLZ6xvrj4\n" +
//        "G7xlMiPbTNsvMX9J4349U9GAX/eVNayYF+Y4Q+IzsnK6vHPZVKYVXuyZwYZO7ToK\n" +
//        "iDSjkxQk6yZkXPPWFs9j0+X+lLl99FKa8sIcplKbxRn7NcN2EOXX0dF2vikSWEyr\n" +
//        "WdSWc3j9AgMBAAECggEADlKuiEeWIq/G+lgUfnlLdEL0YCI7/yOgf5Wiy16y6FxY\n" +
//        "X8R3/alv052PR7V9pOqLB1Q+8Tm4b35gh6WQ/svxu1g0zPVevYyrxvEi0chl2yTo\n" +
//        "ao2K71vMjGWAsP7bT7GK+OFAb++HQpshkyXt0bR1BS2wZG4DjYKCut4Hqn0b47Kd\n" +
//        "vtZo5+YiOJJ+0SMe++tArrnzZWuQoyYpYE/DLp8eCfwA1SocY4b3T8dxgZjf8WB0\n" +
//        "AYSH1e/PESOrl48cer8ip/bL50ylf1KTDWMdx+Lf+K4xw3TwBUcJUOKiHPnmAmq9\n" +
//        "8FOZj9uuPirOTyFda9YQqHO/4zuFoKqGL8UtyWNLCQKBgQD9jOdL+AjfLHcG94Fz\n" +
//        "L2gUrpDKLNwJxJUzPkg2QjI19TKA309QNOQKjB+1MinefA6Ho/UNdPhs8ICzyVGB\n" +
//        "sCwYxQqCXOeYq5Y1yEN8U1es6eRvZuCELB2dHEBCtJmCVqDpX0ltFVl+bI9YZQln\n" +
//        "jyPexZ/JvO64GTOh7lKVFENOZQKBgQDL6qo9Mz6Qq9GWaLQhJk0qC3xEwOauZzCu\n" +
//        "chAHuEPSIfkYIzBaloOAmFWgA6qh2VybOgf5vnskyvffA8agCzA2qrSex3VZTuXO\n" +
//        "RLXRf7BjW64GT7lNIWX9JSP2XyxAZ00484gR2LPWYdqO3/UqYzAkt5fecax5Es1m\n" +
//        "b6zfK1JquQKBgEabGEXVelL7hOHRxqCW0PsBaZyDRXsK3Sl57I3/fQ/9ieTNSr7h\n" +
//        "G6e8QZApufMUxM8M306yBgQALTbjlujwcDctl7GZwXyIO7oaXICgjMfAEjbbhSYJ\n" +
//        "Su3XUiXBOQZMrV6PhFj2GwfTn09UQ3wtJiYBDnAVRrzJd9FeFm0hSWTpAoGABE80\n" +
//        "Q9DWbKZE6qHR1LWDgfT2LlnJRjxGChm8/vzE6ibvpbPwrKlrpAcUICqTq5H1ZA5o\n" +
//        "5r1AyvlDHcJtqyoxXaZj5MsgTr/dGWvYT9Ib/y2L0vRSXS/sgNoNFYLTY5ULS73R\n" +
//        "zVbADjLJNKXE/51TAiOjIP9T/scH8jc/9wNqXXkCgYAqLQa45nHqDYhK3JS3hxoH\n" +
//        "UEgFtwnokexgKmGj2+VoWVZd8294XDOYoSilp6uk0+RahcS60Xb9eUm7tq6GcOUQ\n" +
//        "jTy8mN9QNErE3wq1TwzzVzwnQLQMkObthFagB2oKUYvdIsOLcwUOCLrid9vfZpQa\n" +
//        "klWJ+DP//+O18g9WRbasNQ==\n"
//
//class WordChatFragment : Fragment() {
//
//    private val messages = mutableListOf<Message>()
//    private lateinit var adapter: ChatAdapter
//    private lateinit var aiDataService: AIDataService
//    private lateinit var binding: FragmentWordChatBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        adapter = ChatAdapter(messages)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentWordChatBinding.inflate(layoutInflater)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.chatRecyclerView.adapter = adapter
//        binding.chatRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//        binding.sendButton.setOnClickListener {
//            val userMessage = binding.messageInput.text.toString()
//            sendMessage(Message(userMessage, true))
//            sendRequest(userMessage)
//            binding.messageInput.text.clear()
//        }
//
////        val config = AIConfiguration(KEY,
////            ai.api.AIConfiguration.SupportedLanguages.English,
////            AIConfiguration.RecognitionEngine.System)
//
//        val config = AIConfiguration(
//            KEY,
//            ai.api.AIConfiguration.SupportedLanguages.English,
//            AIConfiguration.RecognitionEngine.System
//        )
//
//        aiDataService = AIDataService(requireContext(), config)
//    }
//
//    private fun sendMessage(message: Message) {
//        messages.add(message)
//        adapter.notifyDataSetChanged()
//    }
//
//    private fun sendRequest(query: String) {
//        if (::aiDataService.isInitialized) {
//            Thread {
//                try {
//                    val request = AIRequest()
//                    request.setQuery(query)
//
//                    val response = aiDataService.request(request)
//                    val botMessage = response.result.fulfillment.speech
//
//                    Handler(Looper.getMainLooper()).post {
//                        sendMessage(Message(botMessage ?: "", false))
//                        Log.d("WordChatFragment", "Response: ${response.result.toString()}")
//                    }
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                    Log.e("WordChatFragment", "Error during API request: ${e.message}")
//                }
//            }.start()
//        } else {
//            Log.e("WordChatFragment", "aiDataService is not initialized")
//        }
//    }
//}