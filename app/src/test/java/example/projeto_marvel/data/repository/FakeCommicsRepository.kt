package example.projeto_marvel.data.repository

import example.projeto_marvel.data.remote.*
import example.projeto_marvel.domain.model.CommicsMapper
import example.projeto_marvel.domain.model.ResultMapper
import example.projeto_marvel.domain.repository.GetCommicsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeCommicsRepository : GetCommicsRepository{

    private val commic = CommicsDTO(
        attributionHTML = "<a href=\\\"http://marvel.com\\\">Data provided by Marvel. © 2021 MARVEL</a>",
        attributionText = "Data provided by Marvel. © 2021 MARVEL",
        etag = "2d2b9d3000a92d04b28337c8212edad0fac92a3b",
        code = 200,
        status = "ok",
        copyright = "© 2021 MARVEL",
        data = DataDTO(
            offset = 0,
            limit = 20,
            total = 50286,
            count = 20,
            results = listOf(ResultDTO(
                id = 82967,
                digitalId = 0,
                title = "Marvel Previews (2017)",
                issueNumber = 0,
                variantDescription = "",
                description = "",
                modified = "2019-11-07T08:46:15-0500",
                isbn = "",
                upc =  "",
                diamondCode = "",
                ean = "",
                resourceURI = "",
                urls = listOf(),
                issn = "",
                format = "",
                pageCount = 112,
                textObjects = listOf(),
                series = SeriesDTO("", ""),
                variants = listOf(),
                collectedIssues = listOf(),
                collections = listOf(),
                images = listOf(),
                creators = CreatorsDTO(0, "", listOf(), 0),
                characters = CharactersDTO(0,"", listOf(), 0),
                stories = StoriesDTO(0,"", listOf(), 0),
                events = EventsDTO(0,"", listOf(),0),
                dates = listOf(DateDTO("onsaleDate", "2099-08-28T00:00:00-0500")),
                prices = listOf(PriceDTO(10.0, "mprintPrice")),
                thumbnail = ThumbnailDTO("http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available", "jpg"),
            ))
        )

    )

    override suspend fun getCommics(ts: String, apiKey: String, hash: String): CommicsDTO {
        return commic
    }

}