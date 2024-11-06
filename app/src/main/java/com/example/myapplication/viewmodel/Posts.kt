package com.example.myapplication.viewmodel

import com.example.myapplication.model.models.Posts

data class PostDetails(
    val postId: Int = 0,
    val title: String = "",
    val text: String = "",
    val image_url: String = ""
)

data class PostUiState(
    val postDetails: PostDetails = PostDetails(),
    val isPostValid: Boolean = false
)

fun PostDetails.toPosts(): Posts = Posts(
    postId = postId,
    title = title,
    text = text,
    image_url = image_url
)

fun Posts.toPostDetails() = PostDetails(
    postId = postId,
    title = title,
    text = text,
    image_url = image_url
)

fun Posts.toPostUiState(isPostValid: Boolean = false): PostUiState = PostUiState(
    postDetails = this.toPostDetails(),
    isPostValid = isPostValid
)
