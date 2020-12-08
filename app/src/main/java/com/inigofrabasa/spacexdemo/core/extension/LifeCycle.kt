package com.inigofrabasa.spacexdemo.core.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.inigofrabasa.spacexdemo.core.exception.Failure
import com.inigofrabasa.spacexdemo.core.exception.FailureUI
import com.inigofrabasa.spacexdemo.core.exception.SuccessUI

fun <T : Any, L : LiveData<T>> LifecycleOwner.success(liveData: L, body: (T?) -> Unit) =
    liveData.observe(this, Observer(body))

fun <L : LiveData<Failure>> LifecycleOwner.failure(liveData: L, body: (Failure?) -> Unit) =
    liveData.observe(this, Observer(body))

fun <L : LiveData<SuccessUI>> LifecycleOwner.successUI(liveData: L, body: (SuccessUI?) -> Unit) =
    liveData.observe(this, Observer(body))

fun <L : LiveData<FailureUI>> LifecycleOwner.failureUI(liveData: L, body: (FailureUI?) -> Unit) =
    liveData.observe(this, Observer(body))
