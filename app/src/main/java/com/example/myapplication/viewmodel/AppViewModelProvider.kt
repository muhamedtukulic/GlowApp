package com.example.myapplication.viewmodel
import HomeViewModel
import PostViewModel
import com.example.myapplication.model.repositories.GlowApplication
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory


object AppViewModelProvider {

    val Factory = viewModelFactory {
        initializer {
            LoginRegistrationViewModel(
                GlowApplication().container.userRepository
            )
        }
        initializer {
            UserViewModel(
                GlowApplication().container.userRepository
            )
        }

        initializer {
            PostViewModel(
                GlowApplication().container.postsRepository
            )
        }
        initializer {
            HomeViewModel(
                GlowApplication().container.articleRepository
            )
        }
        // initializer {
        //     UserHomeViewModel(
        //         com.example.myapplication.model.repositories.GlowApplication().container.courseRepository
        //     )
        // }
    }
}

fun CreationExtras.GlowApplication(): GlowApplication =
    this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as GlowApplication
