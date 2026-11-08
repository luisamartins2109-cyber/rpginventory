package rpginventory;

public class Armadura extends Item {
    private int defesa;

    public Armadura(int codigo, String nome, int quantidade, double valor, int defesa) {
        super(codigo, nome, quantidade, valor);
        this.defesa = defesa;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int novaDefesa) {
        if (novaDefesa >= 0) {
            defesa = novaDefesa;
        }
    }

    @Override
    public String getTipo() {
        return "Armadura";
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Defesa: " + defesa);
    }
}
