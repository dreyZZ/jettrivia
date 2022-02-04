package com.dreyzz.jettrivia.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dreyzz.jettrivia.data.DataOrException
import com.dreyzz.jettrivia.data.question.repository.QuestionRepository
import com.dreyzz.jettrivia.model.QuestionItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val repository: QuestionRepository
) : ViewModel() {
    val data: MutableState<
            DataOrException<
                    ArrayList<QuestionItem>, Boolean, Exception
                    >
            > = mutableStateOf(DataOrException(null, true, null))

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
//            data.value.loading = true
            data.value = repository.getAllQuestions()
//            if (data.value.data.toString().isNotEmpty())
//                data.value.loading = false
        }
    }
}