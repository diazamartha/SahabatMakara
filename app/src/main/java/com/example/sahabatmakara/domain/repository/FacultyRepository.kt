package com.example.sahabatmakara.domain.repository

import com.example.sahabatmakara.domain.model.FmipaMajor
import com.example.sahabatmakara.domain.model.UiMajor
import kotlinx.coroutines.flow.Flow

interface FacultyRepository {

    fun getFmipaMajor(): Flow<List<FmipaMajor>>
}