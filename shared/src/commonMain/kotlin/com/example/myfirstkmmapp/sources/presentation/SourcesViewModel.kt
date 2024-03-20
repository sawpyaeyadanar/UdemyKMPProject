package com.example.myfirstkmmapp.sources.presentation

import com.example.myfirstkmmapp.BaseViewModel
import com.example.myfirstkmmapp.sources.application.SourcesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SourcesViewModel(private val useCase: SourcesUseCase): BaseViewModel() {
    private val _sourcesState: MutableStateFlow<SourcesState> = MutableStateFlow(SourcesState(loading = true))
    val sourcesState: StateFlow<SourcesState> get() = _sourcesState

    init {
        getSources()
    }

    private fun getSources() {
        scope.launch {
            val fetchedSources = useCase.getSources()
            _sourcesState.emit(SourcesState(sources = fetchedSources))
        }
    }
}