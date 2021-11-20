package example.projeto_marvel.data.remote

import example.projeto_marvel.domain.model.CommicsMapper

data class CommicsDTO(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: DataDTO,
    val etag: String,
    val status: String
)

fun CommicsDTO.toCommics(): CommicsMapper {
    return CommicsMapper(
        copyright = copyright,
        data = data.data()
    )
}