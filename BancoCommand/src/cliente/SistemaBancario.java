
package cliente;

import command.*;
import invoker.CajeroAutomatico;
import receiver.CuentaBancaria;

public class SistemaBancario {
    public static void main(String[] args) {
        CuentaBancaria cuentaA = new CuentaBancaria(1000);
        CuentaBancaria cuentaB = new CuentaBancaria(500);

        CajeroAutomatico cajero = new CajeroAutomatico();

        cajero.agregarComando(
            new DepositarCommand(cuentaA, 200)
        );

        cajero.agregarComando(
            new RetirarCommand(cuentaA, 100)
        );

        cajero.agregarComando(
            new TransferirCommand(cuentaA, cuentaB, 300)
        );

        cajero.agregarComando(
            new ConsultarSaldoCommand(cuentaA)
        );

        cajero.agregarComando(
            new ConsultarSaldoCommand(cuentaB)
        );

        cajero.ejecutarComandos();
    }
}
