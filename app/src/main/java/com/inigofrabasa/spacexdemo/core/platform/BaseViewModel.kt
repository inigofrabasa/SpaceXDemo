package com.inigofrabasa.spacexdemo.core.platform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inigofrabasa.spacexdemo.core.exception.Failure
import com.inigofrabasa.spacexdemo.core.exception.FailureUI
import com.inigofrabasa.spacexdemo.core.exception.SuccessUI

abstract class BaseViewModel : ViewModel() {

    var failure: MutableLiveData<Failure> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }
    var successUI: MutableLiveData<SuccessUI> = MutableLiveData()

    protected fun handleSuccessUI(successUI: SuccessUI) {
        this.successUI.value = successUI
    }

    var failureUI: MutableLiveData<FailureUI> = MutableLiveData()

    protected fun handleFailureUI(failureUI: FailureUI) {
        this.failureUI.value = failureUI
    }
}