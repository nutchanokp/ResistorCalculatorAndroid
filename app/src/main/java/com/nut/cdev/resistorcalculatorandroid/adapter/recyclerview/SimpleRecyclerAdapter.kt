package com.nut.cdev.resistorcalculatorandroid.adapter.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class SimpleRecyclerAdapter<Item, Binding : ViewDataBinding> :
    RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private var layoutId: Int = 0
    private var list: MutableList<BaseItemViewType> = mutableListOf()
    private var listener: Listener<Item, Binding>? = null
    private var clickItem: ((Item) -> Unit)? = null

    private var itemCount: Int = 0

    constructor(layoutId: Int, list: MutableList<Item>) : super() {
        this.layoutId = layoutId
        this.list = convertList(list)
    }

    constructor(layoutId: Int) : super() {
        this.layoutId = layoutId
    }

    constructor(layoutId: Int, itemCount: Int) : super() {
        this.layoutId = layoutId
        this.itemCount = itemCount
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            SimpleViewType.TYPE_ITEM -> {
                val binding = DataBindingUtil.inflate<Binding>(
                    LayoutInflater.from(parent.context),
                    layoutId,
                    parent,
                    false
                )
                SimpleHolder<Binding>(binding)
            }
//            LoadingViewType.TYPE_LOAD_MORE -> {
//                parent.createLoadingHolder()
//            }
            else -> throw NullPointerException("viewType not match $viewType")
        }
    }

    override fun getItemCount(): Int {
        return if (itemCount > 0) itemCount else list.size
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SimpleHolder<*>) {
            if (list.isNotEmpty()) {
                val item = list[position] as SimpleDataVT<Item>
                val bindingHolder = holder as SimpleHolder<Binding>
                bindView(bindingHolder, item, position)
            }
        }
    }

    private fun bindView(holder: SimpleHolder<Binding>, item: SimpleDataVT<Item>, position: Int) {
        val binding = holder.binding
//        bindUiLanguage(binding.root)
        listener?.onBindViewHolder(binding, holder, item.data, position)
        clickItem?.let { callback ->
            binding.root.setOnClickListener {
                item.data?.let {
                    callback.invoke(it)
                }
            }
        }
    }

    fun setList(list: MutableList<Item>) {
        this.list = convertList(list)
        notifyDataSetChanged()
    }

    fun addList(newList: MutableList<Item>) {
        addList(false, newList)
    }

    fun addList(isRefresh: Boolean, newList: MutableList<Item>) {
        if (isRefresh) {
            this.list.removeAll { it.type == SimpleViewType.TYPE_ITEM }
            notifyDataSetChanged()
        }
        val update = convertList(newList)
        this.list.addNewList(this, update, SimpleViewType.TYPE_ITEM, conditionRemoveSkeleton = {
            it.type == SimpleViewType.TYPE_ITEM
        }, onViewTypeEmpty = {
        })
    }

    fun getItem(): MutableList<SimpleDataVT<Item>> = list as MutableList<SimpleDataVT<Item>>
    fun getOriginalList(): MutableList<Item> =
        this.list.filterIsInstance<SimpleDataVT<Item>>().map { item1IVT -> item1IVT.data!! }
            .toMutableList()

    fun setOnClickItem(clickItem: ((Item) -> Unit)? = null) {
        this.clickItem = clickItem
    }

    fun setListener(listener: Listener<Item, Binding>) {
        this.listener = listener
    }

    private fun convertList(list: MutableList<Item>): MutableList<BaseItemViewType> {
        return list.map { SimpleDataVT(it) }.toMutableList()
    }

    class SimpleHolder<Binding : ViewDataBinding>(val binding: Binding) :
        RecyclerView.ViewHolder(binding.root)

    interface Listener<Item, Binding : ViewDataBinding> {
        fun onBindViewHolder(
            binding: Binding,
            holder: RecyclerView.ViewHolder,
            item: Item?,
            position: Int
        )
    }
}

inline fun <T : BaseItemViewType> MutableList<BaseItemViewType>.addNewList(
    adapter: RecyclerView.Adapter<*>,
    newList: MutableList<T>,
    viewType: Int,
    conditionRemoveSkeleton: ((T: BaseItemViewType) -> Boolean),
    crossinline onViewTypeEmpty: ((Unit) -> Unit)
) {

    val isShowSkeleton =
        this.filter { conditionRemoveSkeleton(it) && it.isShowSkeleton }
            .let { list ->
                list.forEach {
                    val index = this.indexOf(it)
                    it.isShowSkeleton = false
                    this.removeAt(index)
                    adapter.notifyItemRemoved(index)
                }
                list.isNotEmpty()
            }
    val endPosition = this.size
    this.addAll(endPosition, newList)
    adapter.notifyItemRangeInserted(endPosition, newList.size)

    val viewTypes = this.find { it.type == viewType }
    if (viewTypes == null) {
        onViewTypeEmpty.invoke(Unit)
    }
}
