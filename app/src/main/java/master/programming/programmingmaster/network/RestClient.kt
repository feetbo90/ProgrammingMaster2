package master.programming.programmingmaster.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RestClient {

    object DataRepository {
        private const val URL = "http://192.168.11.129:8888"

        fun creating(): ApiClient {
            val retrofit = getService()
            return retrofit.create(ApiClient::class.java)
        }

        private fun getService(): Retrofit {

            val convertJSON = HttpLoggingInterceptor()
            convertJSON.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(convertJSON)
            client.addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder().header("Content-Type", "application/x-www-form-urlencoded")
                        .method(original.method(), original.body())
                        .build()
                chain.proceed(request)
            }

            return Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation()
                    .create()))
                    .client(client.build())
                    .build()

        }
    }

}