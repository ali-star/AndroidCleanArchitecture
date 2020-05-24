package alistar.androidcleanarchitecture.internal.ui

import alistar.domain.entities.Note
import alistar.domain.repositories.RemoteRepo
import alistar.domain.usecases.GetNotesUseCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getNotesUseCase: GetNotesUseCase) : ViewModel() {

    private val _notes = MutableLiveData<List<Note>>()
    val notes : LiveData<List<Note>> = _notes

    fun getNotes() {
        getNotesUseCase.execute(Unit) {
            _notes.value = it
        }
    }

}