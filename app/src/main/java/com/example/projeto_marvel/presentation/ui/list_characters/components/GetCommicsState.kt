package com.example.projeto_marvel.presentation.ui.list_characters.components

import example.projeto_marvel.domain.model.CommicsMapper

data class GetCommicsState(
    val isLoadding: Boolean = false,
    val commics: CommicsMapper?= null,
    val error: String = ""
)


