package hundreddaysofcode.retrofit

import com.google.gson.annotations.SerializedName

class Post private constructor(
    val userId: Int,
    val id: Int?,
    val title: String,
    @SerializedName("body")
    val text: String
) {
    constructor(userId: Int, title: String, text: String) : this(userId, null, title, text)
}