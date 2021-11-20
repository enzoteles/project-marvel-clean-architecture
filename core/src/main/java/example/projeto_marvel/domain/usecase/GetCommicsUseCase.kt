package example.projeto_marvel.domain.usecase

import example.projeto_marvel.common.Resource
import example.projeto_marvel.data.remote.CommicsDTO
import example.projeto_marvel.data.remote.toCommics
import example.projeto_marvel.domain.model.CommicsMapper
import example.projeto_marvel.domain.repository.GetCommicsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCommicsUseCase @Inject constructor(
    private val repository: GetCommicsRepository
){

    operator fun invoke(ts: String, apiKey: String, hash: String): Flow<Resource<CommicsMapper>> = flow {

        try {
            emit(Resource.Loading())
            val commics = repository.getCommics(ts = ts, apiKey = apiKey, hash = hash)
            emit(Resource.Success(commics.toCommics()))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage))
        }catch (e: IOException){
            emit(Resource.Error(e.message!!))
        }
    }

}

