package com.droid.data.networkclient

import com.droid.data.models.CompetitionListResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author adityakhullar on 18/06/21.
 */


internal interface SoccerApiService : ApiService {

    @GET(EndPoints.COMPETITIONS)
    suspend fun getCompetitions(): Response<CompetitionListResponse>

}