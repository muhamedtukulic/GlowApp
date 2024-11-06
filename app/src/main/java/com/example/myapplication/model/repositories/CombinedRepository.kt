
import com.example.myapplication.model.dao.combinedDao
import com.example.myapplication.model.models.Combined
import com.example.myapplication.model.repositories.BaseRepository
import kotlinx.coroutines.flow.Flow

class CombinedRepository(private val CombinedDao: combinedDao): BaseRepository<Combined> {

    override suspend fun insert(t: Combined) = CombinedDao.insert(t)




    override suspend fun update(t: Combined) = CombinedDao.update(t)




    override suspend fun delete(t: Combined) = CombinedDao.delete(t)




    override fun getOneStream(id: Int): Flow<Combined?> = CombinedDao.getCombined(id)




    fun getUsers(): Flow<List<Combined>> = CombinedDao.getCombineds()




}