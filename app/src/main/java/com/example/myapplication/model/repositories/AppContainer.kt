package com.example.myapplication.model.repositories

import CombinedRepository
import DryRepository
import OilyRepository
import android.content.Context


interface AppContainer {



    val articleRepository: ArticleRepository
    val userRepository: UserRepository
    val postsRepository: PostsRepository
    val oilyRepository: OilyRepository
    val combinedRepository: CombinedRepository
    val dryRepository: DryRepository
}
class AppDataContainer(private val context: Context): AppContainer {



    override val userRepository: UserRepository by lazy {
        UserRepository(database.getDatabase(context).UserDao())
    }

    override val postsRepository: PostsRepository by lazy {
       PostsRepository(database.getDatabase(context).PostsDao())
    }

    override val oilyRepository: OilyRepository by lazy {
        OilyRepository(database.getDatabase(context).OilyDao())
    }
    override val combinedRepository: CombinedRepository by lazy {
        CombinedRepository(database.getDatabase(context).CombinedDao())
    }
    override val dryRepository: DryRepository by lazy {
        DryRepository(database.getDatabase(context).DryDao())
    }
    override val articleRepository: ArticleRepository by lazy {
        ArticleRepository(database.getDatabase(context).ArticleDao())
    }
}