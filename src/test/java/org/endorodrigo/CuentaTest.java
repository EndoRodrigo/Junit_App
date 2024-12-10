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

    @Test
    void testReferencesCuenta() {
        Cuenta cuenta = new Cuenta("Juan", new BigDecimal("20000.00"));
        Cuenta cuenta2 = new Cuenta("Juan", new BigDecimal("20000.00"));
        //assertNotEquals(cuenta,cuenta2);
        assertEquals(cuenta,cuenta2);
    }

    @Test
    void testCuentaDebit() {
        Cuenta cuenta = new Cuenta("Juan", new BigDecimal("20000.00"));
        cuenta.debit(new BigDecimal("250.23"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(19749.77,cuenta.getSaldo().doubleValue());
        assertEquals("19749.77", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCuentaCredit() {
        Cuenta cuenta = new Cuenta("Juan", new BigDecimal("20000.00"));
        cuenta.credit(new BigDecimal("250.23"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(20250.23,cuenta.getSaldo().doubleValue());
        assertEquals("20250.23", cuenta.getSaldo().toPlainString());
    }
}