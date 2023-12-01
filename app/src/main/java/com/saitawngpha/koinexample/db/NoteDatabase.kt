package com.saitawngpha.koinexample.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @Author: ၸၢႆးတွင်ႉၾႃႉ
 * @Date: 30/11/2023.
 */

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}