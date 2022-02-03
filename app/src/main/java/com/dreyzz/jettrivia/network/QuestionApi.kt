package com.dreyzz.jettrivia.network

import com.dreyzz.jettrivia.model.Questions
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {

    @GET("world.json")
    suspend fun getAllQuestions(): Questions

}