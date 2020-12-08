package com.inigofrabasa.spacexdemo.core.exception

import com.inigofrabasa.spacexdemo.core.utils.ERROR_HAS_OCCURRED
import com.inigofrabasa.spacexdemo.core.utils.ERROR_NETWORK_CONNECTION

sealed class Failure {
    class NetworkConnection(var message : String = ERROR_NETWORK_CONNECTION) : Failure()
    class ServerError(var message : String = ERROR_HAS_OCCURRED) : Failure()

    abstract class FeatureFailure: Failure()
}