package com.nut.cdev.resistorcalculatorandroid.ui.fixed_resistor.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.nut.cdev.resistorcalculatorandroid.R
import com.nut.cdev.resistorcalculatorandroid.adapter.recyclerview.SimpleRecyclerAdapter
import com.nut.cdev.resistorcalculatorandroid.base.DataBindingFragment
import com.nut.cdev.resistorcalculatorandroid.databinding.FragmentFixedVResistorBinding
import com.nut.cdev.resistorcalculatorandroid.databinding.ItemRvResistorBandBinding
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedIVBarIVEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedVBarIEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedVBarIIEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedVBarIIIEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedVBarIVEnum
import com.nut.cdev.resistorcalculatorandroid.enums.ResistorFixedVBarVEnum
import javax.inject.Inject

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FixedVResistorFragment @Inject constructor() :
    DataBindingFragment<FragmentFixedVResistorBinding, FixedVResistorFragmentViewModel>() {

    private var param1: String? = null
    private var param2: String? = null

    var bar1 = 0
    var bar2 = 0
    var bar3 = 0

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val adapter by lazy {
        SimpleRecyclerAdapter<ResistorFixedVBarIEnum, ItemRvResistorBandBinding>(
            R.layout.item_rv_resistor_band
        )
    }
    private val adapterII by lazy {
        SimpleRecyclerAdapter<ResistorFixedVBarIIEnum, ItemRvResistorBandBinding>(
            R.layout.item_rv_resistor_band
        )
    }
    private val adapterIII by lazy {
        SimpleRecyclerAdapter<ResistorFixedVBarIIIEnum, ItemRvResistorBandBinding>(
            R.layout.item_rv_resistor_band
        )
    }
    private val adapterIV by lazy {
        SimpleRecyclerAdapter<ResistorFixedVBarIVEnum, ItemRvResistorBandBinding>(
            R.layout.item_rv_resistor_band
        )
    }
    private val adapterV by lazy {
        SimpleRecyclerAdapter<ResistorFixedVBarVEnum, ItemRvResistorBandBinding>(
            R.layout.item_rv_resistor_band
        )
    }

    override fun getLayoutResId(): Int = R.layout.fragment_fixed_v_resistor
    override fun createViewModel(savedInstanceState: Bundle?): FixedVResistorFragmentViewModel {
        return ViewModelProvider(this, factory)[FixedVResistorFragmentViewModel::class.java]
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
        adapter.setListener(object :
            SimpleRecyclerAdapter.Listener<ResistorFixedVBarIEnum, ItemRvResistorBandBinding> {
            @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
            override fun onBindViewHolder(
                binding: ItemRvResistorBandBinding,
                holder: RecyclerView.ViewHolder,
                item: ResistorFixedVBarIEnum?,
                position: Int
            ) {
                if (item == ResistorFixedVBarIEnum.WHITE) {
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
                    this@FixedVResistorFragment.binding.tvResult1.text = item?.value.toString()

                    item?.barImage?.let { it1 ->
                        this@FixedVResistorFragment.binding.ivResistorBarI.setImageResource(
                            it1
                        )
                    }

//                    Glide.with(this@FixedIVResistorFragment).load(item?.barImage)
//                        .into(this@FixedIVResistorFragment.binding.ivResistorBarI)

                    bar1 = item?.value ?: 0
                    this@FixedVResistorFragment.binding.tvResult1.text =
                        (bar1 + bar2 + bar3).toString()
                }
            }
        })
        adapter.addList(ResistorFixedVBarIEnum.values().toMutableList())

        adapterII.setListener(
            object :
                SimpleRecyclerAdapter.Listener<ResistorFixedVBarIIEnum, ItemRvResistorBandBinding> {
                @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
                override fun onBindViewHolder(
                    binding: ItemRvResistorBandBinding,
                    holder: RecyclerView.ViewHolder,
                    item: ResistorFixedVBarIIEnum?,
                    position: Int
                ) {
                    if (item == ResistorFixedVBarIIEnum.WHITE) {
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
                            this@FixedVResistorFragment.binding.ivResistorBarII.setImageResource(
                                it1
                            )
                        }
                        bar2 = item?.value ?: 0
                        this@FixedVResistorFragment.binding.tvResult1.text =
                            (bar1 + bar2 + bar3).toString()
                    }
                }


            })
        adapterII.addList(ResistorFixedVBarIIEnum.values().toMutableList())
        adapterIII.setListener(
            object :
                SimpleRecyclerAdapter.Listener<ResistorFixedVBarIIIEnum, ItemRvResistorBandBinding> {
                @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
                override fun onBindViewHolder(
                    binding: ItemRvResistorBandBinding,
                    holder: RecyclerView.ViewHolder,
                    item: ResistorFixedVBarIIIEnum?,
                    position: Int
                ) {
                    if (item == ResistorFixedVBarIIIEnum.WHITE) {
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
                            this@FixedVResistorFragment.binding.ivResistorBarIII.setImageResource(
                                it1
                            )
                        }
                        bar3 = item?.value ?: 0
                        this@FixedVResistorFragment.binding.tvResult1.text =
                            (bar1 + bar2 + bar3).toString()
                    }
                }


            })
        adapterIII.addList(ResistorFixedVBarIIIEnum.values().toMutableList())
        adapterIV.setListener(
            object :
                SimpleRecyclerAdapter.Listener<ResistorFixedVBarIVEnum, ItemRvResistorBandBinding> {
                @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
                override fun onBindViewHolder(
                    binding: ItemRvResistorBandBinding,
                    holder: RecyclerView.ViewHolder,
                    item: ResistorFixedVBarIVEnum?,
                    position: Int
                ) {
                    item?.color?.let { binding.btnColor.setBackgroundResource(it) }
                    binding.btnColor.text = "${item?.name}\nPower:${item?.valuePower}"
                    if (item == ResistorFixedVBarIVEnum.WHITE) {
                        binding.btnColor.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.black
                            )
                        )
                    }

                    binding.btnColor.setOnClickListener {

                        item?.barImage?.let { it1 ->
                            this@FixedVResistorFragment.binding.ivResistorBarIV.setImageResource(
                                it1
                            )
                        }

                        this@FixedVResistorFragment.binding.tvResult2.text = item?.value.toString()
                        this@FixedVResistorFragment.binding.tvResult2Power.text =
                            item?.valuePower.toString()
                    }
                }


            })
        adapterIV.addList(ResistorFixedVBarIVEnum.values().toMutableList())
        adapterV.setListener(
            object :
                SimpleRecyclerAdapter.Listener<ResistorFixedVBarVEnum, ItemRvResistorBandBinding> {
                @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
                override fun onBindViewHolder(
                    binding: ItemRvResistorBandBinding,
                    holder: RecyclerView.ViewHolder,
                    item: ResistorFixedVBarVEnum?,
                    position: Int
                ) {
                    item?.color?.let { binding.btnColor.setBackgroundResource(it) }
                    binding.btnColor.text = "${item?.name}\n± ${item?.value}%"

                    if (item == ResistorFixedVBarVEnum.NONE) {
                        binding.btnColor.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.black
                            )
                        )
                    }
                    binding.btnColor.setOnClickListener {

                        item?.barImage?.let { it1 ->
                            this@FixedVResistorFragment.binding.ivResistorBarIV.setImageResource(
                                it1
                            )
                        }
                        this@FixedVResistorFragment.binding.tvResult3.text =
                            "${item?.value.toString()} % Ω"
                    }
                }


            })
        adapterV.addList(ResistorFixedVBarVEnum.values().toMutableList())

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
            FixedVResistorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}