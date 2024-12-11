package org.endorodrigo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cuenta> listaCuenta;
    private String name;

    public Banco() {
        listaCuenta = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cuenta> getListaCuenta() {
        return listaCuenta;
    }

    public void setListaCuenta(List<Cuenta> listaCuenta) {
        this.listaCuenta = listaCuenta;
    }

    public void addCuenta(Cuenta cuenta){
        this.listaCuenta.add(cuenta);
        cuenta.setBanco(this);
    }

    public void tranferencia(Cuenta origen, Cuenta destino, BigDecimal
            monto){
        origen.debit(monto);
        destino.credit(monto);
    }
}
