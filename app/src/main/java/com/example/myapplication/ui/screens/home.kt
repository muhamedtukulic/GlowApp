package com.example.myapplication.ui.screens

import HomeViewModel
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.models.Article
import com.example.myapplication.viewmodel.AppViewModelProvider

data class Articles(
    val title: String,
    val description: String,
    val imageResId: Int
)



@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory),

    navController: NavHostController
) {
    val uiState by viewModel.articleUiState.collectAsState()
   Log.d("home",uiState.articlesList.toString())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        uiState.articlesList?.forEachIndexed { index, article ->
            CardElement(article = article, index = index, navController = navController)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}



@Composable
fun CardElement(
    article: Article,
    index: Int,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = {
                when (index) {
                    //article.id
                    0 -> navController.navigate("pager")
                    1 -> navController.navigate("pagerSecond")
                    2 -> navController.navigate("pagerThird")
                }
            })
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 9.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.b4),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(180.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = article.title,
                    style = androidx.compose.ui.text.TextStyle(color = Color.Black),
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = article.description,
                    style = androidx.compose.ui.text.TextStyle(color = Color.Gray)
                )
            }
        }
    }
}



