package liste_item

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.seiko.imageloader.rememberImagePainter
import model.Produto
import screens.ProductsDetails

@Composable
fun ProductItem(
    produto: Produto
){
    val img = produto.img
    val title = produto.name
    val preco = produto.price
    val description = produto.description
    val localNavigator = LocalNavigator.currentOrThrow

    Column(
        modifier = Modifier.fillMaxWidth().background(Color.Gray).padding(10.dp).clip(RoundedCornerShape(10.dp)),
        verticalArrangement = Arrangement.SpaceEvenly,

    ){
        Row (modifier = Modifier.fillMaxWidth().background(Color.White).padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
            Image(
                painter = rememberImagePainter(img!!),
                contentDescription = null,
                modifier = Modifier.width(100.dp).height(100.dp).padding(0.dp, 0.dp, 10.dp, 0.dp)
            )

            Text(
                title!!,
                fontSize = 15.sp
            )

        }

        Column (modifier =  Modifier.fillMaxWidth().background(Color.White).padding(10.dp),
            ){
            Text(preco!!,
                color = Color.Red,
                fontSize = 15.sp,
                modifier = Modifier.padding(110.dp, 5.dp)

            )

            Text("A vista",
                fontSize = 12.sp,
                modifier = Modifier.padding(110.dp,  0.dp, 0.dp, 10.dp))

            Button(
                onClick = {
                    localNavigator.push(ProductsDetails(
                        id = "dsfkgdjh4358sdakgjksdgacx",
                        name = title!!,
                        img =  img!!,
                        price = preco,
                        description = description!!

                    ))
                },
                modifier = Modifier.fillMaxWidth().height(50.dp).padding(20.dp, 5.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Red),

                border = BorderStroke(2.dp, Color.Red)
            ){
            Text("Promoção termina em 15D")
        }

        }

    }

}