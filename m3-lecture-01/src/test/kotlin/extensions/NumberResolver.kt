package extensions

import org.junit.jupiter.api.extension.*

class NumberResolver : ParameterResolver {
    override fun supportsParameter(pc: ParameterContext, ec: ExtensionContext) =
        pc.parameter.type == Int::class.java

    override fun resolveParameter(pc: ParameterContext, ec: ExtensionContext) = 42
}