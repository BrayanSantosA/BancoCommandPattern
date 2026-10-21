package command;
import receiver.CuentaBancaria;

public class DepositarCommand implements Command {
    private final CuentaBancaria cuenta;
    private final double monto;
    private boolean ejecutado;

    public DepositarCommand(CuentaBancaria cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        cuenta.depositar(monto);
        ejecutado = true;
    }

    @Override
    public void deshacer() {
        if (ejecutado) {
            cuenta.retirar(monto);
            ejecutado = false;
        }
    }
}
