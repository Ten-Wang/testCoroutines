package tw.teng.testcro.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @get:GET("/users")
    val allUsers: Deferred<List<GithubUserItem>>

    @GET("/users")
    fun getPagerUsers(@Query("since") since: Int, @Query("per_page") perPage: Int): Deferred<List<GithubUserItem>>

    @GET("/users/{user_id}")
    fun getUser(@Path("user_id") userId: String): Deferred<GithubUserDetailItem>
}
