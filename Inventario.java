package rpginventory;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> itens;
    private int proximoCodigo;

    public Inventario() {
        itens = new ArrayList<Item>();
        proximoCodigo = 1;
    }

    public int gerarCodigo() {
        return proximoCodigo++;
    }

    public void adicionar(Item item) {
        itens.add(item);
        System.out.println("Item adicionado ao inventario!");
    }

    public void listar() {
        if (itens.isEmpty()) {
            System.out.println("O inventario esta vazio.");
        } else {
            System.out.println("\n===== ITENS DO INVENTARIO =====");
            for (int i = 0; i < itens.size(); i++) {
                System.out.println("\n------------------------------");
                itens.get(i).mostrarInfo();
            }
        }
    }

    public Item buscarPorCodigo(int codigo) {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getCodigo() == codigo) {
                return itens.get(i);
            }
        }
        return null;
    }

    public boolean remover(int codigo) {
        Item item = buscarPorCodigo(codigo);

        if (item != null) {
            itens.remove(item);
            return true;
        }
        return false;
    }

    public boolean estaVazio() {
        return itens.isEmpty();
    }
}
