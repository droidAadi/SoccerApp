package com.droid.data.di

import com.droid.data.mapper.NetworkToEntityMapper
import com.droid.data.models.CompetitionListResponse
import com.droid.data.repositories.CompetitionRepositoryImpl
import com.droid.data.datasource.CompetitionRemoteDataSource
import com.droid.domain.entities.CompetitionListEntity
import com.droid.domain.repositories.CompetitionRepository
import org.koin.dsl.module

/**
 * @author adityakhullar on 21/06/21.
 */

val repositoryModule = module {

    factory {
        provideCompetitionListRepository(get(), get())
    }
}

private fun provideCompetitionListRepository(
    competitionRemoteDataSource: CompetitionRemoteDataSource,
    mapper: NetworkToEntityMapper<CompetitionListResponse, CompetitionListEntity>
): CompetitionRepository {
    return CompetitionRepositoryImpl(
        competitionRemoteDataSource,
        mapper
    )
}