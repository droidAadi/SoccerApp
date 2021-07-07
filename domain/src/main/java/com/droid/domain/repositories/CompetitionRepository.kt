package com.droid.domain.repositories

import com.droid.domain.Result
import com.droid.domain.entities.CompetitionListEntity
import kotlinx.coroutines.flow.Flow

/**
 * @author adityakhullar on 20/06/21.
 */

interface CompetitionRepository {
    suspend fun getCompetitions(): Flow<Result<CompetitionListEntity>>
}