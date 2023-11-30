package com.example.englishguru.app.features.translator

import android.util.Log
import com.example.englishguru.data.network.IRemote
import io.reactivex.disposables.Disposable
import org.koin.java.KoinJavaComponent

class TranslatorModel(private val port: TransModelOutputPort) : ITranslatorModel {

    private val remote: IRemote = KoinJavaComponent.getKoin().get()
    private var transFetchDisposable: Disposable? = null

    override fun fetchWordDataRemotely(
        apiKey: String,
        text: String,
        sourceLang: String,
        targetLang: String
    ) {
        transFetchDisposable?.dispose()

        transFetchDisposable = remote.fetchTranslationData(apiKey, text, sourceLang, targetLang)
            .subscribe({ response ->
                port.onFetchComplete()
                Log.d("RESPONSESEEEE", response.translations[0].text)
            }, { error ->
                error.printStackTrace()
            })
    }
}
