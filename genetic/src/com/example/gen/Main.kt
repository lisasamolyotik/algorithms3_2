package com.example.gen

import kotlin.random.Random

fun main() {
    val population = Population()
    population.genotype = arrayOf(
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome(),
        createRandomGenome()
    )

    population.job()
}

fun createRandomGenome(): Genome {
    return Genome(
        arrayOf(
            Gen(Random.nextInt(-100, 100)),
            Gen(Random.nextInt(-100, 100)),
            Gen(Random.nextInt(-100, 100)),
            Gen(Random.nextInt(-100, 100)),
            Gen(Random.nextInt(-100, 100))
        )
    )
}