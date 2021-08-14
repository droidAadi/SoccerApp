package com.droid.data.datasource

import com.droid.data.models.CompetitionListResponse
import com.droid.data.networkclient.RemoteNetworkClient
import com.droid.data.networkclient.SoccerApiService
import com.droid.domain.Result

/**
 * @author adityakhullar on 21/06/21.
 */
internal class CompetitionRemoteDataSourceImpl(private val remoteNetworkClient: RemoteNetworkClient) :
    CompetitionRemoteDataSource {

    override suspend fun fetchCompetitionList(): Result<CompetitionListResponse> {
        val soccerApiService = remoteNetworkClient.createService(SoccerApiService::class.java)

        return getResponse(
            request = { soccerApiService.getCompetitions() },
            defaultErrorMessage = "Error while fetching Competitions list"
        )
    }
}