package com.example.thenotesapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thenotesapp.repository.NoteRepository

class NoteViewModelFactory(
    private val app: Application,
    private val noteRepository: NoteRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Ensure that the factory only creates a NoteViewModel instance
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            return NoteViewModel(app, noteRepository) as T
        }
        // Provide a more specific exception message if the ViewModel class is unknown
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
