package org.endorodrigo;

import java.math.BigDecimal;

public class Cuenta {
    private String name;
    private BigDecimal saldo;
    private Banco banco;

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

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void debit(BigDecimal monto){
        BigDecimal Nuevo = this.getSaldo().subtract(monto);
        if (Nuevo.compareTo(BigDecimal.ZERO) < 0){
            throw  new DineroInsificienteException("Dinero insificiente");
        }
        this.saldo = Nuevo;
    }

    public void credit(BigDecimal monto){
        this.saldo = this.saldo.add(monto);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cuenta)){
            return false;
        }
        Cuenta c = (Cuenta) obj;
        if(this.name == null  || this.saldo == null){
            return false;
        }
        return this.name.equals(c.getName()) && this.saldo.equals(c.getSaldo());
    }
}
