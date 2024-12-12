package org.endorodrigo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    @DisplayName("Probando la clase cuenta corriente!")
    void testNombreCuenta(){
        Cuenta cuenta = new Cuenta("Endo", new BigDecimal("1000.00"));
        assertEquals("Endo",cuenta.getName());
        assertTrue(cuenta.getName().equals("Endo"));

    }

    @Test
    @DisplayName("Probando el saldo de cuenta corriente")
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

    @Test
    void testDineroInsuficienteException() {
        Cuenta cuenta = new Cuenta("Juan", new BigDecimal("20000.00"));
        Exception exp = assertThrows(
                DineroInsificienteException.class, () ->{
                    cuenta.debit(new BigDecimal("300000.00"));
                }
        );
        String actual = exp.getMessage();
        String esperado = "Dinero insificiente";
        assertEquals(esperado, actual);
    }


    @Test
    void testTranferenciaBancaria() {
        Cuenta cuenta = new Cuenta("Juan", new BigDecimal("20000.00"));
        Cuenta cuenta2 = new Cuenta("Juan", new BigDecimal("20000.00"));
        Banco banco = new Banco();
        banco.setName("Banco del estado");
        banco.tranferencia(cuenta,cuenta2, new BigDecimal(5000));
        assertEquals("15000.00",cuenta.getSaldo().toPlainString());
        assertEquals("25000.00",cuenta2.getSaldo().toPlainString());
    }

    @Test
    void testRelacionBancoCuenta() {
        Cuenta cuenta = new Cuenta("Juan", new BigDecimal("20000.00"));
        Cuenta cuenta2 = new Cuenta("Diego", new BigDecimal("20000.00"));
        Banco banco = new Banco();
        banco.addCuenta(cuenta);
        banco.addCuenta(cuenta);
        banco.setName("Banco del estado");
        banco.tranferencia(cuenta,cuenta2, new BigDecimal(5000));
        assertEquals("15000.00",cuenta.getSaldo().toPlainString());
        assertEquals("25000.00",cuenta2.getSaldo().toPlainString());

        assertEquals(2,banco.getListaCuenta().size());
        assertEquals("Banco del estado", cuenta.getBanco().getName());
        assertEquals("Juan", banco.getListaCuenta().stream()
                .filter(c -> c.getName().equals("Juan")).findFirst().get().getName());
    }
}