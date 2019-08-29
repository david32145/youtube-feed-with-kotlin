package david.com.youtubeclone.services

import david.com.youtubeclone.models.MoviesCatalog
import retrofit2.Call
import retrofit2.http.GET

interface YoutubeService {

    @GET("search?part=id%2C%20snippet&key=AIzaSyAixuIBAFmpPUYsrw3mzmz_k5L86Tk6hD4")
    fun listAll():Call<MoviesCatalog>
}