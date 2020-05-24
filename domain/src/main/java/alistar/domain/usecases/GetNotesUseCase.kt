package alistar.domain.usecases

import alistar.domain.entities.Note
import alistar.domain.repositories.RemoteRepo
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(private val repo: RemoteRepo) : UseCase<Unit, List<Note>>() {

    override fun execute(request: Unit, response: (List<Note>) -> Unit) {
        val notes = repo.getNotes()
        response.invoke(notes)
    }

}