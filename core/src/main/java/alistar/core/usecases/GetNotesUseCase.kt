package alistar.core.usecases

import alistar.core.data.RemoteRepo
import alistar.core.domain.entities.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(private val repo: RemoteRepo) :
    UseCase<Unit, List<Note>>() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun execute(request: Unit, response: (List<Note>) -> Unit) {

        coroutineScope.launch {
            val notes = repo.getNotes()
           response.invoke(notes)
        }

    }
}

