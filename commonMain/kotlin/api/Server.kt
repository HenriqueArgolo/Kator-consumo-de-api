package api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsChannel
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import model.Produto

class Server {

    suspend fun getProducts():  Flow<MutableList<Produto>>{
        val client = HttpClient{

            install(ContentNegotiation){
                json()
            }
            install(HttpCache)
        }
        val products = client
            .get("https://firebasestorage.googleapis.com/v0/b/app-de-filmes-46b29.appspot.com/o/lojavirtual.json?alt=media&token=22b6dce7-ea6d-49ba-b37a-4adf02ec38bf")
            .body<MutableList<Produto>>()
        return MutableStateFlow(products)
    }
}