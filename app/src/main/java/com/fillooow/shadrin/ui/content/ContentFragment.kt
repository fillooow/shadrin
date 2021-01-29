package com.fillooow.shadrin.ui.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fillooow.shadrin.R
import com.fillooow.shadrin.databinding.ContentFragmentBinding

class ContentFragment : Fragment(R.layout.content_fragment) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding: ContentFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.content_fragment, container, false)

        binding.vm = ViewModelProvider(this).get(ContentViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}