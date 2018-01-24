package first

/**
 * Created by hkpking on 2018. 1. 24..
 */
data class Person(val name: String, val age: Int? = null)

val persons = listOf(
        Person("자바지기", age=45),
        Person("산지기"),
        Person("루팡", age=46)
)

fun getOldest() {
    val oldest = persons.maxBy { it.age ?: 0 }
    println("나이가 가장 많은 사람 : $oldest")

}