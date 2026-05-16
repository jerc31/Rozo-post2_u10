package com.universidad.pipelineci_cd

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun sumar_devuelveResultadoCorrecto() {

        val resultado = calculator.sumar(10, 5)

        assertEquals(15, resultado)
    }

    @Test
    fun restar_devuelveResultadoCorrecto() {

        val resultado = calculator.restar(10, 5)

        assertEquals(5, resultado)
    }

    @Test
    fun multiplicar_devuelveResultadoCorrecto() {

        val resultado = calculator.multiplicar(4, 5)

        assertEquals(20, resultado)
    }

    @Test
    fun dividir_devuelveResultadoCorrecto() {

        val resultado = calculator.dividir(20, 5)

        assertEquals(4, resultado)
    }

    @Test(expected = IllegalArgumentException::class)
    fun dividir_lanzaExcepcion_siDivisorEsCero() {

        calculator.dividir(10, 0)
    }

    @Test
    fun esPar_devuelveTrue_siNumeroEsPar() {

        val resultado = calculator.esPar(8)

        assertTrue(resultado)
    }

    @Test
    fun obtenerMayor_devuelveNumeroMayor() {

        val resultado = calculator.obtenerMayor(50, 20)

        assertEquals(50, resultado)
    }
}