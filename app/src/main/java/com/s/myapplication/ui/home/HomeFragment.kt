package com.s.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.s.myapplication.ReaderEngine.Analitics
import com.s.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.EtComment

        binding.BtnSend.setOnClickListener(
            {


                homeViewModel.Analitics(textView.text.toString())

                homeViewModel.liveData?.observe(viewLifecycleOwner){
//                    Toast.makeText(context,it,Toast.LENGTH_LONG).show()
                    context?.let { it1 -> view?.let { it2 -> Snackbar.make(it1, it2,it,Snackbar.LENGTH_LONG).show() } }

                }


            }
        );






        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}