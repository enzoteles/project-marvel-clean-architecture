package example.projeto_marvel.data.repository

import example.projeto_marvel.data.datasource.MarvelDataSourceApi
import example.projeto_marvel.data.remote.CommicsDTO
import example.projeto_marvel.domain.repository.GetCommicsRepository
import javax.inject.Inject

class GetCommicsRepositoryImpl @Inject constructor(
    private val api: MarvelDataSourceApi
) : GetCommicsRepository {

    override suspend fun getCommics(ts: String, apiKey: String, hash: String): CommicsDTO
        = api.getCommics(ts = ts, apiKey = apiKey, hash = hash)

}