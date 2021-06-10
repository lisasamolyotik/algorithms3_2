package com.example.gen

import kotlin.math.abs
import kotlin.math.pow

val aim: Array<IntArray> = arrayOf(
    intArrayOf(0, 1, 0, 1, 0),
    intArrayOf(1, 0, 2, 2, 0),
    intArrayOf(1, 2, 2, 0, 2),
    intArrayOf(0, 2, 2, 0, 1),
    intArrayOf(0, 0, 0, 2, 0)
)

class Population {
    var genotype: Array<Genome> = arrayOf()

    private fun wizzardFoo(genome: Genome) {
        val alleles = genome.alleles
        var result: Double = 0.0
        for (row in aim) {
            var product: Double = 1.0
            for (i in row.indices) {
                product *= alleles[i].allele.toDouble().pow(row[i].toDouble())
            }
            result += product
        }

        genome.actualResult = result
        genome.grade = -50 - result
    }

    fun selectionPairs(k: Int = 20): List<Pair<Genome, Genome>> {
        var pairs: MutableList<Pair<Genome, Genome>> = mutableListOf()

        for (i in 0 until k) {
            val first = IntRange(0, 5).map { genotype.random() }.maxBy { it.grade }!!
            val second = IntRange(0, 5).map { genotype.filter { it != first }.random() }.maxBy { it.grade }!!
            pairs.add(Pair(first, second))
        }
        return pairs
    }

    fun epoch() {
        genotype.forEach {
            wizzardFoo(it)
        }
        val pairs = selectionPairs()
        val child: MutableList<Genome> = mutableListOf()
        for (pair in pairs) {
            val newPair = pair.first.crossover(pair.second)

            newPair.first.mutate(0.5, IntRange(-5, 5))
            newPair.second.mutate(0.5, IntRange(-5, 5))

            child.add(newPair.first)
            child.add(newPair.second)
        }

        this.genotype = child.sortedBy { it.grade }.subList(child.size - 21, child.size -1).toTypedArray()
        genotype.forEach {
            wizzardFoo(it)
        }
        println()
    }

    fun job() {
        var c = 0
        var isWorking = true
        while (isWorking) {
            epoch()
            for (genome in genotype) {
                println ("${genome.alleles.map { it.allele }.joinToString(" ")}   ${genome.actualResult}")
                if (abs(-50 - genome.actualResult) < 1) {
                    isWorking = false
                    print("THE END")
                    break
                }
            }
            c++
        }
    }

    fun printGenotype() {
        for (item in genotype) {
            print(item.alleles.map { it.allele }.joinToString(" "))
            println ("   ${item.actualResult}")
        }

    }
}