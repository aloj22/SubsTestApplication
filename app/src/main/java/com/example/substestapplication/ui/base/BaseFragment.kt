package com.example.substestapplication.ui.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer


/**
 * Base fragment
 */
abstract class BaseFragment<T : BaseViewModel> : Fragment() {


    protected abstract val viewModel: T


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeBaseViewModelData()
    }

    private fun observeBaseViewModelData() {
        viewModel.showError.observe(this, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })
    }


}