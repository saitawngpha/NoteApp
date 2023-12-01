package com.saitawngpha.koinexample.repository

import com.saitawngpha.koinexample.db.NoteDao
import com.saitawngpha.koinexample.db.NoteEntity

/**
 * @Author: ၸၢႆးတွင်ႉၾႃႉ
 * @Date: 01/12/2023.
 */
class DatabaseRepository(private val dao: NoteDao) {
    suspend fun saveNote(noteEntity: NoteEntity) = dao.saveNote(noteEntity)

    fun getAllNotes() = dao.getAllNotes()
}