package com.example.projeto_marvel.presentation.ui.list_characters.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Constraints
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projeto_marvel.presentation.ui.list_characters.components.GetCommicsState
import dagger.hilt.android.lifecycle.HiltViewModel
import example.projeto_marvel.common.Constants
import example.projeto_marvel.common.Resource
import example.projeto_marvel.domain.usecase.GetCommicsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Inject

@HiltViewModel
class GetCommicsViewModel @Inject constructor(
    private val getCommicsUseCase: GetCommicsUseCase
) :ViewModel(){


    private var _state = mutableStateOf(GetCommicsState())
    val state: State<GetCommicsState> = _state

    init {
        val str1 = "${Constants.TS}${Constants.PRIVATE_KEY}${Constants.PUBLIC_KEY}"
        val str = md5(str1)
        getCommics(Constants.TS, Constants.PUBLIC_KEY, str)
    }

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

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}

