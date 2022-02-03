package com.dreyzz.jettrivia.data.question.repository

import android.util.Log
import com.dreyzz.jettrivia.data.DataOrException
import com.dreyzz.jettrivia.model.QuestionItem
import com.dreyzz.jettrivia.data.question.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {

    private val dataOrException = DataOrException<
            ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()

            if (dataOrException.data.toString().isNotEmpty())
                dataOrException.loading = false

        } catch (ex: Exception) {

            dataOrException.e = ex
            Log.d(TAG, "getAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }

        return dataOrException
    }

    companion object {
        private val TAG: String = QuestionRepository::class.java.simpleName
    }
}