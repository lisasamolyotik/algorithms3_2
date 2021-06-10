package com.example.gen

import java.util.*

class Genome(var alleles: Array<Gen> = arrayOf()) {
    val id: UUID = UUID.randomUUID()
    val size = 5
    var actualResult: Double = 0.0
    var grade: Double = 0.0

    fun mutate(probability: Double, range: IntRange) {
        alleles.forEach { it.mutate(probability, range) }
    }

    fun crossover(rhs: Genome): Pair<Genome, Genome> {
        val firstChild = Genome()
        val secondChild = Genome()

        val firstAlleles: Array<Gen> = this.alleles.copyOfRange(0, 3) + rhs.alleles.takeLast(2)

        val secondAlleles: Array<Gen> = rhs.alleles.copyOfRange(0, 3) + this.alleles.takeLast(2)

        firstChild.alleles = firstAlleles.copyOfRange(0, 2) + secondAlleles.copyOfRange(2, 4) + firstAlleles[4]
        secondChild.alleles = firstAlleles.copyOfRange(0, 2) + secondAlleles.copyOfRange(2, 4) + firstAlleles[4]

        return Pair(firstChild, secondChild)
    }

    override fun equals(other: Any?): Boolean {
        return this.id == (other as Genome).id
    }

    override fun hashCode(): Int {
        return this.id.hashCode()
    }
}