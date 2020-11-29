package mgm.u.mynotesapp.repository

import androidx.lifecycle.LiveData
import mgm.u.mynotesapp.data.NoteDao
import mgm.u.mynotesapp.model.Note

class NoteRepository(
    private val noteDao: NoteDao
) {
    val realAllData: LiveData<List<Note>> = noteDao.readAllData()

    suspend fun addNote(note: Note) {
        noteDao.addNote(note)
    }

    suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    suspend fun deleteAllNotes() {
        noteDao.deleteAllNotes()
    }
}