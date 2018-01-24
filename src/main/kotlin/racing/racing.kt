package racing

import java.util.*
import kotlin.collections.ArrayList

/*
kotlin으로 자동차 경주 게임 구현
기능 요구사항
초간단 자동차 경주 게임을 구현한다.
주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 자동차 이름은 쉼표(,)를 기준으로 구분한다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
실행 결과
위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.

 1. 자동차 이름 입력받기

 2. 시도할 횟수 입력받기

 3. 경주판 구성
   - 트랙
   -

 4. 경주

 5. 우승자 출력

 */

fun getInputData(msg: String): String {
    print("$msg : ")
    return Scanner(System.`in`).next()
}

fun canForward(): Boolean {
    return when {
        ( Math.random() * 10 ) >= 4 -> true
        else -> false
    }
}

fun main(args: Array<String>) {

    val carNamesStr = getInputData("경주할 자동차 이름을 입력하세요 (이름은 쉼표,)를 기준으로 구분)")
    val cycleStr = getInputData("시도할 횟수는 몇회인가요?")

    var playground = RacingPlayground(cycleStr.toInt())

    for (name in carNamesStr.split(",")) {

        playground.trackList.add( Track( Car(name), 0 ) )

    }

    playground.race()

    playground.printWinner()


}

class Car(var name: String)

class RacingPlayground(val cycle: Int) {
    var trackList: ArrayList<Track> = ArrayList()

    fun race() {
        for (i in 1..cycle) {
            println()
            for (track in trackList) {
                track.forward()
                println("${track.car.name} : ${printDistance(track.distance)}")
            }
        }
    }

    fun printWinner() {
        val winners = trackList.maxBy { it.distance }
        println("${winners!!.car.name} 가 최종 우승했습니다.")
    }
}
fun printDistance(distance: Int): String {
    var str: String = ""

    for (i in 1..distance) {
        str += "-"
    }
    return str
}

class Track(var car: Car, var distance: Int) {
    fun forward() {
        if(canForward())
            distance += 1
    }
}