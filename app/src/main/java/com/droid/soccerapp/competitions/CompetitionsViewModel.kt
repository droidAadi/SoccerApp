package com.droid.soccerapp.competitions

import android.util.Log
import androidx.lifecycle.*
import com.droid.domain.Result
import com.droid.domain.entities.CompetitionListEntity
import com.droid.domain.usecases.GetCompetitionListUseCase
import com.droid.soccerapp.base.BaseViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart

/**
 * @author adityakhullar on 21/06/21.
 */
class CompetitionsViewModel(var competitionListUseCase: GetCompetitionListUseCase) :
    BaseViewModel() {

    private var competitionsLiveData = MutableLiveData<CompetitionListEntity?>()

    fun fetchCompetitions() {

        viewModelScope.launch {
            competitionListUseCase.invoke().onStart {
                //Show Loading
            }.catch {
                // Handle error
            }.collect { result ->
                if (result is Result.Success) {
                    competitionsLiveData.value = result.data
                    Log.d("---TAG---", "" + result.data?.count)
                } else {
                    // show error
                }
            }
        }


//        liveData {
//            competitionListUseCase.invoke().onStart {
//
//            }.catch {
//
//            }.collect {
//                if (it is Result.Success) {
//                    val data = it.data
//                    emit(data)
//                } else {
//                    //Show error
//                }
//            }
//        }

    }
}
