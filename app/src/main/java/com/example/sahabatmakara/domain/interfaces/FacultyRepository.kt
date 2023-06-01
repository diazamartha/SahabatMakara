package com.example.sahabatmakara.domain.interfaces

import com.example.sahabatmakara.domain.model.FmipaMajor
import kotlinx.coroutines.flow.Flow

interface FacultyRepository {

    fun getFmipaMajor(): Flow<List<FmipaMajor>>

    fun getDetailFmipaMajor(major: String): Flow<FmipaMajor>
}