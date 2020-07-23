package tw.teng.testcro.network

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GithubServiceHelper {
    private const val TAG = "GithubServiceHelper"

    fun getGithubService(url: String): GithubService {
        Log.i(TAG, "getGithubService")
        return Retrofit.Builder()
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(GithubService::class.java)
    }
}
