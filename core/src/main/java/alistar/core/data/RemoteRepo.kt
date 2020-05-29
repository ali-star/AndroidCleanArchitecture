package alistar.core.data

import alistar.core.domain.entities.Note
import kotlinx.coroutines.Deferred

interface RemoteRepo {

    suspend fun getNotes(): List<Note>

}