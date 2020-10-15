package io.mockk.gh

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class AClass {
    fun aFunction(param: String) {
        // Do nothing
    }
}

class Issue272Test {

    @Test
    fun mockUnitLambda() {
        val fn: (String) -> Unit = mockk(relaxUnitFun = true)

        fn("foo")

        verify { fn("foo") }
    }

    @Test
    fun mockUnitLambdaInvoke() {
        val fn: (String) -> Unit = mockk(relaxUnitFun = true)

        fn.invoke("foo")

        verify { fn.invoke("foo") }
    }

    @Test
    fun mockUnitLambdaRelaxed() {
        val fn: (String) -> Unit = mockk(relaxed = true)

        fn("foo")

        verify { fn("foo") }
    }

    @Test
    fun mockMemberFunctionRelaxUnitFun() {
        val instance = mockk<AClass>(relaxUnitFun = true)

        instance.aFunction("foo")

        verify {
            instance.aFunction("foo")
        }
    }

    @Test
    fun mockMemberFunctionRelaxed() {
        val instance = mockk<AClass>(relaxed = true)

        instance.aFunction("foo")

        verify {
            instance.aFunction("foo")
        }
    }
}
