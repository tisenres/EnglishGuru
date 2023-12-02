package com.example.englishguru.app.features.translator

import com.example.englishguru.data.network.IRemote
import io.reactivex.disposables.Disposable
import org.koin.core.component.KoinComponent

class TranslatorModel(private val port: TransModelOutputPort) : ITranslatorModel, KoinComponent {

    private val remote: IRemote = getKoin().get()
    private var transFetchDisposable: Disposable? = null

    override fun fetchWordDataRemotely(
        text: String,
        sourceLang: String,
        targetLang: String
    ) {
        transFetchDisposable?.dispose()

        transFetchDisposable = remote.fetchTranslationData(text, sourceLang, targetLang)
            .subscribe({ response ->
                port.onFetchComplete(response.translations.first().translated.first())
            }, { error ->
                error.printStackTrace()
            })
    }
}
