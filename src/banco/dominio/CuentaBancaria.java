package banco.dominio;

import java.util.Date;

public class CuentaBancaria {
    //atributos
    public Banco banco;
    public String tipo; // si es de ahorros o corriente
    public Persona titular;
    public String numero;
    public double saldo;
    public Date fechaApertura;
    public String contrasena;
    public String estado;

    //metodos
    public String consultarSaldo() {
        return "Hola " + this.titular.nombre + ", Su saldo es: " + this.saldo;
    }

    public boolean retirar(double valorARetirar) {
        if (valorARetirar <= saldo && estado.equals("ACTIVA")) {
            saldo = saldo - valorARetirar;
            return true;
        } else {
            return false;
        }
    }

    public boolean consignar(double valorAConsignar) {
        if (valorAConsignar > 0 && this.estado.equals("ACTIVA")) {
            this.saldo += valorAConsignar;
            return true;
        } else {
            return false;
        }
    }

    public boolean transferir(double valorAtransferir, CuentaBancaria cuentaDestino) {
        //  this se refiere al objeto actual, se refiere a retirar de esta cuenta origen
        //  tambien se puede dejar de usar this, pero es una buena practica

        return this.retirar(valorAtransferir) && cuentaDestino.consignar(valorAtransferir);

    }

}


