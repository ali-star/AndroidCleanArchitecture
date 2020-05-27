package alistar.androidcleanarchitecture.ui.screens

import alistar.androidcleanarchitecture.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view?.setOnClickListener {
            val direction = ListFragmentDirections.actionListFragmentToAliFragment("xyz")
            findNavController().navigate(direction)
        }
    }

}