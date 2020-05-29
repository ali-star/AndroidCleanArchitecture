package alistar.data

import alistar.core.data.RemoteRepo
import alistar.core.domain.entities.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRepoImpl @Inject constructor() : RemoteRepo {

    override suspend fun getNotes(): List<Note> = withContext(Dispatchers.IO) {
        val list: ArrayList<Note>
        val note1 = Note("1", "this is a note text 1")
        val note2 = Note("2", "this is a note text 2")
        val note3 = Note("3", "this is a note text 3")
        list = arrayListOf(note1, note2, note3)
        return@withContext list
    }
}