package com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.nut.cdev.resistorcalculatorandroid.R
import com.nut.cdev.resistorcalculatorandroid.adapter.recyclerview.SimpleRecyclerAdapter
import com.nut.cdev.resistorcalculatorandroid.base.DataBindingFragment
import com.nut.cdev.resistorcalculatorandroid.databinding.FragmentFixedIvResistorBinding
import com.nut.cdev.resistorcalculatorandroid.databinding.ItemRvResistorBandBinding
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedIVBarIEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedIVBarIIEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedIVBarIIIEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedIVBarIVEnum
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.FixedResistorViewModel
import javax.inject.Inject

class FixedIVResistorFragment @Inject constructor() :
    DataBindingFragment<FragmentFixedIvResistorBinding, FixedResistorViewModel>() {

    var bar1 = 0
    var bar2 = 0

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val adapter by lazy {
        SimpleRecyclerAdapter<ResistorFixedIVBarIEnum, ItemRvResistorBandBinding>(
            R.layout.item_rv_resistor_band
        )
    }
    private val adapterII by lazy {
        SimpleRecyclerAdapter<ResistorFixedIVBarIIEnum, ItemRvResistorBandBinding>(
            R.layout.item_rv_resistor_band
        )
    }
    private val adapterIII by lazy {
        SimpleRecyclerAdapter<ResistorFixedIVBarIIIEnum, ItemRvResistorBandBinding>(
            R.layout.item_rv_resistor_band
        )
    }
    private val adapterIV by lazy {
        SimpleRecyclerAdapter<ResistorFixedIVBarIVEnum, ItemRvResistorBandBinding>(
            R.layout.item_rv_resistor_band
        )
    }

    override fun getLayoutResId(): Int = R.layout.fragment_fixed_iv_resistor
    override fun createViewModel(savedInstanceState: Bundle?): FixedResistorViewModel {
        return ViewModelProvider(this, factory)[FixedResistorViewModel::class.java]
    }

    override fun onCreateViewModel() {
        setView()

    }

    private fun setView() {
        binding.apply {
            rvI.adapter = adapter
            rvII.adapter = adapterII
            rvIII.adapter = adapterIII
            rvIV.adapter = adapterIV

            setUpAdapterI()
            setUpAdapterII()
            setUpAdapterIII()
            setUpAdapterIV()

            btnReset.setOnClickListener {
//                binding.tvResult1.text = ""
//                binding.tvResult2.text = ""
//                binding.tvResult2Power.text = ""
//                binding.tvResult3.text = "% Ω"
//                binding.tvTolerance.text = "คลาดเคลื่อน : %"
            }
        }

    }

    private fun setUpAdapterI() {


        adapter.setListener(object :
            SimpleRecyclerAdapter.Listener<ResistorFixedIVBarIEnum, ItemRvResistorBandBinding> {
            @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
            override fun onBindViewHolder(
                binding: ItemRvResistorBandBinding,
                holder: RecyclerView.ViewHolder,
                item: ResistorFixedIVBarIEnum?,
                position: Int
            ) {
                if (item == ResistorFixedIVBarIEnum.WHITE) {
                    binding.btnColor.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.black
                        )
                    )
                }
                item?.color?.let { binding.btnColor.setBackgroundResource(it) }
                binding.btnColor.text = "${item?.name}\n${item?.value}"

                binding.btnColor.setOnClickListener {
                    this@FixedIVResistorFragment.binding.tvResult1.text = item?.value.toString()

                    item?.barImage?.let { it1 ->
                        this@FixedIVResistorFragment.binding.ivResistorBarI.setImageResource(
                            it1
                        )
                    }
                    bar1 = item?.value ?: 0
                    this@FixedIVResistorFragment.binding.tvResult1.text = (bar1 + bar2).toString()
                }
            }
        })
        adapter.addList(ResistorFixedIVBarIEnum.entries.toMutableList())

    }

    private fun setUpAdapterII() {

        adapterII.setListener(
            object :
                SimpleRecyclerAdapter.Listener<ResistorFixedIVBarIIEnum, ItemRvResistorBandBinding> {
                @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
                override fun onBindViewHolder(
                    binding: ItemRvResistorBandBinding,
                    holder: RecyclerView.ViewHolder,
                    item: ResistorFixedIVBarIIEnum?,
                    position: Int
                ) {
                    if (item == ResistorFixedIVBarIIEnum.WHITE) {
                        binding.btnColor.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.black
                            )
                        )
                    }
                    item?.color?.let { binding.btnColor.setBackgroundResource(it) }
                    binding.btnColor.text = "${item?.name}\n${item?.value}"
                    binding.btnColor.setOnClickListener {
//                        Glide.with(this@FixedIVResistorFragment).load(item?.barImage)
//                            .into(this@FixedIVResistorFragment.binding.ivResistorBarII)

                        item?.barImage?.let { it1 ->
                            this@FixedIVResistorFragment.binding.ivResistorBarII.setImageResource(
                                it1
                            )
                        }
                        bar2 = item?.value ?: 0
                        this@FixedIVResistorFragment.binding.tvResult1.text =
                            (bar1 + bar2).toString()
                    }
                }


            })
        adapterII.addList(ResistorFixedIVBarIIEnum.entries.toMutableList())

    }

    private fun setUpAdapterIII() {
        adapterIII.setListener(
            object :
                SimpleRecyclerAdapter.Listener<ResistorFixedIVBarIIIEnum, ItemRvResistorBandBinding> {
                @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
                override fun onBindViewHolder(
                    binding: ItemRvResistorBandBinding,
                    holder: RecyclerView.ViewHolder,
                    item: ResistorFixedIVBarIIIEnum?,
                    position: Int
                ) {
                    if (item == ResistorFixedIVBarIIIEnum.WHITE) {
                        binding.btnColor.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.black
                            )
                        )
                    }
                    item?.color?.let { binding.btnColor.setBackgroundResource(it) }

                    binding.btnColor.text = "${item?.name}\nPower:${item?.valuePower}"

                    binding.btnColor.setOnClickListener {

                        item?.barImage?.let { it1 ->
                            this@FixedIVResistorFragment.binding.ivResistorBarIII.setImageResource(
                                it1
                            )
                        }
                        this@FixedIVResistorFragment.binding.tvResult2.text = item?.value.toString()
                        this@FixedIVResistorFragment.binding.tvResult2Power.text =
                            item?.valuePower.toString()
                    }
                }


            })
        adapterIII.addList(ResistorFixedIVBarIIIEnum.values().toMutableList())

    }

    private fun setUpAdapterIV() {
        adapterIV.setListener(
            object :
                SimpleRecyclerAdapter.Listener<ResistorFixedIVBarIVEnum, ItemRvResistorBandBinding> {
                @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
                override fun onBindViewHolder(
                    binding: ItemRvResistorBandBinding,
                    holder: RecyclerView.ViewHolder,
                    item: ResistorFixedIVBarIVEnum?,
                    position: Int
                ) {
                    item?.color?.let { binding.btnColor.setBackgroundResource(it) }
                    binding.btnColor.text = "${item?.name}\n± ${item?.value}%"

                    if (item == ResistorFixedIVBarIVEnum.NONE) {
                        binding.btnColor.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.black
                            )
                        )
                    }
                    binding.btnColor.setOnClickListener {

                        item?.barImage?.let { it1 ->
                            this@FixedIVResistorFragment.binding.ivResistorBarIV.setImageResource(
                                it1
                            )
                        }
                        this@FixedIVResistorFragment.binding.tvTolerance.text =
                            "คลาดเคลื่อน ± ${item?.value.toString()} %"
                    }
                }


            })
        adapterIV.addList(ResistorFixedIVBarIVEnum.entries.toMutableList())

    }

    companion object {
        @JvmStatic
        fun newInstance() = FixedIVResistorFragment()
    }
}