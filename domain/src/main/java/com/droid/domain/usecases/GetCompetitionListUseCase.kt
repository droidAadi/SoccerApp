package com.droid.domain.usecases

import com.droid.domain.Result
import com.droid.domain.entities.CompetitionListEntity
import com.droid.domain.repositories.CompetitionRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow


/**
 * @author adityakhullar on 20/06/21.
 */

class GetCompetitionListUseCase(private val competitionRepository: CompetitionRepository) :
    FlowUseCase {
    suspend operator fun invoke(): Flow<Result<CompetitionListEntity>> {
        return competitionRepository.getCompetitions()
    }
}