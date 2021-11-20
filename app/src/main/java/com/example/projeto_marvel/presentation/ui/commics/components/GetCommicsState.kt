package com.example.projeto_marvel.presentation.ui.commics.components

import example.projeto_marvel.data.remote.CommicsDTO
import example.projeto_marvel.domain.model.CommicsMapper

data class GetCommicsState(
    val isLoadding: Boolean = false,
    val commics: CommicsMapper?= null,
    val error: String = ""
)


