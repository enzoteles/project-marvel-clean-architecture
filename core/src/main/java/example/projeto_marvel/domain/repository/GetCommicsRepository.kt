package example.projeto_marvel.domain.repository

import example.projeto_marvel.data.remote.CommicsDTO
import retrofit2.http.Query

interface GetCommicsRepository {

    suspend fun getCommics(
        ts: String,
        apiKey: String,
        hash: String,
    ): CommicsDTO
}