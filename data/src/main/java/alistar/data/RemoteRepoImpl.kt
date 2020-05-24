package alistar.data

import alistar.domain.entities.Note
import alistar.domain.repositories.RemoteRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRepoImpl @Inject constructor() : RemoteRepo {

    override fun getNotes(): List<Note> {
        val note1 = Note("1", "this is a note text 1")
        val note2 = Note("2", "this is a note text 2")
        val note3 = Note("3", "this is a note text 3")
        return arrayListOf(note1, note2, note3)
    }

}