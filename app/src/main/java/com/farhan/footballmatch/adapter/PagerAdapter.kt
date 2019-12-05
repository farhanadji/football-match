package com.farhan.footballmatch.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.farhan.footballmatch.NextMatchFragment
import com.farhan.footballmatch.PrevMatchFragment

class PagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    private val pages  = listOf(
        PrevMatchFragment(),
        NextMatchFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Previous Match"
            1 -> "Next Match"
            else -> "Match"
        }
    }
}