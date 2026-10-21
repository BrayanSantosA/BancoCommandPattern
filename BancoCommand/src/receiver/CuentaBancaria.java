package receiver;
public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException(
                "El saldo inicial no puede ser negativo"
            );
        }
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        validarMonto(monto);
        saldo += monto;
    }

    public void retirar(double monto) {
        validarMonto(monto);

        if (monto > saldo) {
            throw new IllegalStateException(
                "Saldo insuficiente"
            );
        }

        saldo -= monto;
    }

    public void transferir(CuentaBancaria destino, double monto) {
        if (destino == null || destino == this) {
            throw new IllegalArgumentException(
                "La cuenta destino no es válida"
            );
        }

        validarMonto(monto);

        if (monto > saldo) {
            throw new IllegalStateException(
                "Saldo insuficiente para transferir"
            );
        }

        saldo -= monto;
        destino.depositar(monto);
    }

    public double consultarSaldo() {
        return saldo;
    }

    private void validarMonto(double monto) {
        if (!Double.isFinite(monto) || monto <= 0) {
            throw new IllegalArgumentException(
                "El monto debe ser positivo y válido"
            );
        }
    }
}