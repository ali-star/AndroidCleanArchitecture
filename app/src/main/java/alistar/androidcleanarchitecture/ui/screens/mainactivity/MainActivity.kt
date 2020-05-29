package alistar.androidcleanarchitecture.ui.screens.mainactivity

import alistar.androidcleanarchitecture.R
import alistar.androidcleanarchitecture.databinding.ActivityMainBinding
import alistar.androidcleanarchitecture.internal.di.AppViewModelFactory
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import javax.inject.Inject
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.coroutines.*
import java.lang.RuntimeException

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    private val viewModel : MainViewModel by viewModels { viewModelFactory }

    private var binding: ActivityMainBinding? = null

    private var notesAdapter: NotesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        notesAdapter = NotesAdapter(viewModel.notesList)

        binding?.recyclerView!!.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = notesAdapter
        }

        viewModel.notes.observe(this, Observer {
            Toast.makeText(applicationContext, it.size.toString() + " Notes", Toast.LENGTH_LONG).show()
            notesAdapter?.notifyDataSetChanged()
        })

        viewModel.getNotes()

        runTest()
    }

    val mainActivityJob = Job()

    suspend fun doWork(): String = withContext(Dispatchers.Default) { "Hi" }

    fun runTest() {
        val exceptionHandler = CoroutineExceptionHandler { _, e ->
            e.printStackTrace()
        }

        val mScope = CoroutineScope(Dispatchers.Default + mainActivityJob + exceptionHandler)

        val job = mScope.launch {
            (1 .. 100).map {
                Log.i(MainActivity::class.java.name, doWork() +"job"+ " $it")
            }

        }
        val job1 = mScope.launch {
            (1 .. 100).map {
                Log.i(MainActivity::class.java.name, doWork() +"job1"+ " $it")
            }

        }
        mainActivityJob.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding?.recyclerView?.adapter = null
        binding = null
        notesAdapter = null
    }
}
