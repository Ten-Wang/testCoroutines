package tw.teng.testcro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import tw.teng.testcro.network.GithubService
import tw.teng.testcro.network.GithubServiceHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var mGithubService: GithubService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mGithubService = GithubServiceHelper.getGithubService(BuildConfig.GITHUTAPI_URI)
        CoroutineScope(Dispatchers.IO).launch {
            // Retrofit return Differed<Response<BookStore>>
            val result = mGithubService.allUsers.await()
            // Switch to Android mainThread
            withContext(Dispatchers.Main) {
                textView.text = result[0].login.toString()
            }
        }

    }
}