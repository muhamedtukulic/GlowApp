package com.example.myapplication.ui.screens

import android.util.Log
import android.util.Patterns.EMAIL_ADDRESS
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.viewmodel.AppViewModelProvider
import com.example.myapplication.viewmodel.LoginRegistrationViewModel
import kotlinx.coroutines.launch


@Composable
fun RegistrationScreen(
    viewModel: LoginRegistrationViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordRepeat by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var checkPassword by remember { mutableStateOf(true) }
    var checkEmail by remember { mutableStateOf(false) }
    var uiState = viewModel.userUiState
    var detailsState = uiState.userDetails
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize().wrapContentWidth()
            .padding(vertical = 5.dp)
            .verticalScroll(
                rememberScrollState()
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally


    ) {
        Image(
            painter = painterResource(id = R.drawable.slikeprof),
            contentDescription = "Login Image",
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Register Now!",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(22.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it;
                viewModel.updateUiState(detailsState.copy(name = it))},
            label = { Text(text = "Name", color = Color.Black) },
            placeholder = {
                Text(text = "Name")
            },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next)
            )

        Spacer(modifier = Modifier.height(13.dp))

        OutlinedTextField(
            value = surname,
            onValueChange = { surname = it;
                viewModel.updateUiState(detailsState.copy(surname = it))},
            label = { Text(text = "Surname", color = Color.Black) },
            placeholder = {
                Text(text = "Surname")
            },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next)

            )

        Spacer(modifier = Modifier.height(13.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it;
                viewModel.updateUiState(detailsState.copy(email = it))},
            label = { Text(text = "Email address", color = Color.Black) }
        )

        Spacer(modifier = Modifier.height(13.dp))

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
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = passwordRepeat,
            onValueChange = {passwordRepeat = it},
            label = {
                Text(text = "Repeat password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = !checkPassword,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done)
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                coroutineScope.launch {
                    Log.d("pre register", viewModel.userUiState.toString())
                    if (viewModel.register()) {
                        Log.d("register", viewModel.userUiState.toString())
                    }
                }
            }
        ) {
            Text(text = "Register", fontSize = 23.sp)
        }
        }
    }
fun checkEmail(email: String): Boolean{
    return  EMAIL_ADDRESS.matcher(email).matches()
}

@Preview(showBackground =true)
@Composable
fun RegistrationScreenPreview (){
    RegistrationScreen()


}
