# RPG Inventory

## Descricao
Sistema de gerenciamento de inventario de um jogo RPG, desenvolvido em Java e executado pelo terminal.

## Funcionalidades
- Adicionar armas, armaduras e pocoes.
- Listar os itens cadastrados.
- Atualizar nome, quantidade e valor de um item.
- Remover item pelo codigo.
- Pesquisar item pelo codigo.
- Encerrar o programa pelo menu.

## Conteudos de Java utilizados
- Classes e objetos.
- Construtores e metodos.
- Encapsulamento (atributos privados, getters e setters).
- Heranca (`Arma`, `Armadura` e `Pocao` herdam de `Item`).
- Polimorfismo (metodo `mostrarInfo` sobrescrito).
- `ArrayList`.
- `Scanner`, `while`, `for`, `switch` e `if/else`.

## Como executar
1. Abra a pasta `RPG-Inventory` no VS Code.
2. Abra o terminal do VS Code.
3. Entre na pasta `src`, caso o terminal nao esteja nela:
   `cd src`
4. Compile os arquivos:
   `javac rpginventory/*.java`
5. Execute:
   `java rpginventory.Main`


