import com.example.myapplication.model.dao.oilyDao

import com.example.myapplication.model.models.Oily
import com.example.myapplication.model.repositories.BaseRepository
import kotlinx.coroutines.flow.Flow

class OilyRepository(private val OilyDao: oilyDao): BaseRepository<Oily> {

    override suspend fun insert(t: Oily) = OilyDao.insert(t)




    override suspend fun update(t: Oily) = OilyDao.update(t)




    override suspend fun delete(t: Oily) = OilyDao.delete(t)




    override fun getOneStream(id: Int): Flow<Oily?> = OilyDao.getOily(id)




    fun getUsers(): Flow<List<Oily>> = OilyDao.getOilys()




}