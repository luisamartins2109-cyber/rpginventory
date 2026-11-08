package rpginventory;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n========== RPG INVENTORY ==========");
            System.out.println("1 - Adicionar item");
            System.out.println("2 - Listar inventario");
            System.out.println("3 - Atualizar item");
            System.out.println("4 - Remover item");
            System.out.println("5 - Pesquisar item");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    adicionarItem(inventario);
                    break;
                case 2:
                    inventario.listar();
                    break;
                case 3:
                    atualizarItem(inventario);
                    break;
                case 4:
                    removerItem(inventario);
                    break;
                case 5:
                    pesquisarItem(inventario);
                    break;
                case 0:
                    System.out.println("Jogo encerrado. Ate a proxima!");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }
        }

        sc.close();
    }

    public static void adicionarItem(Inventario inventario) {
        System.out.println("\nTipo de item:");
        System.out.println("1 - Arma");
        System.out.println("2 - Armadura");
        System.out.println("3 - Pocao");
        System.out.print("Escolha: ");
        int tipo = lerInteiro();

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo invalido.");
            return;
        }

        System.out.print("Nome do item: ");
        String nome = lerTexto();

        System.out.print("Quantidade: ");
        int quantidade = lerInteiro();
        while (quantidade < 1) {
            System.out.print("Digite uma quantidade maior que zero: ");
            quantidade = lerInteiro();
        }

        System.out.print("Valor em moedas de ouro: ");
        double valor = lerDouble();
        while (valor < 0) {
            System.out.print("Digite um valor igual ou maior que zero: ");
            valor = lerDouble();
        }

        int codigo = inventario.gerarCodigo();
        Item item;

        switch (tipo) {
            case 1:
                System.out.print("Dano da arma: ");
                int dano = lerInteiro();
                while (dano < 0) {
                    System.out.print("Digite um dano igual ou maior que zero: ");
                    dano = lerInteiro();
                }
                item = new Arma(codigo, nome, quantidade, valor, dano);
                break;
            case 2:
                System.out.print("Pontos de defesa: ");
                int defesa = lerInteiro();
                while (defesa < 0) {
                    System.out.print("Digite uma defesa igual ou maior que zero: ");
                    defesa = lerInteiro();
                }
                item = new Armadura(codigo, nome, quantidade, valor, defesa);
                break;
            default:
                System.out.print("Efeito da pocao: ");
                String efeito = lerTexto();
                item = new Pocao(codigo, nome, quantidade, valor, efeito);
                break;
        }

        inventario.adicionar(item);
    }

    public static void atualizarItem(Inventario inventario) {
        System.out.print("Digite o codigo do item que deseja atualizar: ");
        int codigo = lerInteiro();
        Item item = inventario.buscarPorCodigo(codigo);

        if (item == null) {
            System.out.println("Item nao encontrado.");
            return;
        }

        System.out.println("Item encontrado. Informe os novos dados.");
        System.out.print("Novo nome: ");
        String nome = lerTexto();

        System.out.print("Nova quantidade: ");
        int quantidade = lerInteiro();
        while (quantidade < 1) {
            System.out.print("Digite uma quantidade maior que zero: ");
            quantidade = lerInteiro();
        }

        System.out.print("Novo valor: ");
        double valor = lerDouble();
        while (valor < 0) {
            System.out.print("Digite um valor igual ou maior que zero: ");
            valor = lerDouble();
        }

        item.setNome(nome);
        item.setQuantidade(quantidade);
        item.setValor(valor);
        System.out.println("Item atualizado com sucesso!");
    }

    public static void removerItem(Inventario inventario) {
        System.out.print("Digite o codigo do item que deseja remover: ");
        int codigo = lerInteiro();

        if (inventario.remover(codigo)) {
            System.out.println("Item removido com sucesso!");
        } else {
            System.out.println("Item nao encontrado.");
        }
    }

    public static void pesquisarItem(Inventario inventario) {
        System.out.print("Digite o codigo do item: ");
        int codigo = lerInteiro();
        Item item = inventario.buscarPorCodigo(codigo);

        if (item != null) {
            System.out.println("\n===== ITEM ENCONTRADO =====");
            item.mostrarInfo();
        } else {
            System.out.println("Item nao encontrado.");
        }
    }

    public static int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Digite um numero inteiro valido: ");
            }
        }
    }

    public static double lerDouble() {
        while (true) {
            try {
                String valor = sc.nextLine().replace(",", ".");
                return Double.parseDouble(valor);
            } catch (NumberFormatException e) {
                System.out.print("Digite um valor numerico valido: ");
            }
        }
    }

    public static String lerTexto() {
        String texto = sc.nextLine().trim();
        while (texto.isEmpty()) {
            System.out.print("O texto nao pode ficar vazio. Digite novamente: ");
            texto = sc.nextLine().trim();
        }
        return texto;
    }
}
