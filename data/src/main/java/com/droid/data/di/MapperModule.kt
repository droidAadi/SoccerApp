package com.droid.data.di

import com.droid.data.mapper.CompetitionListMapper
import com.droid.data.mapper.NetworkToEntityMapper
import com.droid.data.models.CompetitionListResponse
import com.droid.domain.entities.CompetitionListEntity
import org.koin.dsl.module

/**
 * @author adityakhullar on 21/06/21.
 */


val mapperModule = module {
    factory {
        provideCompetitionListMapper()
    }
}

private fun provideCompetitionListMapper()
        : NetworkToEntityMapper<CompetitionListResponse, CompetitionListEntity> {
    return CompetitionListMapper()
}