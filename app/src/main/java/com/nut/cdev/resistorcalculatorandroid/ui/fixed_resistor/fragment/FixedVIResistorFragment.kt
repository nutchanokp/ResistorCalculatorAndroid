package com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.nut.cdev.resistorcalculatorandroid.R
import com.nut.cdev.resistorcalculatorandroid.adapter.recyclerview.SimpleRecyclerAdapter
import com.nut.cdev.resistorcalculatorandroid.base.DataBindingFragment
import com.nut.cdev.resistorcalculatorandroid.databinding.FragmentFixedViResistorBinding
import com.nut.cdev.resistorcalculatorandroid.databinding.ItemRvResistorViBandBinding
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedIVBarIEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedIVBarIIEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedIVBarIIIEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedIVBarIVEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedVIBarIEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedVIBarIIEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedVIBarIIIEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedVIBarIVEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedVIBarVEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedVIBarVIEnum
import com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.FixedResistorViewModel
import javax.inject.Inject

class FixedVIResistorFragment @Inject constructor() :
    DataBindingFragment<FragmentFixedViResistorBinding, FixedResistorViewModel>() {

    var bar1 = 0
    var bar2 = 0
    var bar3 = 0

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val adapter by lazy {
        SimpleRecyclerAdapter<ResistorFixedVIBarIEnum, ItemRvResistorViBandBinding>(
            R.layout.item_rv_resistor_vi_band
        )
    }
    private val adapterII by lazy {
        SimpleRecyclerAdapter<ResistorFixedVIBarIIEnum, ItemRvResistorViBandBinding>(
            R.layout.item_rv_resistor_vi_band
        )
    }
    private val adapterIII by lazy {
        SimpleRecyclerAdapter<ResistorFixedVIBarIIIEnum, ItemRvResistorViBandBinding>(
            R.layout.item_rv_resistor_vi_band
        )
    }
    private val adapterIV by lazy {
        SimpleRecyclerAdapter<ResistorFixedVIBarIVEnum, ItemRvResistorViBandBinding>(
            R.layout.item_rv_resistor_vi_band
        )
    }
    private val adapterV by lazy {
        SimpleRecyclerAdapter<ResistorFixedVIBarVEnum, ItemRvResistorViBandBinding>(
            R.layout.item_rv_resistor_vi_band
        )
    }

    private val adapterVI by lazy {
        SimpleRecyclerAdapter<ResistorFixedVIBarVIEnum, ItemRvResistorViBandBinding>(
            R.layout.item_rv_resistor_vi_band
        )
    }

    override fun getLayoutResId(): Int = R.layout.fragment_fixed_vi_resistor

    override fun createViewModel(savedInstanceState: Bundle?): FixedResistorViewModel {
        return ViewModelProvider(this, factory)[FixedResistorViewModel::class.java]
    }

    override fun onCreateViewModel() {
        setView()
    }

    private fun setView() {

        binding.rvI.adapter = adapter
        binding.rvII.adapter = adapterII
        binding.rvIII.adapter = adapterIII
        binding.rvIV.adapter = adapterIV
        binding.rvV.adapter = adapterV
        binding.rvVI.adapter = adapterVI
        adapter.setListener(object :
            SimpleRecyclerAdapter.Listener<ResistorFixedVIBarIEnum, ItemRvResistorViBandBinding> {
            @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
            override fun onBindViewHolder(
                binding: ItemRvResistorViBandBinding,
                holder: RecyclerView.ViewHolder,
                item: ResistorFixedVIBarIEnum?,
                position: Int
            ) {
                if (item == ResistorFixedVIBarIEnum.WHITE) {
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
                    this@FixedVIResistorFragment.binding.tvResult1.text = item?.value.toString()

                    item?.barImage?.let { it1 ->
                        this@FixedVIResistorFragment.binding.ivResistorBarI.setImageResource(
                            it1
                        )
                    }

                    bar1 = item?.value ?: 0
                    this@FixedVIResistorFragment.binding.tvResult1.text = (bar1 + bar2).toString()
                }
            }
        })
        adapter.addList(ResistorFixedVIBarIEnum.values().toMutableList())

        adapterII.setListener(
            object :
                SimpleRecyclerAdapter.Listener<ResistorFixedVIBarIIEnum, ItemRvResistorViBandBinding> {
                @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
                override fun onBindViewHolder(
                    binding: ItemRvResistorViBandBinding,
                    holder: RecyclerView.ViewHolder,
                    item: ResistorFixedVIBarIIEnum?,
                    position: Int
                ) {
                    if (item == ResistorFixedVIBarIIEnum.WHITE) {
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
                            this@FixedVIResistorFragment.binding.ivResistorBarII.setImageResource(
                                it1
                            )
                        }
                        bar2 = item?.value ?: 0
                        this@FixedVIResistorFragment.binding.tvResult1.text =
                            (bar1 + bar2).toString()
                    }
                }


            })
        adapterII.addList(ResistorFixedVIBarIIEnum.entries.toMutableList())
        adapterIII.setListener(
            object :
                SimpleRecyclerAdapter.Listener<ResistorFixedVIBarIIIEnum, ItemRvResistorViBandBinding> {
                @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
                override fun onBindViewHolder(
                    binding: ItemRvResistorViBandBinding,
                    holder: RecyclerView.ViewHolder,
                    item: ResistorFixedVIBarIIIEnum?,
                    position: Int
                ) {
                    if (item == ResistorFixedVIBarIIIEnum.WHITE) {
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

                        item?.barImage?.let { it1 ->
                            this@FixedVIResistorFragment.binding.ivResistorBarIII.setImageResource(
                                it1
                            )
                        }
                        bar3 = item?.value ?: 0
                        this@FixedVIResistorFragment.binding.tvResult1.text =
                            (bar1 + bar2 + bar3).toString()
                    }
                }


            })
        adapterIII.addList(ResistorFixedVIBarIIIEnum.entries.toMutableList())
        adapterIV.setListener(
            object :
                SimpleRecyclerAdapter.Listener<ResistorFixedVIBarIVEnum, ItemRvResistorViBandBinding> {
                @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
                override fun onBindViewHolder(
                    binding: ItemRvResistorViBandBinding,
                    holder: RecyclerView.ViewHolder,
                    item: ResistorFixedVIBarIVEnum?,
                    position: Int
                ) {
                    if (item == ResistorFixedVIBarIVEnum.WHITE) {
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
                            this@FixedVIResistorFragment.binding.ivResistorBarIV.setImageResource(
                                it1
                            )
                        }

                        this@FixedVIResistorFragment.binding.tvResult2.text = item?.value.toString()
                        this@FixedVIResistorFragment.binding.tvResult2Power.text =
                            item?.valuePower.toString()
                    }
                }


            })
        adapterIV.addList(ResistorFixedVIBarIVEnum.entries.toMutableList())
        adapterV.setListener(
            object :
                SimpleRecyclerAdapter.Listener<ResistorFixedVIBarVEnum, ItemRvResistorViBandBinding> {
                @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
                override fun onBindViewHolder(
                    binding: ItemRvResistorViBandBinding,
                    holder: RecyclerView.ViewHolder,
                    item: ResistorFixedVIBarVEnum?,
                    position: Int
                ) {
                    if (item == ResistorFixedVIBarVEnum.NONE) {
                        binding.btnColor.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.black
                            )
                        )
                    }
                    item?.color?.let { binding.btnColor.setBackgroundResource(it) }
                    binding.btnColor.text = "${item?.name}\n± ${item?.value}%"

                    binding.btnColor.setOnClickListener {

                        item?.barImage?.let { it1 ->
                            this@FixedVIResistorFragment.binding.ivResistorBarV.setImageResource(
                                it1
                            )
                        }
                        this@FixedVIResistorFragment.binding.tvResult3.text =
                            "± ${item?.value.toString()} % Ω"
                    }
                }


            })
        adapterV.addList(ResistorFixedVIBarVEnum.entries.toMutableList())
        adapterVI.setListener(
            object :
                SimpleRecyclerAdapter.Listener<ResistorFixedVIBarVIEnum, ItemRvResistorViBandBinding> {
                @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
                override fun onBindViewHolder(
                    binding: ItemRvResistorViBandBinding,
                    holder: RecyclerView.ViewHolder,
                    item: ResistorFixedVIBarVIEnum?,
                    position: Int
                ) {
                    item?.color?.let { binding.btnColor.setBackgroundResource(it) }
                    binding.btnColor.text = "${item?.name}\n${item?.value}ppm"

                    binding.btnColor.setOnClickListener {

                        item?.barImage?.let { it1 ->
                            this@FixedVIResistorFragment.binding.ivResistorBarVI.setImageResource(
                                it1
                            )
                        }
                        this@FixedVIResistorFragment.binding.tvResult4.text =
                            "${item?.value.toString()} ppm"
                    }
                }


            })
        adapterVI.addList(ResistorFixedVIBarVIEnum.entries.toMutableList())

    }

    companion object {
        @JvmStatic
        fun newInstance() = FixedVIResistorFragment()
    }
}