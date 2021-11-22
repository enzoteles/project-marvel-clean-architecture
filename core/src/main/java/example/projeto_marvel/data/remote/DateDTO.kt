package example.projeto_marvel.data.remote

import example.projeto_marvel.common.DateTimeHelper
import example.projeto_marvel.domain.model.DateMapper

data class DateDTO(
    val date: String,
    val type: String
)

fun DateDTO.date(): DateMapper {
    return DateMapper(
        date = DateTimeHelper.convertToDate(date, "yyyy-MM-dd", "dd/MM/yyyy"),
        type = type
    )
}