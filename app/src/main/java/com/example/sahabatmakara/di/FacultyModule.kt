package com.example.sahabatmakara.di

import com.example.sahabatmakara.data.repository.FacultyRepositoryImpl
import com.example.sahabatmakara.domain.repository.FacultyRepository
import com.example.sahabatmakara.domain.usecase.FacultyInteractor
import com.example.sahabatmakara.domain.usecase.FacultyUseCase
import org.koin.dsl.module

val facultyModule = module {
    single<FacultyRepository> { FacultyRepositoryImpl() }
    single<FacultyUseCase> { FacultyInteractor(get())}
}