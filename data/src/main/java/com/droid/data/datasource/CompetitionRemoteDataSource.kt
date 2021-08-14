package com.droid.data.datasource

import com.droid.data.models.CompetitionListResponse
import com.droid.domain.Result

/**
 * @author adityakhullar on 09/07/21.
 */
internal interface CompetitionRemoteDataSource : RemoteDataSource {
    suspend fun fetchCompetitionList(): Result<CompetitionListResponse>
}