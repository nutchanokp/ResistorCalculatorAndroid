package com.nut.cdev.resistorcalculatorandroid.base

import android.app.Dialog
import android.content.Context
import androidx.lifecycle.ViewModel
import com.nut.cdev.resistorcalculatorandroid.utils.lifecycle.MutableLiveEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

open class BaseViewModelMVVM @Inject constructor() : ViewModel() {
//    @Inject
//    lateinit var googleAnalyticsDispatcher: GoogleAnalyticsDispatcher

    lateinit var getContext: Context

    private val disposeBag: CompositeDisposable = CompositeDisposable()

//    val loadingState: MutableLiveData<LoadingState> = MutableLiveData()

    val onDialogEvent: MutableLiveEvent<Dialog> = MutableLiveEvent()
//    val onRegenerateTokenFailureEvent: MutableLiveEvent<RegenerateTokenException> =
//        MutableLiveEvent()

    val onOpenForceUpdateApplicationDialog: MutableLiveEvent<Boolean> = MutableLiveEvent()

//    internal fun emitRegenerateTokenFailureEvent(e: RegenerateTokenException) {
//        onRegenerateTokenFailureEvent.emit(e)
//    }

    open fun emitOnOpenForceUpdateApplicationDialog(e: Boolean) {
        onOpenForceUpdateApplicationDialog.emit(e)
    }

    init {
//        loadingState.value = LoadingState(isLoading = false)
    }

//    open fun trackEvent(category: String, action: String = "", label: String = "") {
//        googleAnalyticsDispatcher.trackEvent(GoogleAnalyticsEvent(category, action, label))
//    }

//    open fun showLoading(@StringRes loadingText: Int = R.string.loading) {
//        this.loadingState.value = LoadingState(isLoading = true, loadingText = loadingText)
//    }
//
//    open fun dismissLoading() {
//        this.loadingState.value = LoadingState(isLoading = false)
//    }

//    internal fun setLoadingInternal(isLoading: Boolean, @StringRes loadingText: Int) {
//        if (isLoading) showLoading(loadingText) else dismissLoading()
//    }

    internal fun addDisposableInternal(d: Disposable) {
        this.disposeBag.add(d)
    }

