package rpginventory;

public class Arma extends Item {
    private int dano;

    public Arma(int codigo, String nome, int quantidade, double valor, int dano) {
        super(codigo, nome, quantidade, valor);
        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int novoDano) {
        if (novoDano >= 0) {
            dano = novoDano;
        }
    }

    @Override
    public String getTipo() {
        return "Arma";
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Dano: " + dano);
    }
}
