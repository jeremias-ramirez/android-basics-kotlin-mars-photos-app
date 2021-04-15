package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.http.GET
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object MarsApi{
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java) }
    }
    /*
   "lazy instantiation" is when object creation is purposely delayed until you actually need
   that object to avoid unnecessary computation or use of other computing resources.
   Kotlin has first-class support for lazy instantiation.
     */
interface MarsApiService {
    /*
    Use the @GET annotation to tell Retrofit that this is GET request,
    and specify endpoint, for that web service method. In this case the endpoint is called photos.
    As mentioned in the previous task, you will be using /photos endpoint in this codelab.
    La url que se arma es : https://android-kotlin-fun-mars-server.appspot.com/photos
     */
    @GET("photos")
    suspend fun getPhotos() : List<MarsPhoto>

}
