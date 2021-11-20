package example.projeto_marvel.data.datasource

import example.projeto_marvel.data.remote.CommicsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelDataSourceApi {

    @GET("comics")
    suspend fun getCommics(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        ): CommicsDTO

}