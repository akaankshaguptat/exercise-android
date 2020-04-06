package com.example.tagnotes.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): LiveData<List<Note>>/*room can return live data ,through this whenever there is change
                                           or update in dB,it notify our activity and make necessary change(livedata
                                           lifecycle aware)
                                           */

}