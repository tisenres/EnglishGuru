package com.example.englishguru.app.di

import com.example.englishguru.app.features.main.MainActivity
import com.example.englishguru.app.features.translator.ITranslatorModel
import com.example.englishguru.app.features.translator.ITranslatorPresenter
import com.example.englishguru.app.features.translator.ITranslatorView
import com.example.englishguru.app.features.translator.TransModelOutputPort
import com.example.englishguru.app.features.translator.TranslatorModel
import com.example.englishguru.app.features.translator.TranslatorPresenter
import com.example.englishguru.app.features.words.IWordModel
import com.example.englishguru.app.features.words.IWordPresenter
import com.example.englishguru.app.features.words.IWordView
import com.example.englishguru.app.features.words.WordModel
import com.example.englishguru.app.features.words.WordModelOutputPort
import com.example.englishguru.app.features.words.WordPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val appModule = module {
    single { androidContext() as MainActivity }

    factory<TranslatorPresenter> { (view: ITranslatorView) ->
        TranslatorPresenter(view)
    }

    factory<ITranslatorPresenter> { (view: ITranslatorView) ->
        get<TranslatorPresenter> { parametersOf(view) }
    }

    factory<TransModelOutputPort> { (view: ITranslatorView) ->
        get<TranslatorPresenter> { parametersOf(view) }
    }

    factory<ITranslatorModel> { (presenter: TransModelOutputPort) ->
        TranslatorModel(presenter)
    }

    factory<WordPresenter> { (view: IWordView, startWordPos: Int, endWordPos: Int) ->
        WordPresenter(view, startWordPos, endWordPos)
    }

    factory<IWordPresenter> { (view: IWordView, startWordPos: Int, endWordPos: Int) ->
        get<WordPresenter> { parametersOf(view, startWordPos, endWordPos) }
    }

    factory<WordModelOutputPort> { (view: IWordView, startWordPos: Int, endWordPos: Int) ->
        get<WordPresenter> { parametersOf(view, startWordPos, endWordPos) }
    }

    factory <IWordModel> { (presenter: WordModelOutputPort, startWordPos: Int, endWordPos: Int) ->
        WordModel(presenter, startWordPos, endWordPos)
    }
}