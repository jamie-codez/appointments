package com.code.appointments.ui.auth.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.code.appointments.R
import com.code.appointments.databinding.FragmentAuthBinding
import com.code.appointments.ui.auth.adapters.AuthPagerAdapter
import com.code.appointments.ui.auth.data.PagerItem
import com.code.appointments.ui.auth.views.frags.LoginFragment
import com.code.appointments.ui.auth.views.frags.SignUpFragment

class AuthFragment : Fragment() {
    private lateinit var binding: FragmentAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabLayout = binding.authTab
        val viewPager = binding.authViewPager
        val pagerFragments =
            listOf(
                PagerItem(LoginFragment(), "LOGIN"),
                PagerItem(SignUpFragment(), "REGISTER")
            )
        viewPager.adapter = AuthPagerAdapter(pagerFragments, this.parentFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

}