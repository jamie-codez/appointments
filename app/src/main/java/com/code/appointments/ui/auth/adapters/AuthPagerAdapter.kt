package com.code.appointments.ui.auth.adapters

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.code.appointments.ui.auth.data.PagerItem

class AuthPagerAdapter(private val pagerItems: List<PagerItem>, fragmentManger: FragmentManager) :
    FragmentStatePagerAdapter(
        fragmentManger,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
    override fun getCount() = pagerItems.size

    override fun getItem(position: Int) = pagerItems[position].fragment

    override fun getPageTitle(position: Int) = pagerItems[position].title
}