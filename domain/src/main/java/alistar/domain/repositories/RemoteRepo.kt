package alistar.domain.repositories

import alistar.domain.entities.Note

interface RemoteRepo {

    fun getNotes(): List<Note>

}