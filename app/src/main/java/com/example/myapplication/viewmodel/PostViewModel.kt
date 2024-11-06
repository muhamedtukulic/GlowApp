import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.models.Posts
import com.example.myapplication.model.repositories.PostsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PostViewModel(private val postsRepository: PostsRepository) : ViewModel() {

    private val _posts = MutableStateFlow<List<Posts>>(emptyList())
    val posts: Flow<List<Posts>> = _posts

   /* init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            postsRepository.getPosts().collect { fetchedPosts ->
                _posts.value = fetchedPosts
            }
        }
    } */

    val homeUiState: StateFlow<HomeUiState> =
        postsRepository.getPosts()
            .map {
                HomeUiState(it)
                // StudentsDetails(id = it.id, name = it.name, surname = it.surname, dob = it.dob.toString(), enrolmentYear = it.enrolmentYear?.value.toString(), studentID = it.studentID.toString(), email = it.email, password = it.password)
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000L),
                initialValue = HomeUiState()
            )

    fun insertPost(posts: Posts) {
        viewModelScope.launch {
            postsRepository.insert(posts)
        }
    }

    fun updatePost(posts: Posts) {
        viewModelScope.launch {
            postsRepository.update(posts)
        }
    }

    fun deletePost(posts: Posts) {
        viewModelScope.launch {
            postsRepository.delete(posts)
        }
    }
}

/**
 * Ui State for HomeScreen
 */
data class HomeUiState(val postsList: List<Posts> = listOf())