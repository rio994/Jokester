package com.levelup.jokester.di

import com.levelup.jokester.ui.search.SearchJokesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { SearchJokesViewModel() }

}