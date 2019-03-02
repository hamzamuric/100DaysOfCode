package hundreddaysofcode.chucknorrisjokes

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

data class Joke(
        @SerializedName("icon_url")
        val iconURL: String,
        val id: String,
        val url: String,
        val value: String
)

interface JokesApi {

    @GET("/jokes/random")
    fun getJoke(): Call<Joke>

}