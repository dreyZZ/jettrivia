package com.dreyzz.jettrivia.ui.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.dreyzz.jettrivia.ui.component.QuestionOrProgressView

@Composable
fun TriviaHome(viewModel: QuestionsViewModel = hiltViewModel()) {
    QuestionOrProgressView(viewModel)
}
