package com.example.myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.model.models.Posts


@Composable
fun SinglePage(
    page: Posts
) {

    val coroutineScope = rememberCoroutineScope()




    Column(
        modifier= Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Image(
            painter = painterResource(id = R.drawable.b11),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(180.dp)
        )
        Divider(modifier=Modifier.padding(vertical = 12.dp))
        Text(text=page.title,
            fontWeight = FontWeight.W500,
            fontSize = 18.sp,
            color = Color.Black)
        Spacer(modifier=Modifier.size(12.dp), )
        Text(text=page.text,fontWeight = FontWeight.W400,
            fontSize = 18.sp,
            color = Color.Black)

    }


}



