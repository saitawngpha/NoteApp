package com.saitawngpha.koinexample.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saitawngpha.koinexample.utils.Constants.NOTE_TABLE
import kotlinx.coroutines.flow.Flow

/**
 * @Author: ၸၢႆးတွင်ႉၾႃႉ
 * @Date: 30/11/2023.
 */

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM $NOTE_TABLE ORDER BY noteId DESC")
    fun getAllNotes() : Flow<MutableList<NoteEntity>>
}