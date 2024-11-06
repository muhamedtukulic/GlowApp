
import com.example.myapplication.model.dao.dryDao
import com.example.myapplication.model.models.Dry
import com.example.myapplication.model.repositories.BaseRepository
import kotlinx.coroutines.flow.Flow

class DryRepository(private val DryDao: dryDao): BaseRepository<Dry> {

    override suspend fun insert(t: Dry) = DryDao.insert(t)




    override suspend fun update(t: Dry) = DryDao.update(t)




    override suspend fun delete(t: Dry) = DryDao.delete(t)




    override fun getOneStream(id: Int): Flow<Dry?> = DryDao.getDry(id)




    fun getUsers(): Flow<List<Dry>> = DryDao.getDrys()




}