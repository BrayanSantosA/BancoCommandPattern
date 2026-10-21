package command;
import receiver.CuentaBancaria;
public class TransferirCommand implements Command {
    private final CuentaBancaria origen;
    private final CuentaBancaria destino;
    private final double monto;
    private boolean ejecutado;

    public TransferirCommand(
        CuentaBancaria origen,
        CuentaBancaria destino,
        double monto
    ) {
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        origen.transferir(destino, monto);
        ejecutado = true;
    }

    @Override
    public void deshacer() {
        if (ejecutado) {
            destino.transferir(origen, monto);
            ejecutado = false;
        }
    }
}
