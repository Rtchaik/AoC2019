package advent2019.day25

import advent2019.day09.runProgram
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val program = input.split(",").mapIndexed { idx, s -> idx.toLong() to s.toLong() }.toMap()
        val exploreShip = listOf(
            """south""",
            """take fixed point""",
            """north""",
            """north""",
            """take spool of cat6""",
            """north""",
            """take monolith""",
            """north""",
            """take hypercube""",
            """south""",
            """west""",
            """take planetoid""",
            """east""",
            """south""",
            """east""",
            """north""",
            """take candy cane""",
            """south""",
            """east""",
            """take easter egg""",
            """east""",
            """south""",
            """take ornament""",
            """west""",
            """south"""
        )
        var newProg = runProgram(
            program.toMutableMap(), exploreShip.flatMap { it.map { c -> c.toLong() } + listOf(10L) }.toMutableList()
        )
        println(newProg.second.map { it.toChar() }.joinToString(""))
        newProg = runProgram(
            newProg.first.toMutableMap(), ("""inv""".map { it.toLong() } + listOf(10L)).toMutableList(), newProg.third
        )
        val inventory = newProg.second.map { it.toChar() }.joinToString("").split("\n").drop(2)
            .dropLast(3).map { it.drop(2) }
        findProperInv(inventory, newProg)
    }
    println("Execution Time = $executionTime ms")
}

private fun findProperInv(inventory: List<String>, newProg: Triple<Map<Long, Long>, List<Long>, Pair<Long, Long>>) {
    (0..7).forEach { len ->
        (0..len).asSequence()
            .fold(listOf(listOf(""))) { acc, i -> acc.flatMap { list -> inventory.map { listOf(it) + list } } }
            .map { it.dropLast(1) }
            .filterNot { it.size != it.distinct().size }
            .map { it.map { s -> "drop $s" } }.toList()
            .forEach { comb ->
                val newCommand = comb + listOf("""west""")
                val next = runProgram(
                    newProg.first.toMutableMap(),
                    newCommand.flatMap { it.map { c -> c.toLong() } + listOf(10L) }.toMutableList(),
                    newProg.third
                )
                if (!next.second.containsAll("""ejected back""".map { it.toLong() })) {
                    println(next.second.map { it.toChar() }.joinToString(""))
                    return
                }
            }
    }
}