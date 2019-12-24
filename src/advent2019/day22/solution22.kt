package advent2019.day22

import java.math.BigInteger
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val shuffle = input.map { it.split(" ") }.map {
            when {
                it.first() == "cut" -> "cut" to it.last().toLong()
                else -> if (it.last().any { c -> c.isDigit() }) "increment" to it.last().toLong() else "new" to 0L
            }
        }
        val deckSize = 10007L
        val formula = shuffle.fold(listOf(1L, 0L)) { acc, tech -> runTechnique(tech, deckSize, acc) }
        val card = (formula[0] * 2019L + formula[1]) % deckSize
        val part1 = if (card < 0) card + deckSize else card

        val deckBig = BigInteger("119315717514047")
        val formulaBig = shuffle.fold(listOf(1L, 0L)) { acc, tech -> runTechnique(tech, deckBig.toLong(), acc) }
            .map { it.toBigInteger() }
        val repeat = deckBig - BigInteger.ONE - BigInteger("101741582076661")
        val modInv = (formulaBig[0] - BigInteger.ONE).modInverse(deckBig)
        //(a^n*(card*(a-1)+b)-b)/(a-1)
        val card2 =
            (formulaBig[0].modPow(repeat, deckBig) *
                    (BigInteger("2020") * (formulaBig[0] - BigInteger.ONE) + formulaBig[1]) - formulaBig[1]) *
                    modInv % deckBig
        val part2 = if (card2 < BigInteger.ZERO) card2 + deckBig else card2
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

//nextCard=a*index+b
private fun runTechnique(current: Pair<String, Long>, deckSize: Long, card: List<Long>): List<Long> =
    when (current.first) {
        "new" -> listOf(-card[0], deckSize - 1L - card[1])
        "cut" -> listOf(card[0], card[1] - current.second + deckSize)
        "increment" -> card.map { (it * current.second) % deckSize }
        else -> throw IllegalStateException("wrong technique name -> ${current.first}")
    }
