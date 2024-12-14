package org.endorodrigo;

import jdk.jfr.Enabled;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {
    Cuenta cuenta;

    @BeforeEach
    void initMetohTest(){
        this.cuenta = new Cuenta("Endo", new BigDecimal("20000.00"));
        System.out.println("Iniciando el metodo....");
    }

    @AfterEach
    void tearDown(){
        System.out.println("Finalizacion de la prueba");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inicializando el test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizacion del test");
    }

    @Test
    @DisplayName("Probando la clase cuenta corriente!")
    void testNombreCuenta(){
        assertEquals("Endo",cuenta.getName());
        assertTrue(cuenta.getName().equals("Endo"));

    }

    @Test
    @DisplayName("Probando el saldo de cuenta corriente")
    void testSaldoCuenta(){
        assertEquals(20000.00, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO ) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO ) > 0);
    }

    @Test
    @Disabled
    void testReferencesCuenta() {
        Cuenta cuenta2 = new Cuenta("Juan", new BigDecimal("20000.00"));
        //assertNotEquals(cuenta,cuenta2);
        assertEquals(cuenta,cuenta2);
    }

    @Test
    void testCuentaDebit() {
        cuenta.debit(new BigDecimal("250.23"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(19749.77,cuenta.getSaldo().doubleValue());
        assertEquals("19749.77", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCuentaCredit() {
        cuenta.credit(new BigDecimal("250.23"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(20250.23,cuenta.getSaldo().doubleValue());
        assertEquals("20250.23", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testDineroInsuficienteException() {
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
        Cuenta cuenta2 = new Cuenta("Juan", new BigDecimal("20000.00"));
        Banco banco = new Banco();
        banco.setName("Banco del estado");
        banco.tranferencia(cuenta,cuenta2, new BigDecimal(5000));
        assertEquals("15000.00",cuenta.getSaldo().toPlainString());
        assertEquals("25000.00",cuenta2.getSaldo().toPlainString());
    }

    @Test
    void testRelacionBancoCuenta() {
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

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testSoloWindwos() {
        System.out.println("Ejecutado el windows");
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testSoloLinuxMac() {
        System.out.println("Ejecutado el bash");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_23)
    void testSoloJava23() {
        System.out.println("Verificando la version de java");
    }

    @Test
    void testImprimirVariablesAmbiente() {
        Map<String,String> getEnv = System.getenv();
        getEnv.forEach((k, v) -> System.out.println(k +" = "+ v));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "12")
    void testProcesadores() {
    }
}