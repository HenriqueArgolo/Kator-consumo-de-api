package model

import kotlinx.serialization.Serializable

@Serializable
data class Produto (
    val name :String? = null,
    val img : String? = null,
    val price: String? =null,
    val description: String? =  null,
    val id: Int? = null
)


