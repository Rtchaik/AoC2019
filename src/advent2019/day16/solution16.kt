package advent2019.day16

import java.util.*
import kotlin.math.abs
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val signal = input.map { it.toString().toInt() }
        val part1 = fftPhase(signal).take(8).joinToString("")

        val offset = input.take(7).toInt()
        val sigRev = signal.reversed()
        val sigSize = sigRev.size
        val output = ArrayDeque((0 until (repeat - offset / sigSize - 1)).flatMap { sigRev } +
                sigRev.take(sigSize - offset % sigSize))
        repeat(100) {
            output.offer(output.poll())
            repeat(output.size - 1) { output.offer((output.poll() + output.last) % 10) }
        }
        val part2 = (0..7).map { output.pollLast() }.joinToString("")

        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

private tailrec fun fftPhase(signal: List<Int>, count: Int = 0): List<Int> =
    if (count == 100) signal else {
        fftPhase((signal.indices).map {
            abs(signal.drop(it).chunked(it + 1).mapIndexed { idx, list ->
                when (idx % 4) {
                    0 -> list.sum()
                    2 -> -list.sum()
                    else -> 0
                }
            }.sum()) % 10
        }, count.inc())
    }
