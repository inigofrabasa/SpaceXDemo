package com.inigofrabasa.spacexdemo

import io.mockk.MockKAnnotations
import org.junit.rules.TestRule

object InjectMocksRule {
    fun create(testClass: Any) = TestRule { statement, _ ->
        MockKAnnotations.init(testClass, relaxUnitFun = true)
        statement
    }
}
