package alistar.androidcleanarchitecture.internal.ui

import alistar.androidcleanarchitecture.R
import alistar.androidcleanarchitecture.internal.di.AppViewModelFactory
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import javax.inject.Inject
import androidx.activity.viewModels
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    private val viewModel : MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.notes.observe(this, Observer {
            Toast.makeText(applicationContext, it.size.toString() + " Notes", Toast.LENGTH_LONG).show()
        })

        viewModel.getNotes()
    }
}
