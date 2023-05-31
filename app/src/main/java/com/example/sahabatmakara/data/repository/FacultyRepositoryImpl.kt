package com.example.sahabatmakara.data.repository

import com.example.sahabatmakara.domain.model.FmipaMajor
import com.example.sahabatmakara.domain.repository.FacultyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FacultyRepositoryImpl: FacultyRepository {

    private val fmipaMajor = mutableListOf<FmipaMajor>()

    override fun getFmipaMajor(): Flow<List<FmipaMajor>> {
        return flowOf(fmipaMajor)
    }
}