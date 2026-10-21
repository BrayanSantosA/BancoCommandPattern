package cliente;

import command.*;
import invoker.CajeroAutomatico;
import receiver.CuentaBancaria;

public class SistemaBancario {
    public static void main(String[] args) {

        CuentaBancaria cuentaA = new CuentaBancaria(1000);
        CuentaBancaria cuentaB = new CuentaBancaria(500);

        CajeroAutomatico cajero = new CajeroAutomatico();

        System.out.println("Saldos iniciales:");
        System.out.println("Cuenta A: $" + cuentaA.consultarSaldo());
        System.out.println("Cuenta B: $" + cuentaB.consultarSaldo());


        cajero.agregarComando(
            new DepositarCommand(cuentaA, 200)
        );

        cajero.agregarComando(
            new RetirarCommand(cuentaA, 100)
        );

        cajero.agregarComando(
            new TransferirCommand(cuentaA, cuentaB, 300)
        );


        cajero.ejecutarComandos();

        System.out.println("\nSaldos finales: ");
        System.out.println("Cuenta A: $" + cuentaA.consultarSaldo());
        System.out.println("Cuenta B: $" + cuentaB.consultarSaldo());
    }
}

