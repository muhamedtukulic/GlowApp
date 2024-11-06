package com.example.myapplication.viewmodel

import com.example.myapplication.model.models.User

data class UserDetails(
    val id: Int = 0,
    val name: String = "",
    val surname: String = "",
    val password: String = "",
    val email: String = ""
)

data class UserUiState(
    val userDetails: UserDetails = UserDetails(),
    val isEntryValid: Boolean = false
)

fun UserDetails.toUser(): User = User(
    id = id,
    name = name,
    surname = surname,
    password = password,
    email = email
)

fun User.toUserDetails() = UserDetails(
    id = id,
    name = name,
    surname = surname,
    password = password,
    email = email
)

fun User.toUserUiState(isEntryValid: Boolean = false): UserUiState = UserUiState(
    userDetails = this.toUserDetails(),
    isEntryValid = isEntryValid
)