    override fun onCleared() {
        super.onCleared()
        this.disposeBag.clear()
    }
//
//    open fun showDialog(
//        @StringRes title: Int,
//        @StringRes description: Int,
//        @StringRes firstButton: Int? = null,
//        firstBlock: ((dialog: DialogInterface) -> Unit)? = null
//    ) {
//        val dialog = Dialog.DialogCustomRes(
//            title = title,
//            description = description,
//            firstButton = firstButton,
//            firstBlock = firstBlock
//        )
//        onDialogEvent.emit(dialog)
//    }
//
//    open fun showDialog(
//        title: String? = null,
//        description: String? = null,
//        firstButton: Int? = null,
//        firstBlock: ((dialog: DialogInterface) -> Unit)? = null
//    ) {
//        val dialog = Dialog.DialogCustom(
//            title = title,
//            description = description,
//            firstButton = NativeDialogButton(firstButton, firstBlock)
//        )
//        onDialogEvent.emit(dialog)
//    }
//
//    open fun showDialog(
//        errorResult: ErrorResult,
//        firstButton: Int? = null,
//        firstBlock: ((dialog: DialogInterface) -> Unit)? = null
//    ) {
//        val dialog = Dialog.DialogCustom(
//            title = errorResult.errorTitle,
//            description = errorResult.errorMessage,
//            errorCode = errorResult.errorCode,
//            firstButton = NativeDialogButton(firstButton, firstBlock)
//        )
//        onDialogEvent.emit(dialog)
//    }
//
//    open fun showDialog(
//        @StringRes title: Int,
//        @StringRes description: Int,
//        errorCode: String? = null,
//        @StringRes firstButton: Int? = null,
//        firstBlock: ((dialog: DialogInterface) -> Unit)? = null
//    ) {
//        val dialog = Dialog.DialogCustomRes(
//            title = title,
//            description = description,
//            firstButton = firstButton,
//            firstBlock = firstBlock,
//            errorCode = errorCode
//        )
//        onDialogEvent.emit(dialog)
//    }
//
//    open fun showDialog(
//        @StringRes title: Int,
//        @StringRes description: Int,
//        @StringRes firstButton: Int? = null,
//        firstBlock: ((dialog: DialogInterface) -> Unit),
//        @StringRes secondButton: Int? = null,
//        secondBlock: ((dialog: DialogInterface) -> Unit)
//    ) {
//        val dialog = Dialog.DialogWithChoiceRes(
//            title = title,
//            description = description,
//            firstButton = firstButton,
//            firstBlock = firstBlock,
//            secondButton = secondButton,
//            secondBlock = secondBlock
//        )
//        onDialogEvent.emit(dialog)
//    }
//
//    open fun showDialog(
//        title: String? = null,
//        description: String? = null,
//        firstButton: Int? = null,
//        firstBlock: ((dialog: DialogInterface) -> Unit)? = null,
//        secondButton: Int? = null,
//        secondBlock: ((dialog: DialogInterface) -> Unit)? = null
//    ) {
//        val dialog = Dialog.DialogWithChoice(
//            title = title,
//            description = description,
//            firstButton = NativeDialogButton(firstButton, firstBlock),
//            secondButton = NativeDialogButton(secondButton, secondBlock)
//        )
//        onDialogEvent.emit(dialog)
//    }
//
//    open fun showDialog(
//        errorResult: ErrorResult,
//        firstButton: Int? = null,
//        firstBlock: ((dialog: DialogInterface) -> Unit)? = null,
//        secondButton: Int? = null,
//        secondBlock: ((dialog: DialogInterface) -> Unit)? = null
//    ) {
//        val dialog = Dialog.DialogWithChoice(
//            title = errorResult.errorTitle,
//            description = errorResult.errorMessage,
//            errorCode = errorResult.errorCode,
//            firstButton = NativeDialogButton(firstButton, firstBlock),
//            secondButton = NativeDialogButton(secondButton, secondBlock)
//        )
//        onDialogEvent.emit(dialog)
//    }
//
//    open fun showDialog(
//        @StringRes title: Int,
//        @StringRes description: Int,
//        errorCode: String? = null,
//        @StringRes firstButton: Int? = null,
//        firstBlock: ((dialog: DialogInterface) -> Unit),
//        @StringRes secondButton: Int? = null,
//        secondBlock: ((dialog: DialogInterface) -> Unit)
//    ) {
//        val dialog = Dialog.DialogWithChoiceRes(
//            title = title,
//            description = description,
//            firstButton = firstButton,
//            firstBlock = firstBlock,
//            secondButton = secondButton,
//            secondBlock = secondBlock,
//            errorCode = errorCode
//        )
//        onDialogEvent.emit(dialog)
//    }
//
//    open fun showDialogWithoutDescription(
//        title: String? = null,
//        firstButton: Int? = null,
//        firstBlock: ((dialog: DialogInterface) -> Unit)? = null,
//        secondButton: Int? = null,
//        secondBlock: ((dialog: DialogInterface) -> Unit)? = null
//    ) {
//        val dialog = Dialog.DialogChoiceWithoutDescription(
//            title = title,
//            firstButton = NativeDialogButton(firstButton, firstBlock),
//            secondButton = NativeDialogButton(secondButton, secondBlock),
//        )
//        onDialogEvent.emit(dialog)
//    }
//
//    open fun showDialogWithoutDescription(
//        title: String? = null,
//        description: String? = null,
//        firstButton: Int? = null,
//        firstBlock: ((dialog: DialogInterface) -> Unit)? = null
//    ) {
//        val dialog = Dialog.DialogWithoutDescription(
//            title = title,
//            firstButton = NativeDialogButton(firstButton, firstBlock)
//        )
//        onDialogEvent.emit(dialog)
//    }
//
//    open fun showDialogWithoutDescription(
//        @StringRes title: Int,
//        @StringRes firstButton: Int? = null,
//        firstBlock: ((dialog: DialogInterface) -> Unit)? = null
//    ) {
//        val dialog = Dialog.DialogWithoutDescriptionRes(
//            title = title,
//            firstButton = firstButton,
//            firstBlock = firstBlock
//        )
//        onDialogEvent.emit(dialog)
//    }
//
//    open fun showDialogHtml(
//        @StringRes title: Int,
//        @StringRes description: Int,
//        @StringRes firstButton: Int? = null,
//        firstBlock: ((dialog: DialogInterface) -> Unit),
//        @StringRes secondButton: Int? = null,
//        secondBlock: ((dialog: DialogInterface) -> Unit)
//    ) {
//        val dialog = Dialog.DialogHtml(
//            title = title,
//            description = description,
//            firstButton = firstButton,
//            firstBlock = firstBlock,
//            secondButton = secondButton,
//            secondBlock = secondBlock
//        )
//        onDialogEvent.emit(dialog)
//    }
//
//    open fun showBottomSheetDialog(
//        @DrawableRes heroImage: Int,
//        @StringRes title: Int,
//        @StringRes message: Int? = null,
//        @StringRes firstButton: Int,
//        isShowCloseIcon: Boolean? = null,
//        firstBlock: () -> Unit
//    ) {
//        val dialog = Dialog.DialogBottomSheet(
//            heroImage = heroImage,
//            title = title,
//            message = message,
//            firstButton = firstButton,
//            firstBlock = firstBlock,
//            isShowCloseIcon = isShowCloseIcon
//        )
//        onDialogEvent.emit(dialog)
//    }
}
