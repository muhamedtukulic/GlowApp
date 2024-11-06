package com.example.myapplication.model.repositories



import com.example.myapplication.model.dao.ArticleDao
import com.example.myapplication.models.Article
import kotlinx.coroutines.flow.Flow

class ArticleRepository(private val articleDao: ArticleDao) {
    fun allArticles(): Flow<List<Article>?> = articleDao.getAllArticles()

    fun insertArticle(article: Article) {
        articleDao.insert(article)
    }

    fun getArticle(id: Int): Flow<Article> = articleDao.getArticleById(id)

}
