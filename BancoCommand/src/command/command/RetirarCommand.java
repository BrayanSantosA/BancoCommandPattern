package command;
import receiver.CuentaBancaria;

public class RetirarCommand implements Command {
    private final CuentaBancaria cuenta;
    private final double monto;
    private boolean ejecutado;

    public RetirarCommand(CuentaBancaria cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        cuenta.retirar(monto);
        ejecutado = true;
    }

    @Override
    public void deshacer() {
        if (ejecutado) {
            cuenta.depositar(monto);
            ejecutado = false;
        }
    }
}
