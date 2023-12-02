package com.example.englishguru.app.di

import com.example.englishguru.app.features.main.MainActivity
import com.example.englishguru.app.features.translator.ITranslatorModel
import com.example.englishguru.app.features.translator.ITranslatorPresenter
import com.example.englishguru.app.features.translator.ITranslatorView
import com.example.englishguru.app.features.translator.TransModelOutputPort
import com.example.englishguru.app.features.translator.TranslatorModel
import com.example.englishguru.app.features.translator.TranslatorPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val appModule = module {
    single { androidContext() as MainActivity }

    factory<TranslatorPresenter> { (view: ITranslatorView) ->
        TranslatorPresenter(view)
    }

    single<ITranslatorPresenter> { (view: ITranslatorView) ->
        get<TranslatorPresenter> { parametersOf(view) }
    }

    single<TransModelOutputPort> { (view: ITranslatorView) ->
        get<TranslatorPresenter> { parametersOf(view) }
    }

    single<ITranslatorModel> { (presenter: TransModelOutputPort) ->
        TranslatorModel(presenter)
    }

    // Word
//    factory<IWordPresenter> {
//            (view: IWordView, startWordPos: Int, endWordPos: Int) -> WordPresenter(view, startWordPos, endWordPos)
//    }
//    factory<IWordModel> {
//            (port: OutputPortModel, startWordPos: Int, endWordPos: Int) -> WordModel(port, startWordPos, endWordPos)
//    }
}