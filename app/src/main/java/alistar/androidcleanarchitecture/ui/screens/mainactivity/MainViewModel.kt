package alistar.androidcleanarchitecture.ui.screens.mainactivity

import alistar.domain.entities.Note
import alistar.domain.usecases.GetNotesUseCase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getNotesUseCase: GetNotesUseCase) : ViewModel() {

    private val _notes = MutableLiveData<List<Note>>()
    val notes : LiveData<List<Note>> = _notes

    val notesList = ArrayList<Note>()

    fun getNotes() {
        getNotesUseCase.execute(Unit) {
            notesList.clear()
            notesList.addAll(it)
            _notes.value = it
        }
    }

}