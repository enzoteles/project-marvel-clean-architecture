package example.projeto_marvel.data.remote

import example.projeto_marvel.domain.model.StoriesMapper

data class StoriesDTO(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXDTO>,
    val returned: Int
)

fun StoriesDTO.store(): StoriesMapper {
    return StoriesMapper(
        collectionURI = collectionURI
    )
}