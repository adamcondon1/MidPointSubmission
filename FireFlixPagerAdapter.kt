package com.x18392911.Adam.Condon.Advocate.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.x18392911.Adam.Condon.Advocate.MovieListFragment
import com.x18392911.Adam.Condon.Advocate.LikedMoviesFragment

const val MOVIE_LIST_PAGE_INDEX = 0
const val LIKED_MOVIES_PAGE_INDEX = 1
const val RECOMMENDED_MOVIES_PAGE_INDEX = 2

/**
 * Maintains a list of fragments used in the app's navigation pager.
 */
class AdvocatePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    /**
     * Mapping of the ViewPager page indexes to their respective Fragments
     */
    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        MOVIE_LIST_PAGE_INDEX to { MovieListFragment() },
        LIKED_MOVIES_PAGE_INDEX to { LikedMoviesFragment() },
    ) as Map<Int, () -> Fragment>

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}