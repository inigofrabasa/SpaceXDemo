package com.inigofrabasa.spacexdemo.core.exception

sealed class FailureUI {
    object UIError : FailureUI()
}