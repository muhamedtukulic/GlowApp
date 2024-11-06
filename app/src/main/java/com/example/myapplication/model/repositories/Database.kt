package com.example.myapplication.model.repositories

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.model.dao.ArticleDao
import com.example.myapplication.model.dao.combinedDao
import com.example.myapplication.model.dao.dryDao
import com.example.myapplication.model.dao.oilyDao
import com.example.myapplication.model.dao.postsDao
import com.example.myapplication.model.dao.userDao
import com.example.myapplication.model.models.Combined
import com.example.myapplication.model.models.Dry
import com.example.myapplication.model.models.Oily
import com.example.myapplication.model.models.Posts
import com.example.myapplication.model.models.User
import com.example.myapplication.models.Article

@Database(entities = [User::class, Posts::class, Oily::class,Dry::class,Combined::class, Article::class ], version = 2, exportSchema = false)
abstract class database: RoomDatabase() {
    abstract fun UserDao(): userDao
    abstract fun PostsDao(): postsDao
    abstract fun OilyDao(): oilyDao
    abstract fun DryDao(): dryDao
    abstract fun CombinedDao(): combinedDao
    abstract fun ArticleDao(): ArticleDao

    companion object{
        @Volatile
        private var Instance: database? = null

        fun getDatabase(context: Context): database {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, database::class.java, "APPDatabase")
                    .fallbackToDestructiveMigration()
                    .build().also { Instance = it }
            }
        }

    }
}