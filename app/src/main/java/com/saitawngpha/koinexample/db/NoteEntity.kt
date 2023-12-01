package com.saitawngpha.koinexample.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saitawngpha.koinexample.utils.Constants.NOTE_TABLE

/**
 * @Author: ၸၢႆးတွင်ႉၾႃႉ
 * @Date: 30/11/2023.
 */

@Entity(tableName = NOTE_TABLE)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    var noteId : Int = 0,
    @ColumnInfo(name = "note_title")
    var noteTitle : String = "",
    @ColumnInfo(name =  "note_desc")
    var noteDesc : String = ""
)
