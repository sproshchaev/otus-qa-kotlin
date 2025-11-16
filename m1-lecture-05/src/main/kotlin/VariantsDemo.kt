import javax.sound.sampled.BooleanControl

// Animal <- Cat
open class Animal()
class Cat : Animal()

class Box<T: Animal> (val animal1: T, var animal2: T) {
    fun getT1(): T {
        return animal1
    }

    fun getT2(): T {
        return animal2
    }

    fun setT(new: T) {
        animal2 = new
    }
}

// convariant Box<Animal> <- Box<Cat>
class BoxOut<out T: Animal> (val animal1: T, private var animal2: T) {
    fun getT1(): T {
        return animal1
    }

    fun getT2(): T {
        return animal2
    }

//    fun setT(new: T) {
//        animal2 = new
//    }
}

// contrvariant Box<Animal> -> Box<Cat>
class BoxIn<in T: Animal> (private val animal1: T, private var animal2: T) {
//    fun getT1(): T {
//        return animal1
//    }
//
//    fun getT2(): T {
//        return animal2
//    }

    fun setT(new: T) {
        animal2 = new
    }
}

fun main() {
    val a: Animal = Cat()
    val b:Box<Animal> = Box<Animal>(Animal(), Animal())
    val c:BoxOut<Animal> = BoxOut<Cat>(Cat(), Cat())
    val d:BoxIn<Cat> = BoxIn<Animal>(Animal(), Animal())
}