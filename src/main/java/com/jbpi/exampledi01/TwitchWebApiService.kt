package com.jbpi.exampledi01

import com.jbpi.exampledi01.data.ApiResponseStreams
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface TwitchWebApiService {

    @Headers("Client-ID: v5a1cwlnq87gp9usfb1ybi5hnl8kqb")
    @GET("helix/streams?first=10&game_id=2798")
    fun getStreamsHomm3(): Observable<ApiResponseStreams>
}