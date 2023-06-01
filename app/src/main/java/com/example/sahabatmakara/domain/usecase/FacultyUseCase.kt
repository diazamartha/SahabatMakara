package com.example.sahabatmakara.domain.usecase

import com.example.sahabatmakara.domain.model.FmipaMajor
import kotlinx.coroutines.flow.Flow

interface FacultyUseCase {

    fun getFmipaMajor(): Flow<List<FmipaMajor>>

    fun getDetailFmipaMajor(major: String): Flow<FmipaMajor>
}