package com.saitawngpha.koinexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saitawngpha.koinexample.db.NoteEntity
import com.saitawngpha.koinexample.repository.DatabaseRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * @Author: ၸၢႆးတွင်ႉၾႃႉ
 * @Date: 01/12/2023.
 */
class DatabaseViewModel(private val repository: DatabaseRepository): ViewModel() {

    private val _noteList = MutableLiveData<List<NoteEntity>>()
    val noteList : LiveData<List<NoteEntity>>
        get() = _noteList

    fun getAllNotes() = viewModelScope.launch {
        repository.getAllNotes().collect(){
            _noteList.postValue(it)
        }
    }

    fun saveNote(noteEntity: NoteEntity) = viewModelScope.launch {
        repository.saveNote(noteEntity)
    }
}