package com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.nut.cdev.resistorcalculatorandroid.R
import com.nut.cdev.resistorcalculatorandroid.adapter.recyclerview.SimpleRecyclerAdapter
import com.nut.cdev.resistorcalculatorandroid.base.DataBindingFragment
import com.nut.cdev.resistorcalculatorandroid.databinding.FragmentFixedIvResistorBinding
import com.nut.cdev.resistorcalculatorandroid.databinding.ItemRvResistorBandBinding
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorColorEnum
import javax.inject.Inject

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FixedIVResistorFragment @Inject constructor() :
    DataBindingFragment<FragmentFixedIvResistorBinding, FixedIVResistorFragmentViewModel>() {

    private var param1: String? = null
    private var param2: String? = null

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val adapter by lazy {
        SimpleRecyclerAdapter<ResistorColorEnum, ItemRvResistorBandBinding>(
            R.layout.item_rv_resistor_band
        )
    }
    private val adapterII by lazy {
        SimpleRecyclerAdapter<ResistorColorEnum, ItemRvResistorBandBinding>(
            R.layout.item_rv_resistor_band
        )
    }
    private val adapterIII by lazy {
        SimpleRecyclerAdapter<ResistorColorEnum, ItemRvResistorBandBinding>(
            R.layout.item_rv_resistor_band
        )
    }
    private val adapterIV by lazy {
        SimpleRecyclerAdapter<ResistorColorEnum, ItemRvResistorBandBinding>(
            R.layout.item_rv_resistor_band
        )
    }

    override fun getLayoutResId(): Int = R.layout.fragment_fixed_iv_resistor
    override fun createViewModel(savedInstanceState: Bundle?): FixedIVResistorFragmentViewModel {
        return ViewModelProvider(this, factory)[FixedIVResistorFragmentViewModel::class.java]
    }

    override fun onCreateViewModel() {
        setView()
    }

    private fun setView() {
        binding.rvI.adapter = adapter
        binding.rvII.adapter = adapterII
        binding.rvIII.adapter = adapterIII
        binding.rvIV.adapter = adapterIV
        adapter.setListener(object :
            SimpleRecyclerAdapter.Listener<ResistorColorEnum, ItemRvResistorBandBinding> {
            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onBindViewHolder(
                binding: ItemRvResistorBandBinding,
                holder: RecyclerView.ViewHolder,
                item: ResistorColorEnum?,
                position: Int
            ) {
                item?.color?.let { binding.btnColor.setBackgroundResource(it) }
//                Glide.with(this@FixedIVResistorFragment).load(item).into( binding.btnColor)

            }


        })
        adapter.addList(ResistorColorEnum.values().toMutableList())
        adapterII.setListener(object :
            SimpleRecyclerAdapter.Listener<ResistorColorEnum, ItemRvResistorBandBinding> {
            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onBindViewHolder(
                binding: ItemRvResistorBandBinding,
                holder: RecyclerView.ViewHolder,
                item: ResistorColorEnum?,
                position: Int
            ) {
                item?.color?.let { binding.btnColor.setBackgroundResource(it) }
//                Glide.with(this@FixedIVResistorFragment).load(item).into( binding.btnColor)

            }


        })
        adapterII.addList(ResistorColorEnum.values().toMutableList())
        adapterIII.setListener(object :
            SimpleRecyclerAdapter.Listener<ResistorColorEnum, ItemRvResistorBandBinding> {
            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onBindViewHolder(
                binding: ItemRvResistorBandBinding,
                holder: RecyclerView.ViewHolder,
                item: ResistorColorEnum?,
                position: Int
            ) {
                item?.color?.let { binding.btnColor.setBackgroundResource(it) }
//                Glide.with(this@FixedIVResistorFragment).load(item).into( binding.btnColor)

            }


        })
        adapterIII.addList(ResistorColorEnum.values().toMutableList())
        adapterIV.setListener(object :
            SimpleRecyclerAdapter.Listener<ResistorColorEnum, ItemRvResistorBandBinding> {
            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onBindViewHolder(
                binding: ItemRvResistorBandBinding,
                holder: RecyclerView.ViewHolder,
                item: ResistorColorEnum?,
                position: Int
            ) {
                item?.color?.let { binding.btnColor.setBackgroundResource(it) }
//                Glide.with(this@FixedIVResistorFragment).load(item).into( binding.btnColor)

            }


        })
        adapterIV.addList(ResistorColorEnum.values().toMutableList())

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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