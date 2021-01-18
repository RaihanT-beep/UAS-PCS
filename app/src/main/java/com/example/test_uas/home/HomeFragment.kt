package com.example.test_uas.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import com.example.test_uas.MainActivity
import com.example.test_uas.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private val parent: MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by lazy { HomeViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            viewModel = this@HomeFragment.viewModel
            lifecycleOwner = this@HomeFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        init()
        observe()
    }

    private fun observe(){
        viewModel.loading.observe(viewLifecycleOwner) {
        }

        viewModel.actionState.observe(viewLifecycleOwner) {
            if (it.isConsumed) {
                Log.i("ActionState", "isConsumed")
            } else if (!it.isSuccess) {
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun init() {
        binding.recyclerView.adapter = HomeAdapter(parent)
        viewModel.listUser()
    }

}