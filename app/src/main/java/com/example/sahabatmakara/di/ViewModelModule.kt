package com.example.sahabatmakara.di

import com.example.sahabatmakara.presentation.screen.detailfaculty.fmipa.FmipaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { FmipaViewModel(get()) }
}