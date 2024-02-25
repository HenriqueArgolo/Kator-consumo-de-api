package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import api.Server
import cafe.adriel.voyager.core.screen.Screen
import liste_item.ProductItem
import model.Produto

data class Home(val id: String): Screen{

    @Composable
    override fun Content() {

        val server = Server()
        var productList by remember { mutableStateOf(mutableListOf<Produto>()) }
        var loading by remember { mutableStateOf(true) }


        LaunchedEffect(Unit){
            server.getProducts().collect { productListServer ->
                productList = productListServer
                loading = false

            }
        }

        if (loading){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text("Carregando", fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.Bold )
            }
        }else{
            Column(modifier = Modifier.fillMaxSize().background(Color.Gray)){
                LazyColumn { itemsIndexed(productList){_, product ->
                    ProductItem(produto = product)
                } }
            }

        }

    }

}

