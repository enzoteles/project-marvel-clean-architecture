package example.projeto_marvel.data.remote

data class CreatorsDTO(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXDTO>,
    val returned: Int
)