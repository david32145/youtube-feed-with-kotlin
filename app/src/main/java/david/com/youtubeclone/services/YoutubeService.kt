package david.com.youtubeclone.services

import david.com.youtubeclone.models.MoviesCatalog
import retrofit2.Call
import retrofit2.http.GET

interface YoutubeService {

    @GET("search?part=id%2C%20snippet&key=%INSERT_YOUR_API_KEY_HERE%")
    fun listAll():Call<MoviesCatalog>
}
