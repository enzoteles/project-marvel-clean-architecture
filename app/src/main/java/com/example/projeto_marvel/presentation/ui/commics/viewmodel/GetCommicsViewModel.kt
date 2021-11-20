package com.example.projeto_marvel.presentation.ui.commics.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projeto_marvel.presentation.ui.commics.components.GetCommicsState
import dagger.hilt.android.lifecycle.HiltViewModel
import example.projeto_marvel.common.Resource
import example.projeto_marvel.domain.usecase.GetCommicsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GetCommicsViewModel @Inject constructor(
    private val getCommicsUseCase: GetCommicsUseCase
) :ViewModel(){

    private var _state = MutableLiveData<GetCommicsState>()
    val state: LiveData<GetCommicsState> = _state

    fun getCommics(ts: String, apiKey: String, hash: String){
        getCommicsUseCase(ts = ts, apiKey = apiKey, hash = hash).onEach { result->

            when(result){
                is Resource.Success ->{
                    _state.value = GetCommicsState(
                        commics = result.data
                    )
                }
                is Resource.Error ->{
                    _state.value = GetCommicsState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading ->{
                    _state.value = GetCommicsState(
                        isLoadding = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}

