package example.projeto_marvel.data.remote

import example.projeto_marvel.domain.model.DateMapper

data class DateDTO(
    val date: String,
    val type: String
)

fun DateDTO.date(): DateMapper {
    return DateMapper(
        date = date,
        type = type
    )
}