package master.programming.programmingmaster.network

import master.programming.programmingmaster.model.Buah
import retrofit2.Call
import retrofit2.http.GET


interface ApiClient {

    @GET("/ambilData/contoh.json")
    fun ambilData() : Call<Buah>
}