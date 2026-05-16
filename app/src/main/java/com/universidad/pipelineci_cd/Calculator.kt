package com.universidad.pipelineci_cd

class Calculator {

    fun sumar(a: Int, b: Int): Int {
        return a + b
    }

    fun restar(a: Int, b: Int): Int {
        return a - b
    }

    fun multiplicar(a: Int, b: Int): Int {
        return a * b
    }

    fun dividir(a: Int, b: Int): Int {

        if (b == 0) {
            throw IllegalArgumentException("No se puede dividir por cero")
        }

        return a / b
    }

    fun esPar(numero: Int): Boolean {
        return numero % 2 == 0
    }

    fun obtenerMayor(a: Int, b: Int): Int {

        return if (a > b) {
            a
        } else {
            b
        }
    }
}