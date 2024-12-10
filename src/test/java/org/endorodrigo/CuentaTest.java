package org.endorodrigo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testNombreCuenta(){
        Cuenta cuenta = new Cuenta("Endo", new BigDecimal("1000.00"));
        assertEquals("Endo",cuenta.getName());
        assertTrue(cuenta.getName().equals("Endo"));

    }

    @Test
    void testSaldoCuenta(){
        Cuenta cuenta = new Cuenta("Juan", new BigDecimal("20000.00"));
        assertEquals(20000.00, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO ) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO ) > 0);
    }
}