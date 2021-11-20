package example.projeto_marvel.domain.model

data class ResultMapper(
    val dates: List<DateMapper>,
    val prices: List<PriceMapper>,
    val stories: StoriesMapper,
    val thumbnail: ThumbnailMapper
)