package example.projeto_marvel.data.remote

data class EventsDTO(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)