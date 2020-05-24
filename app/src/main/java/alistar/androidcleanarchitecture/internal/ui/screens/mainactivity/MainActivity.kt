package alistar.androidcleanarchitecture.internal.ui.screens.mainactivity

import alistar.androidcleanarchitecture.R
import alistar.androidcleanarchitecture.databinding.ActivityMainBinding
import alistar.androidcleanarchitecture.internal.di.AppViewModelFactory
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import javax.inject.Inject
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerAppCompatActivity

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
    }

    override fun onDestroy() {
        super.onDestroy()
        binding?.recyclerView?.adapter = null
        binding = null
        notesAdapter = null
    }
}
