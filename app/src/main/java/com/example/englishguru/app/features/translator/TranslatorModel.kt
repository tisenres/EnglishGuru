package com.example.englishguru.app.features.translator

import com.example.englishguru.data.network.IRemote
import io.reactivex.disposables.Disposable
import org.koin.java.KoinJavaComponent

class TranslatorModel(private val port: TransModelOutputPort) : ITranslatorModel {

    private val remote: IRemote = KoinJavaComponent.getKoin().get()
    private var transFetchDisposable: Disposable? = null

    override fun fetchWordDataRemotely() {
        transFetchDisposable?.dispose()

        transFetchDisposable = remote.fetchWordDataRemotely()
            .subscribe({ response ->
                port.onFetchComplete()
            }, { error ->
                error.printStackTrace()
            })
    }
}
