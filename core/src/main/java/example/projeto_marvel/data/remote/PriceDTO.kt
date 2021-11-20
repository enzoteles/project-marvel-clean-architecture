package example.projeto_marvel.data.remote

import example.projeto_marvel.domain.model.PriceMapper

data class PriceDTO(
    val price: Double,
    val type: String
)

fun PriceDTO.price(): PriceMapper {
    return PriceMapper(
        price = price,
        type = type
    )
}