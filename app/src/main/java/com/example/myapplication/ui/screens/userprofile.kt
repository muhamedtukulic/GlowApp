package com.example.myapplication.ui.screens

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.viewmodel.AppViewModelProvider
import com.example.myapplication.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    viewModel: UserViewModel = viewModel(factory = AppViewModelProvider.Factory)
){
    var name = "Ajla"
    var surname = "Cakic"
    var email = "ajlacakic@gmail.com"

    var dropDownItem by remember { mutableStateOf("") }
    var expandedItems by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()


    Log.d("profile", viewModel.userUiState.toString() )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    ) {
        ProfileImage()

        Spacer(modifier = Modifier.size(height = 30.dp, width = 0.dp))

        Row{
            OutlinedTextField(
                value = name,
                onValueChange = {},
                label = {
                    Text(text = "Name")
                },
                isError = false,
                readOnly = true,
                modifier = Modifier.width(135.dp)
            )
            Spacer(modifier = Modifier.size(height = 0.dp, width = 5.dp))
            OutlinedTextField(
                value = surname,
                onValueChange = {},
                label = {
                    Text(text = "Surname")
                },
                isError = false,
                readOnly = true,
                modifier = Modifier.width(135.dp)
            )
        }
        Spacer(modifier = Modifier.size(height = 10.dp, width = 0.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {},
            label = {
                Text(text = "Email")
            },
            isError = false,
            readOnly = true
        )
        Spacer(modifier = Modifier.size(height = 10.dp, width = 0.dp))
        Box() {



        }

        Spacer(modifier = Modifier.size(height = 30.dp, width = 0.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable {
                    val i = Intent(Intent.ACTION_SEND)
                    val emailAddress = arrayOf(email)
                    i.putExtra(Intent.EXTRA_EMAIL, emailAddress)
                    i.setType("message/rfc822")
                    try {
                        context.startActivity(Intent.createChooser(i, "Choose an Email client : "))
                    } catch (s: SecurityException) {
                        Toast
                            .makeText(context, "An error occurred", Toast.LENGTH_LONG).show()
                    }
                }
                .align(Alignment.Start)
        ) {
            Icon(Icons.Default.MailOutline, contentDescription = null, modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.size(width = 20.dp, height = 0.dp))
            Text(text = email)
        }


        Spacer(modifier = Modifier.size(height = 20.dp, width = 0.dp))



    }

}

@Composable
fun OutlinedTextField1(
    value: String,
    onValueChange: () -> Unit,
    label: () -> Unit,
    isError: Boolean,
    readOnly: Boolean
) {
    TODO("Not yet implemented")
}


@Composable
fun ProfileImage(){
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val bitmap = remember { mutableStateOf<Bitmap?>(null)}

    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(contract =
    ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri
    }

    imageUri?.let {
        if (Build.VERSION.SDK_INT < 28) {
            bitmap.value = MediaStore.Images
                .Media.getBitmap(context.contentResolver,it)
        } else {
            val source = ImageDecoder
                .createSource(context.contentResolver,it)
            bitmap.value = ImageDecoder.decodeBitmap(source)
        }
    }

    if(bitmap.value != null){
        bitmap.value?.let{
                btm ->
            Image(bitmap = btm.asImageBitmap(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp)
                    .clip(CircleShape)
            )
        }
    } else{
        Image(
            painterResource(id = R.drawable.slikeprof),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
                .clickable { launcher.launch("image/*") }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    ProfileScreen()
}

@Preview(showBackground = true)
@Composable
fun ProfileImagePreview(){
    ProfileImage()
}
