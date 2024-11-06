package com.example.myapplication.ui.screens
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.viewmodel.AppViewModelProvider
import com.example.myapplication.viewmodel.LoginRegistrationViewModel
import kotlinx.coroutines.launch




@Composable
fun LoginScreen(
    viewModel: LoginRegistrationViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {




    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var uiState = viewModel.userUiState
    var detailsState = uiState.userDetails
    val coroutineScope = rememberCoroutineScope()
    var showPassword by remember { mutableStateOf(false) }




    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.slikeprof),
            contentDescription = "Login Image",
            modifier = Modifier.size(120.dp)
        )

        Text(
            text = "Welcome Back!",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Login to your account.",
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it;
                viewModel.updateUiState(detailsState.copy(email = it))},
            label = { Text(text = "Email address", color = Color.Black) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it
                    viewModel.updateUiState(detailsState.copy(password = it))},
            label = { Text(text = "Password", color = Color.Black) },
            visualTransformation = if(showPassword) { VisualTransformation.None}
            else { PasswordVisualTransformation()},

            trailingIcon = {
                Icon(
                    painter =
                    if (showPassword) {
                        painterResource(id = R.drawable.baseline_visibility_24)}
                    else {painterResource(id = R.drawable.baseline_visibility_off_24)},
                    contentDescription = "Toggle password visibility",
                    modifier = Modifier.clickable { showPassword = !showPassword }
                )
            }

        )

        Spacer(modifier = Modifier.height(19.dp))

        Button(
            onClick = {
                coroutineScope.launch {
                    Log.d("pre login", viewModel.userUiState.toString())
                    if (viewModel.login()) {
                        Log.d("login", viewModel.userUiState.toString())
                    }
                }
            }
        ) {
            Text(text = "Login", fontSize = 23.sp)
        }


        Spacer(modifier = Modifier.height(16.dp))

        Column {


            Spacer(modifier = Modifier.height(8.dp))


        }


    }
}







@Preview
@Composable
fun LoginScreenPreview (){
    LoginScreen();


}