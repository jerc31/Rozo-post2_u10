package com.universidad.pipelineci_cd

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorExtraTest {

    private val calculator = Calculator()

    @Test
    fun suma_funciona_correctamente() {
        assertEquals(10, calculator.sumar(5, 5))
    }

    @Test
    fun resta_funciona_correctamente() {
        assertEquals(4, calculator.restar(9, 5))
    }

    @Test
    fun multiplicacion_funciona_correctamente() {
        assertEquals(20, calculator.multiplicar(4, 5))
    }

    @Test
    fun division_funciona_correctamente() {
        assertEquals(2, calculator.dividir(10, 5))
    }

    @Test
    fun numero_par_funciona_correctamente() {
        assertEquals(true, calculator.esPar(8))
    }

    @Test
    fun obtener_mayor_funciona_correctamente() {
        assertEquals(50, calculator.obtenerMayor(50, 20))
    }
}