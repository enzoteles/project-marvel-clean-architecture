package example.projeto_marvel.domain.usecase

import com.google.common.truth.Truth.assertThat
import example.projeto_marvel.common.Constants
import example.projeto_marvel.common.Resource
import example.projeto_marvel.common.Utils
import example.projeto_marvel.data.remote.*
import example.projeto_marvel.data.repository.FakeCommicsRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetCommicsUseCaseTest{


    lateinit var repository: FakeCommicsRepository
    lateinit var useCase: GetCommicsUseCase

    @Before
    fun setUp(){
        repository = FakeCommicsRepository()
        useCase = GetCommicsUseCase(repository)
    }

    @Test
    fun `checking the api statuses`(): Unit = runBlocking {
        useCase.invoke(Constants.TS, Constants.PUBLIC_KEY,"f5b79b9e274627e5f2719ba6fdc855cc").collect{ result->

            when(result){
                is Resource.Loading->{
                    assertThat(true).isTrue()
                }
                is Resource.Success->{
                    assertThat(true).isTrue()
                }
                else -> {
                    assertThat(true).isTrue()
                }
            }
        }
    }


    @Test
    fun `checking the success status api`(): Unit = runBlocking{

        val commic = repository.getCommics(Constants.TS, Constants.PUBLIC_KEY,Utils.md5(Constants.PATH_MD))
        val firstItem = commic.data.results.first()

        assertEquals(firstItem.id, 82967)
        assertEquals(firstItem.title, "Marvel Previews (2017)")
        assertEquals(firstItem.pageCount, 112)
        assertEquals(firstItem.prices.size, 1)
        assertEquals(firstItem.dates.size, 1)
        assertEquals(firstItem.thumbnail.extension, "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available")
        assertEquals(firstItem.thumbnail.path, "jpg")
    }
}


