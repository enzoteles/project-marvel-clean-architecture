package example.projeto_marvel.data.remote

data class CharactersDTO(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemDTO>,
    val returned: Int
)