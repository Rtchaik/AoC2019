package utils

import java.math.BigInteger
import java.security.MessageDigest

fun Map<String, Long>.getOrValue(key: String) = this.getOrElse(key) { key.toLong() }

fun String.toMd5Hash(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun Long.isPrime() = when {
    this == 1L -> false
    this < 4L -> true
    this % 2 == 0L -> false
    this < 9L -> true
    this % 3 == 0L -> false
    else -> {
        var isPrime = true
        for (i in 5L..Math.sqrt(this.toDouble()).toLong() step 6) if (this % i == 0L || this % (i + 2) == 0L) {
            isPrime = false
            break
        }
        isPrime
    }
}

fun Long.factorial() = if (this == 0L) 1L else (1L..this).reduce { acc, l -> acc * l } //Euler020 - large numbers

fun divisorsList(number: Int): List<Int> {
    val divisors = mutableListOf<Int>()
    (1..Math.sqrt(number.toDouble()).toInt() step if (number % 2 == 0) 1 else 2)
        .forEach { if (number % it == 0) divisors.add(it) }
    (0 until divisors.size).forEach { divisors.add(number / divisors[it]) }
    return divisors.distinct()
}