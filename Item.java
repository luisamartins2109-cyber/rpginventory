package rpginventory;

// Classe base dos itens do inventario
public class Item {
    private int codigo;
    private String nome;
    private int quantidade;
    private double valor;

    public Item(int codigo, String nome, int quantidade, double valor) {
        this.codigo = codigo;
        setNome(nome);
        setQuantidade(quantidade);
        setValor(valor);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            nome = novoNome;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int novaQuantidade) {
        if (novaQuantidade >= 1) {
            quantidade = novaQuantidade;
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double novoValor) {
        if (novoValor >= 0) {
            valor = novoValor;
        }
    }

    public String getTipo() {
        return "Item";
    }

    public void mostrarInfo() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + getTipo());
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Valor: " + valor + " moedas de ouro");
    }
}
