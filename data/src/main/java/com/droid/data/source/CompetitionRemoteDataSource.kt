package com.droid.data.source

import com.droid.data.models.CompetitionListResponse
import com.droid.data.networkclient.RemoteNetworkClient
import com.droid.data.networkclient.SoccerApiService
import com.droid.domain.Result
import retrofit2.Response

/**
 * @author adityakhullar on 21/06/21.
 */
internal class CompetitionRemoteDataSource(private val remoteNetworkClient: RemoteNetworkClient) :
    DataSource() {

    suspend fun fetchCompetitionList(): Result<CompetitionListResponse> {
        val soccerApiService = remoteNetworkClient.createService(SoccerApiService::class.java)

        return getResponse(
            request = { soccerApiService.getCompetitions() },
            defaultErrorMessage = "Error while fetching Competitions list"
        )
    }

    override suspend fun <T : Any> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: String
    ): Result<T> {
        return try {
            val result = request.invoke()
            if (result.isSuccessful) {
                return Result.Success(result.body())
            } else {
                Result.Failure(defaultErrorMessage)
            }
        } catch (e: Throwable) {
            Result.Failure("Unknown Error")
        }
    }
}