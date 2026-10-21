package command;
import receiver.CuentaBancaria;

public class ConsultarSaldoCommand implements Command {
    private final CuentaBancaria cuenta;

    public ConsultarSaldoCommand(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void ejecutar() {
        System.out.println(
            "Saldo actual: $" + cuenta.consultarSaldo()
        );
    }

    @Override
    public void deshacer() {
    }
}

