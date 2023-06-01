package com.example.sahabatmakara.data.repository

import com.example.sahabatmakara.R
import com.example.sahabatmakara.data.source.FmipaMajorData
import com.example.sahabatmakara.domain.model.FmipaMajor
import com.example.sahabatmakara.domain.interfaces.FacultyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FacultyRepositoryImpl: FacultyRepository {

    private val fmipaMajor = mutableListOf<FmipaMajor>()

    override fun getFmipaMajor(): Flow<List<FmipaMajor>> {
        return flowOf(fmipaMajor)
    }

    override fun getDetailFmipaMajor(major: String): Flow<FmipaMajor> {
        val fmipaMajor = FmipaMajorData.fmipaListMajor.firstOrNull { it.major == major }
        return if (fmipaMajor != null) {
            flowOf(fmipaMajor)
        } else {
            flowOf(FmipaMajor(R.drawable.ic_fmipa_ui, "Unknown", "Unknown", "Unknown", "Unknown"))
        }
    }
}

