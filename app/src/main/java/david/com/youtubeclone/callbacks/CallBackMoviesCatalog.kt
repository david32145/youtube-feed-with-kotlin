package david.com.youtubeclone.callbacks

import android.util.Log
import android.widget.TextView
import david.com.youtubeclone.models.MoviesCatalog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallBackMoviesCatalog(private var txtResponse: TextView) : Callback<MoviesCatalog> {
   override fun onFailure(
       call: Call<MoviesCatalog?>?,
       t: Throwable
   ){
        Log.e("Error", t.message)
   }

    override fun onResponse(call: Call<MoviesCatalog>, response: Response<MoviesCatalog>){
        if(response.isSuccessful){
            var moviesCatalog = response.body()
        }
    }
}