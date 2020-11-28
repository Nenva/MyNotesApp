package mgm.u.mynotesapp.data

import androidx.lifecycle.LiveData

class NoteRepository(
    private val noteDao: NoteDao
) {
    val realAllData: LiveData<List<Note>> = noteDao.readAllData()

    suspend fun addNote(note: Note) {
        noteDao.addNote(note)
    }
}