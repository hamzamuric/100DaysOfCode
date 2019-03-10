package hundreddaysofcode.retrofit

import com.google.gson.annotations.SerializedName

data class Comment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    @SerializedName("body")
    val text: String
)