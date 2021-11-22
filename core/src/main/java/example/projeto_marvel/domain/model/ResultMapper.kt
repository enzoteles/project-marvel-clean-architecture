package example.projeto_marvel.domain.model

import example.projeto_marvel.data.remote.CharactersDTO

data class ResultMapper(
    val title: String = "",
    val format: String = "",
    val dates: List<DateMapper> = listOf(),
    val prices: List<PriceMapper> = listOf(),
    val stories: StoriesMapper = StoriesMapper(),
    val thumbnail: ThumbnailMapper = ThumbnailMapper()
)