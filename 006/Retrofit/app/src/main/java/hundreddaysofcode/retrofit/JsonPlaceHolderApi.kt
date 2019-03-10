package hundreddaysofcode.retrofit

import retrofit2.Call
import retrofit2.http.*

interface JsonPlaceHolderApi {

    @GET("posts")
    fun getPosts(
        @Query("userId") userId: IntArray,
        @Query("_sort") sort: String?,
        @Query("_order") order: String?
    ): Call<List<Post>>

    @GET("posts")
    fun getPosts(@QueryMap parameters: Map<String, String>): Call<List<Post>>

    @GET("posts/{id}/comments")
    fun getComments(@Path("id") postId: Int): Call<List<Comment>>

    @GET
    fun getComments(@Url url: String): Call<List<Comment>>

    @POST("posts")
    fun createPost(@Body post: Post): Call<Post>

    @Headers("Static-Header: 123", "Static-Header2: 456")
    @POST("posts")
    fun createPost(@Header("Dynamic-Header") header: String, @Body post: Post): Call<Post>

    @FormUrlEncoded
    @POST("posts")
    fun createPost(
        @Field("userId") userId: Int,
        @Field("title") title: String,
        @Field("body") text: String
    ): Call<Post>
}