package com.nut.cdev.resistorcalculatorandroid.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.nut.cdev.resistorcalculatorandroid.Injectable
import dagger.android.support.AndroidSupportInjection

abstract class DataBindingFragment<Binding : ViewDataBinding, VM : BaseViewModelMVVM> :
    Fragment(), Injectable {
    private var _binding: Binding? = null

    protected val binding: Binding get() = _binding!!
    protected lateinit var vm: VM

//    private val loadingView by lazy { activity?.let { LoadingView(it) } }

    protected abstract fun getLayoutResId(): Int

    abstract fun createViewModel(savedInstanceState: Bundle?): VM

    protected abstract fun onCreateViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        setupInstance()
    }

    @Suppress("UNCHECKED_CAST")
    private fun setupInstance() {
//        val viewModel = ViewModelProviders.of(this)
//            .get(BaseViewModelFragment::class.java) as BaseViewModelFragment<Presenter>
//
//        if (viewModel.presenter == null) {
//            viewModel.presenter = initPresenter()
//        }
//
//        presenter = viewModel.presenter!!
//        presenter.attachLifecycle(lifecycle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false) as Binding
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vm = createViewModel(savedInstanceState)
//        subscribeToViewModel(vm)
        onCreateViewModel()

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

//    fun subscribeToViewModel(viewModel: BaseViewModelMVVM) {
//        if (!viewModel.onDialogEvent.hasObservers())
//            viewModel.onDialogEvent.observe(viewLifecycleOwner, Observer(this::onDialog))
//        if (!viewModel.onRegenerateTokenFailureEvent.hasObservers())
//            viewModel.onRegenerateTokenFailureEvent.observe(
//                viewLifecycleOwner,
//                Observer(this::onRegenerateTokenFailure)
//            )
//        if (!viewModel.loadingState.hasObservers())
//            viewModel.loadingState.observe(viewLifecycleOwner, Observer {
//                when (it.isLoading) {
//                    true -> showLoadingView(it.loadingText)
//                    false -> dismissLoadingView()
//                }
//            })
//    }
//
//    private fun dismissLoadingView() {
//        loadingView?.let {
//            if (it.isLoading()) {
//                it.dismissLoading()
//            }
//        }
//    }
//
//    private fun showLoadingView(@StringRes loadingText: Int) {
//        loadingView?.let {
//            if (!it.isLoading()) {
//                it.showLoadingWithText(resources.getString(loadingText))
//            } else {
//                it.setLoadingText(getString(loadingText))
//            }
//        }
//    }
//
//    private fun onDialog(dialog: Dialog) {
//        when (dialog) {
//            is Dialog.DialogCustomRes -> showCustomDialog(dialog)
//            is Dialog.DialogCustom -> showCustomDialog(dialog)
//            is Dialog.DialogBottomSheet -> showDialogBottomSheet(dialog)
//            else -> {}
//        }
//    }
//
//    private fun showCustomDialog(dialogCustomRes: Dialog.DialogCustomRes) {
//        showDialog(
//            title = dialogCustomRes.title,
//            description = dialogCustomRes.description,
//            firstBlock = dialogCustomRes.firstBlock,
//            firstButton = dialogCustomRes.firstButton
//        )
//    }
//
//    private fun showCustomDialog(dialogCustom: Dialog.DialogCustom) {
//        showDialog(
//            title = dialogCustom.title,
//            description = dialogCustom.description,
//            firstBlock = dialogCustom.firstBlock,
//            firstButton = dialogCustom.firstButton
//        )
//    }
//
//    private fun showDialogBottomSheet(dialogBottomSheet: Dialog.DialogBottomSheet) {
//        val fragment = TungNgernPopUpDialog.newInstance(
//            title = dialogBottomSheet.title,
//            message = dialogBottomSheet.message,
//            buttonText = dialogBottomSheet.firstButton,
//            heroImage = dialogBottomSheet.heroImage,
//            onDismiss = dialogBottomSheet.firstBlock,
//            isShowCloseIcon = dialogBottomSheet.isShowCloseIcon
//        )
//
//        fragment.show(
//            childFragmentManager.beginTransaction()
//                .setCustomAnimations(
//                    R.animator.anim_slide_in_right,
//                    R.animator.anim_slide_in_left,
//                    R.animator.anim_slide_out_left,
//                    R.animator.anim_slide_out_right
//                ), "tagPopUpDialog"
//        )
//    }
}