package com.example.ite393exam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.ActivityCompat

class ExitApp : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exit_app, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val noBtn = view.findViewById<Button>(R.id.noE)
        val yesBtn = view.findViewById<Button>(R.id.yesE)
        noBtn.setOnClickListener {
            removeThisFragment()
        }
        yesBtn.setOnClickListener {
            ActivityCompat.finishAffinity(requireActivity())
        }
    }
    private fun removeThisFragment() {
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(this)
        fragmentTransaction.commit()
    }
}