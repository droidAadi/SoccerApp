package com.droid.data.models

/**
 * @author adityakhullar on 20/06/21.
 */
data class CompetitionListResponse(
    val count: Int?,
    val filters: Filters?,
    val competitions: List<Competition>
)

data class Filters(
    val plan: String?
)

data class Competition(
    val id: Int?,
    val name: String?,
    val code: String?,
    val emblemUrl: String?,
    val plan: String?,
    val numberOfAvailableSeasons: Int,
    val area: Area?,
    val currentSeason: CurrentSeason?
)

data class Area(
    val id: Int?,
    val name: String?,
    val countryCode: String?,
    val ensignUrl: String?
)

data class CurrentSeason(
    val id: Int,
    val startDate: String?,
    val endDate: String?,
    val currentMatchDay: Int?,
    val winner: Winner?
)

data class Winner(
    val id: Int?,
    val name: String,
    val shortName: String?,
    val tla: String?,
    val crestUrl: String?
)