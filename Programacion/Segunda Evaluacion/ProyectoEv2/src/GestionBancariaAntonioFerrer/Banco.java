package GestionBancariaAntonioFerrer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Banco {
    private String nombreBanco = "BANCO CENTRAL";
    private String numCuenta;
    private final CuentaBancaria NO_EXISTE_CUENTA = null;
    private final Map<Long, CuentaBancaria> cuentas = new HashMap<>();

    public Map<Long, CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void datosInicio(){
        CuentaBancaria dummy1 = new CuentaBancaria(222222 , new Persona("24242424K" ,"Antonio Ferrer"));
        dummy1.ingresar(500 , "24333221" , "saldo inicial");
        CuentaBancaria dummy2 = new CuentaBancaria(333333 , new Persona("37373737L" ,"Juanito bananas"));
        dummy2.ingresar(10 , "000000 ","saldo inicial");
        CuentaBancaria dummy3 = new CuentaBancaria(444444 , new Persona("86868686M" ,"Pepita FLores"));
        dummy3.ingresar(12 ,"000000" , "saldo inicial");
        cuentas.put(dummy1.getNumCuenta(),dummy1);
        cuentas.put(dummy2.getNumCuenta(),dummy2);
        cuentas.put(dummy3.getNumCuenta(),dummy3);
    }

    public CuentaBancaria localizarCuenta(Long numCuenta){
        if (cuentas.containsKey(numCuenta)){
         return cuentas.get(numCuenta);
        }
        return NO_EXISTE_CUENTA;
    }

    public Set<CuentaBancaria> listarCuentas(double limite){
        Set<CuentaBancaria> cuentaLimiteSuperado = new HashSet<>();
       for (CuentaBancaria cuenta : cuentas.values()){
            if(cuenta.getSaldo() > limite){
                cuentaLimiteSuperado.add(cuenta);
            }
       }
       return cuentaLimiteSuperado;
    }


}


