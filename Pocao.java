package rpginventory;

public class Pocao extends Item {
    private String efeito;

    public Pocao(int codigo, String nome, int quantidade, double valor, String efeito) {
        super(codigo, nome, quantidade, valor);
        this.efeito = efeito;
    }

    public String getEfeito() {
        return efeito;
    }

    public void setEfeito(String novoEfeito) {
        if (novoEfeito != null && !novoEfeito.trim().isEmpty()) {
            efeito = novoEfeito;
        }
    }

    @Override
    public String getTipo() {
        return "Pocao";
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Efeito: " + efeito);
    }
}
