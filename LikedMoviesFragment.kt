package com.x18392911.Adam.Condon.Advocate
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import  com.x18392911.Adam.Condon.Advocate.adapters.FilterType
import  com.x18392911.Adam.Condon.Advocate.adapters.ItemClickListener
import  com.x18392911.Adam.Condon.Advocate.adapters.MoviesAdapter
import  com.x18392911.Adam.Condon.Advocate.data.Movie
import  com.x18392911.Adam.Condon.Advocate.databinding.FragmentLikedMoviesBinding
import  com.x18392911.Adam.Condon.Advocate.viewmodels.LikedMoviesViewModel
import java.lang.Exception


/**
 * Fragment showing the list of movies the user has liked.
 */
class LikedMoviesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLikedMoviesBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val viewModel: LikedMoviesViewModel = ViewModelProvider(requireActivity()).get(LikedMoviesViewModel::class.java)
        val movieClickListener = object : ItemClickListener() {
            override fun onLike(movie: Movie) {
                throw Exception("Movie was already liked")
            }

            override fun onRemoveLike(movie: Movie) {
                viewModel.onMovieLikeRemoved(movie)
            }
        }
        val adapter = MoviesAdapter(movieClickListener, FilterType.LIKED)
        binding.list.adapter = adapter

        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.submitList(it.toList())
            adapter.notifyDataSetChanged()
        }
        setHasOptionsMenu(true)
        return binding.root
    }
}