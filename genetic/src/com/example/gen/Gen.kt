package com.example.gen

import kotlin.random.Random
import kotlin.random.nextInt

class Gen(var allele: Int = 0) {
    fun mutate(probability: Double, range: IntRange) {
        if (probability > computeProbability()) {
            this.allele = Random.nextInt(range)
        }
    }

    private fun computeProbability(): Double =
        Random.nextDouble(0.0, 1.0)
}