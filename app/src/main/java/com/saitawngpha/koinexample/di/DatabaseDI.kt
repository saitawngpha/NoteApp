package com.saitawngpha.koinexample.di

import android.content.Context
import androidx.room.Room
import com.saitawngpha.koinexample.db.NoteDatabase
import com.saitawngpha.koinexample.utils.Constants.NOTE_DATABASE

/**
 * @Author: ၸၢႆးတွင်ႉၾႃႉ
 * @Date: 30/11/2023.
 */

fun provideDatabase(context: Context) =
    Room.databaseBuilder(context, NoteDatabase::class.java, NOTE_DATABASE)
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

fun provideDao(db: NoteDatabase) = db.noteDao()


