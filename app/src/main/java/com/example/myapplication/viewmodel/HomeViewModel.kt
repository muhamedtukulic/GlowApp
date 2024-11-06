import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.Article
import com.example.myapplication.model.repositories.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(private val articleRepository: ArticleRepository) : ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
   // val articles: StateFlow<List<Article>> = _articles

    val articleUiState: StateFlow<ArticleUiState> =
        articleRepository.allArticles()
            .map {
                ArticleUiState(it)
                // StudentsDetails(id = it.id, name = it.name, surname = it.surname, dob = it.dob.toString(), enrolmentYear = it.enrolmentYear?.value.toString(), studentID = it.studentID.toString(), email = it.email, password = it.password)
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000L),
                initialValue = ArticleUiState()
            )


    /*  val homeUiState: StateFlow<ArticleUiState> =
         articles.map { ArticleUiState(it) }
             .stateIn(
                 scope = viewModelScope,
                 started = kotlinx.coroutines.flow.SharingStarted.WhileSubscribed(5000L),
                 initialValue = ArticleUiState()
             )

     fun insertArticle(article: Article) {
         viewModelScope.launch {
             articleRepository.insertArticle(article)
         }
     }

    fun getArticle(id: Int) {
         viewModelScope.launch {
             val article = articleRepository.getArticle(id)
             _articles.value = article
         }
     } */
}

/**
 * UI State for HomeScreen
 */
data class ArticleUiState(val articlesList: List<Article>? = listOf())
