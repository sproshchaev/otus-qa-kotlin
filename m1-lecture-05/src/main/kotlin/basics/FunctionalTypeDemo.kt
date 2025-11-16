package basics

fun funForTimer(): String {
    println("basics.funForTimer")
    var s = ""
    for (i in 1..100000) {
        s += "s"
    }
    return s
}

class ClassForTimer {
    fun funForTimer(): String {
        println("basics.funForTimer")
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
            println("basics.funForTimer")
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

//    basics.demoTimer("fun for timer", ::basics.funForTimer)
//    basics.demoTimer("class for timer", basics.ClassForTimer()::basics.funForTimer)
//    basics.demoTimer("companion for timer", basics.CompanionForTimer::basics.funForTimer)
//
//    basics.demoTimerAlise("companion for timer", basics.CompanionForTimer::basics.funForTimer)

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
//        ::basics.funForTimer
//    }
//    println(result)
}