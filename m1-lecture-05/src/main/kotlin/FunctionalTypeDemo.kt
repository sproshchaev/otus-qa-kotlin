import kotlin.system.measureTimeMillis

fun funForTimer(): String {
    println("funForTimer")
    var s = ""
    for (i in 1..100000) {
        s += "s"
    }
    return s
}

class ClassForTimer {
    fun funForTimer(): String {
        println("funForTimer")
        var s = ""
        for (i in 1..100000) {
            s += "s"
        }
        return s
    }
}

class CompanionForTimer {
    companion object {
        fun funForTimer(): String {
            println("funForTimer")
            var s = ""
            for (i in 1..100000) {
                s += "s"
            }
            return s
        }
    }
}

fun demoTimer(funName: String, f:() -> String) {
    val start = System.currentTimeMillis()
    f()
    println("$funName took ${System.currentTimeMillis() - start}ms")
}

fun demoTimerOneArg(f:() -> String) {
    val start = System.currentTimeMillis()
    f()
    println("fun took ${System.currentTimeMillis() - start}ms")
}

typealias typeForTimer = () -> String
fun demoTimerAlise(funName: String, f:typeForTimer) {
    val start = System.currentTimeMillis()
    f()
    println("$funName took ${System.currentTimeMillis() - start}ms")
}

fun main () {

//    demoTimer("fun for timer", ::funForTimer)
//    demoTimer("class for timer", ClassForTimer()::funForTimer)
//    demoTimer("companion for timer", CompanionForTimer::funForTimer)
//
//    demoTimerAlise("companion for timer", CompanionForTimer::funForTimer)

    if (true) {

    }

    demoTimer("anonymous") {
        var s = ""
        for (i in 1..100000) {
            s += "s"
        }
        s
    }

    demoTimerOneArg {
        var s = ""
        for (i in 1..100000) {
            s += "s"
        }
        s
    }

//    val result = measureTimeMillis {
//        ::funForTimer
//    }
//    println(result)
}