package com.droid.data.repositories

import com.droid.data.mapper.NetworkToEntityMapper
import com.droid.data.models.CompetitionListResponse
import com.droid.data.source.CompetitionRemoteDataSource
import com.droid.domain.Result
import com.droid.domain.entities.CompetitionListEntity
import com.droid.domain.repositories.CompetitionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

/**
 * @author adityakhullar on 21/06/21.
 */
internal class CompetitionRepositoryImpl(
    private val competitionRemoteDataSource: CompetitionRemoteDataSource,
    private val competitionListMapper: NetworkToEntityMapper<CompetitionListResponse, CompetitionListEntity>
) : CompetitionRepository {

    override suspend fun getCompetitions(): Flow<Result<CompetitionListEntity>> {

        //Here the decision should be taken if we want to fetch data from Remote Data Source or Offline data source
        //As of now, we only fetch it from Remote Data Source
        var flows: Flow<Result<CompetitionListEntity>>
        withContext(Dispatchers.IO) {
            flows = flow {
                val newResult: Result<CompetitionListEntity>
                val result = competitionRemoteDataSource.fetchCompetitionList()
                if (result is Result.Success) {
                    val data = result.data as CompetitionListResponse
                    val convertedResponse = competitionListMapper.convert(data)
                    newResult = Result.Success(convertedResponse)
                } else {
                    newResult = Result.Failure("Something Went Wrong!!")
                }
                emit(newResult)
            }
        }

        return flows
    }

}