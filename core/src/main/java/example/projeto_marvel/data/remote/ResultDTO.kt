package example.projeto_marvel.data.remote

import example.projeto_marvel.domain.model.ResultMapper

data class ResultDTO(
    val characters: CharactersDTO,
    val collectedIssues: List<CollectedIssueDTO>,
    val collections: List<Any>,
    val creators: CreatorsDTO,
    val dates: List<DateDTO>,
    val description: Any,
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
    val events: EventsDTO,
    val format: String,
    val id: Int,
    val images: List<ImageDTO>,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val prices: List<PriceDTO>,
    val resourceURI: String,
    val series: SeriesDTO,
    val stories: StoriesDTO,
    val textObjects: List<TextObjectDTO>,
    val thumbnail: ThumbnailDTO,
    val title: String,
    val upc: String,
    val urls: List<UrlDTO>,
    val variantDescription: String,
    val variants: List<VariantDTO>
)

fun ResultDTO.result(): ResultMapper {
    return ResultMapper(
        dates = dates.map { it.date() },
        prices = prices.map { it.price() },
        stories = stories.store(),
        thumbnail = thumbnail.thumbanail(),
        title = title,
        format = format
    )
}