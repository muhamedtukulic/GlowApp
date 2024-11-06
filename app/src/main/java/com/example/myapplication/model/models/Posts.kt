package com.example.myapplication.model.models
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Posts")
data class Posts(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "postId")
    val postId: Int = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "text")
    val text: String,
    @ColumnInfo(name = "image_url")
    val image_url: String
)
