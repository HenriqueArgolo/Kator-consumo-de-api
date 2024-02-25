package screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.seiko.imageloader.rememberImagePainter

data class ProductsDetails(
    val id: String,
    val name:  String,
    val img: String,
    val price: String,
    val description : String


) : Screen {


    @Composable
    override fun Content() {
        val backToMain = LocalNavigator.currentOrThrow


        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = Color.Black
                ) {
                    IconButton(
                        onClick = {
                            backToMain.pop()
                        }

                    ) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = null,
                            tint = Color.White
                        )


                    }

                    Text(
                        "Detalhes do produto",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
            },

            ) {
            Column(
                modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(name,
                    modifier = Modifier.padding(20.dp, 20.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold)

               Image(
                   painter = rememberImagePainter(img),
                   contentDescription = null,
                   modifier = Modifier.fillMaxWidth().height(200.dp).padding(20.dp, 0.dp)
               )

                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color.Red,
                        contentColor = Color.White),

                    border = BorderStroke(2.dp, Color.Red),

                    modifier = Modifier.fillMaxWidth().padding(20.dp,20.dp)
                ){
                    Text("Comprar",
                        fontSize = 15.sp,
                        )
                }
                Text(description,
                    modifier = Modifier.padding(20.dp, 20.dp))
            }
        }
    }

}