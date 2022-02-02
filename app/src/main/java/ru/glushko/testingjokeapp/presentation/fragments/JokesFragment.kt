package ru.glushko.testingjokeapp.presentation.fragments

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.glushko.testingjokeapp.databinding.FragmentJokesBinding
import ru.glushko.testingjokeapp.domain.model.Joke
import ru.glushko.testingjokeapp.presentation.viewmodels.MainViewModel
import ru.glushko.testingjokeapp.presentation.viewutils.ItemRecyclerAdapter


class JokesFragment : Fragment() {
    private lateinit var _jokesFragmentBinding: FragmentJokesBinding
    private val _mainViewModel by viewModel<MainViewModel>()
    private val _itemRecyclerAdapter = ItemRecyclerAdapter()

    private val jokesList: List<Joke> = listOf(Joke(joke = "Колобок повесился", id = 100))
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _jokesFragmentBinding = FragmentJokesBinding.inflate(inflater, null, false)
        setupRecyclerView()

        _jokesFragmentBinding.button.setOnClickListener {
            val count = try {
                _jokesFragmentBinding.countEditText.text.toString().toInt()
            } catch (e: NumberFormatException) {
                0
            }

            if (count > 0)
                getJokesByCount(count)
            else
                Toast.makeText(context, "Введите количество!", Toast.LENGTH_SHORT).show()
        }

        return _jokesFragmentBinding.root
    }

    override fun onResume() {
        super.onResume()
        _mainViewModel.localJokesList.observe(viewLifecycleOwner) {
            _itemRecyclerAdapter.submitList(it)
        }

    }

    private fun setupRecyclerView() {
        _jokesFragmentBinding.recyclerView.adapter = _itemRecyclerAdapter
    }

    private fun getJokesByCount(count: Int) {

        if(isOnline(requireContext()))
            _mainViewModel.getJokesByCount(count)
        else
            Toast.makeText(context, "Проверьте интернет соединение!", Toast.LENGTH_SHORT).show()

    }

    private fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}