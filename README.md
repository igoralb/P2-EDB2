
# Projeto: Sistema de Gestão de Estoque com Árvore Binária de Busca

Este projeto implementa um sistema simples de gestão de estoque utilizando uma estrutura de dados de **Árvore Binária de Busca (ABB)** em Java. O sistema permite adicionar, buscar, remover e exibir produtos organizados por código em uma árvore binária.

## Estrutura do Projeto

O projeto contém as seguintes classes:

- **Produto**: Representa um produto no estoque, com atributos como código, nome e quantidade.
- **ArvoreBinariaDeBusca**: Implementa a árvore binária de busca para gerenciar os produtos. Contém métodos para inserir, buscar, remover e exibir produtos, além de métodos para exibir o produto com o menor e maior código.
- **Main**: Classe principal que contém o método `main` para executar o programa. Aqui, os métodos da árvore são utilizados para gerenciar o estoque.

## Funcionalidades

1. **Inserir Produto**: Adiciona um novo produto à árvore binária. Se o produto já existir (mesmo código), a quantidade é atualizada.
2. **Buscar Produto**: Permite buscar um produto na árvore pelo código e retorna seus detalhes (nome e quantidade).
3. **Remover Produto**: Remove um produto da árvore pelo código, ajustando a árvore de forma correta para manter sua estrutura.
4. **Exibir Produtos em Ordem**: Exibe todos os produtos em ordem crescente de código.
5. **Exibir Produto com Menor Código**: Exibe o produto com o menor código presente na árvore.
6. **Exibir Produto com Maior Código**: Exibe o produto com o maior código presente na árvore.

## Uso

No método `main` da classe `Main`, você pode ver um exemplo de uso do sistema:

- Inserção de produtos: `estoque.inserirProduto(new Produto(101, "Notebook", 50));`
- Busca de produtos: `Produto p = estoque.buscarProduto(50);`
- Remoção de produtos: `estoque.removerProduto(101);`
- Exibição dos produtos: `estoque.exibirProdutosEmOrdem();`
- Exibição do produto com menor código: `estoque.exibirProdutoComMenorCodigo();`
- Exibição do produto com maior código: `estoque.exibirProdutoComMaiorCodigo();`

## Execução

Para executar o projeto, basta compilar e rodar o arquivo `Main.java` em um ambiente de desenvolvimento Java.

```bash
javac Main.java
java Main
```

## Observações

- Os métodos `exibirProdutoComMenorCodigo()` e `exibirProdutoComMaiorCodigo()` foram encapsulados para que imprimam diretamente o resultado ao serem chamados.
