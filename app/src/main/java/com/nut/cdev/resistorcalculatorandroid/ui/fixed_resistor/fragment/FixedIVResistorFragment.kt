package com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nut.cdev.resistorcalculatorandroid.R
import com.nut.cdev.resistorcalculatorandroid.adapter.recyclerview.SimpleRecyclerAdapter
import com.nut.cdev.resistorcalculatorandroid.databinding.ItemRvResistorBandBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FixedIVResistorFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null


    private val adapter by lazy {
        SimpleRecyclerAdapter<String, ItemRvResistorBandBinding>(
            R.layout.item_rv_resistor_band
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fixed_iv_resistor, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FixedIVResistorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}