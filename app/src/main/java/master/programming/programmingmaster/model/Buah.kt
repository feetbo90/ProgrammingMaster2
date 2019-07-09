package master.programming.programmingmaster.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Buah(
        @SerializedName("fruit")
        @Expose
        val fruit: String,
        @SerializedName("size")
        @Expose
        val size: String,
        @SerializedName("color")
        @Expose
        val color: String
)