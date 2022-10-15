package uz.gita.examgroup3.data.remote.api

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import uz.gita.examgroup3.data.model.CBUData

interface CBUApi {
    @GET("arkhiv-kursov-valyut/json/")
    fun getCurrency(): Flow<Response<List<CBUData>>>
}