package com.droid.soccerapp.di

import com.droid.domain.usecases.GetCompetitionListUseCase
import com.droid.soccerapp.competitions.CompetitionsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author adityakhullar on 07/07/21.
 */


val viewModelsModule = module {
    viewModel { CompetitionsViewModel(get()) }
}

val useCasesModule = module {
    factory { GetCompetitionListUseCase(get()) }
}

