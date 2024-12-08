package org.endorodrigo;

import java.math.BigDecimal;

public class Cuenta {
    private String name;
    private BigDecimal saldo;

    public Cuenta() {
    }

    public Cuenta(String name, BigDecimal saldo) {
        this.name = name;
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
