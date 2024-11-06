package com.example.myapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.repositories.UserRepository
import kotlinx.coroutines.flow.first

class LoginRegistrationViewModel(private val userRepository: UserRepository): ViewModel() {
    /**
     * Holds current item ui state
     */
    var userUiState by mutableStateOf(UserUiState())
        private set

    suspend fun register(): Boolean{
        if (validateInput()){
            userRepository.insert(userUiState.userDetails.toUser())
            return true
        }else return false
    }

    private suspend fun validateInput(uiState: UserDetails = userUiState.userDetails): Boolean {
        return with(uiState) {
            checkEmail()
        }
    }

    private suspend fun checkEmail(): Boolean{
        return userRepository.getEmailUser(userUiState.userDetails.email).first()
            ?.toUserUiState()?.userDetails?.email?.isEmpty() ?: true
    }

    suspend fun login(): Boolean {
        val res = userRepository.login(userUiState.userDetails.password, userUiState.userDetails.email)
            .first()
            ?.toUserUiState(true)

        if(res != null){
            userUiState = res
            return true
        }else{
            return false
        }
    }

    fun updateUiState(userDetails: UserDetails) {
        userUiState =
            UserUiState(userDetails = userDetails, isEntryValid = false)
    }
}