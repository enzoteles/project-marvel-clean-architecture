package example.projeto_marvel.data.remote

import example.projeto_marvel.domain.model.ThumbnailMapper

data class ThumbnailDTO(
    val extension: String,
    val path: String
)

fun ThumbnailDTO.thumbanail(): ThumbnailMapper {
    return ThumbnailMapper(
        extension = extension,
        path = path
    )
}