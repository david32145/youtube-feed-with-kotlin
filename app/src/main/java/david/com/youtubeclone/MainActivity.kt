package david.com.youtubeclone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import david.com.youtubeclone.models.Movie
import david.com.youtubeclone.adapter.ArrayMoviesAdapter
import david.com.youtubeclone.models.MoviesCatalog
import david.com.youtubeclone.services.YoutubeService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var retrofit = Retrofit.Builder()
            .baseUrl(getString(R.string.BASE_URL))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var youtubeService = retrofit.create(YoutubeService::class.java)
        var callMoviesCatalog =  youtubeService.listAll()
        callMoviesCatalog.enqueue(object: Callback<MoviesCatalog>{
            override fun onFailure(
                call: Call<MoviesCatalog?>?,
                t: Throwable
            ){
                Log.e("Error", t.message)
            }

            override fun onResponse(call: Call<MoviesCatalog>, response: Response<MoviesCatalog>){
                if(response.isSuccessful){
                    onUpdateListView(response.body()?.items)
                }
            }
        })
    }

    fun onUpdateListView(movies: List<Movie> ?){
        var adapter = ArrayMoviesAdapter(this, movies)
        listview_youtube.adapter = adapter
    }
}
