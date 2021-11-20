package example.projeto_marvel.data.remote

import example.projeto_marvel.domain.model.DataMapper

data class DataDTO(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ResultDTO>,
    val total: Int
)

fun DataDTO.data(): DataMapper {
    return DataMapper(
        results = results.map { it.result() }
    )
}