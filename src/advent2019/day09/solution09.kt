package advent2019.day09

import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val program = input.split(",").mapIndexed { idx, s -> idx.toLong() to s.toLong() }.toMap()
        val part1 = runProgram(program.toMutableMap(), mutableListOf(1L)).second.last()
        val part2 = runProgram(program.toMutableMap(), mutableListOf(2L)).second.last()
        println("Part 1: $part1\nPart 2: $part2")
    }
    println("Execution Time = $executionTime ms")
}

fun runProgram(
    program: MutableMap<Long, Long>,
    inputs: MutableList<Long>,
    index: Long = 0L
): Triple<Map<Long, Long>, List<Long>, Long> {
    var idx = index
    var relBase = 0L
    val output = mutableListOf<Long>()
    while (program[idx] != 99L) {
        val instruction = program[idx].toString().padStart(5, '0')
        val (param1, param2, param3) = (idx + 1..idx + 3).map { program.getOrDefault(it, 0L) }
        val modes = 'm' + instruction.take(3).reversed()
        when (instruction.takeLast(2)) {
            "01" -> {
                program[putValue(modes[3], param3, relBase)] = getValue(program, modes[1], param1, relBase) + getValue(
                    program,
                    modes[2],
                    param2,
                    relBase
                ); idx += 4
            }
            "02" -> {
                program[putValue(modes[3], param3, relBase)] = getValue(program, modes[1], param1, relBase) * getValue(
                    program,
                    modes[2],
                    param2,
                    relBase
                ); idx += 4
            }
            "03" -> {
                if (inputs.isEmpty()) return Triple(program, output, idx)
                else {
                    program[putValue(modes[1], param1, relBase)] = inputs.first(); inputs.removeAt(0);idx += 2
                }
            }
            "04" -> {
                output.add(getValue(program, modes[1], param1, relBase)); idx += 2
            }
            "05" -> {
                if (getValue(program, modes[1], param1, relBase) != 0L) idx =
                    getValue(program, modes[2], param2, relBase) else idx += 3
            }
            "06" -> {
                if (getValue(program, modes[1], param1, relBase) == 0L) idx =
                    getValue(program, modes[2], param2, relBase) else idx += 3
            }
            "07" -> {
                if (getValue(program, modes[1], param1, relBase) < getValue(
                        program,
                        modes[2],
                        param2,
                        relBase
                    )
                ) program[putValue(modes[3], param3, relBase)] = 1
                else program[putValue(modes[3], param3, relBase)] = 0; idx += 4
            }
            "08" -> {
                if (getValue(program, modes[1], param1, relBase) == getValue(
                        program,
                        modes[2],
                        param2,
                        relBase
                    )
                ) program[putValue(modes[3], param3, relBase)] = 1
                else program[putValue(modes[3], param3, relBase)] = 0; idx += 4
            }
            "09" -> {
                relBase += getValue(program, modes[1], param1, relBase); idx += 2
            }
            else -> throw IllegalStateException("wrong code ${program[idx]} at position $idx")
        }
    }
    return Triple(program, output, idx)
}

private fun getValue(program: Map<Long, Long>, mode: Char, param: Long, relBase: Long): Long =
    when (mode) {
        '0' -> program.getOrDefault(param, 0)
        '1' -> param
        '2' -> program.getOrDefault(param + relBase, 0)
        else -> throw java.lang.IllegalStateException("wrong mode value")
    }

private fun putValue(mode: Char, param: Long, relBase: Long) = if (mode == '2') param + relBase else param