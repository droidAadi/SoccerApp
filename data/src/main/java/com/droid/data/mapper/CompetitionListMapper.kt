package com.droid.data.mapper

import com.droid.data.models.CompetitionListResponse
import com.droid.domain.entities.Competition
import com.droid.domain.entities.CompetitionListEntity

/**
 * @author adityakhullar on 21/06/21.
 */
class CompetitionListMapper :
    NetworkToEntityMapper<CompetitionListResponse, CompetitionListEntity> {

    override fun convert(source: CompetitionListResponse): CompetitionListEntity {
        //todo: Add the logic to convert data from source to entity
        val competitionListEntity = CompetitionListEntity(source.count, null)
        return competitionListEntity
    }
}