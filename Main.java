class Produto {
  int codigo;
  String nome;
  int quantidade;

  public Produto(int codigo, String nome, int quantidade) {
      this.codigo = codigo;
      this.nome = nome;
      this.quantidade = quantidade;
  }

  public int getCodigo() {
      return codigo;
  }

  public String getNome() {
      return nome;
  }

  public int getQuantidade() {
      return quantidade;
  }

  public void setQuantidade(int quantidade) {
      this.quantidade = quantidade;
  }
}

class ArvoreBinariaDeBusca {
  private class No {
      Produto produto;
      No esquerda, direita;

      No(Produto produto) {
          this.produto = produto;
      }
  }

  private No raiz;

  public void inserirProduto(Produto produto) {
      raiz = inserirProdutoRec(raiz, produto);
  }

  private No inserirProdutoRec(No atual, Produto produto) {
      if (atual == null) {
          return new No(produto);
      }

      if (produto.getCodigo() < atual.produto.getCodigo()) {
          atual.esquerda = inserirProdutoRec(atual.esquerda, produto);
      } else if (produto.getCodigo() > atual.produto.getCodigo()) {
          atual.direita = inserirProdutoRec(atual.direita, produto);
      } else {
          atual.produto.setQuantidade(atual.produto.getQuantidade() + produto.getQuantidade());
      }

      return atual;
  }

  public Produto buscarProduto(int codigo) {
      return buscarProdutoRec(raiz, codigo);
  }

  private Produto buscarProdutoRec(No atual, int codigo) {
      if (atual == null || atual.produto.getCodigo() == codigo) {
          return atual != null ? atual.produto : null;
      }

      if (codigo < atual.produto.getCodigo()) {
          return buscarProdutoRec(atual.esquerda, codigo);
      } else {
          return buscarProdutoRec(atual.direita, codigo);
      }
  }

  public void removerProduto(int codigo) {
      raiz = removerProdutoRec(raiz, codigo);
  }

  private No removerProdutoRec(No atual, int codigo) {
      if (atual == null) {
          return null;
      }

      if (codigo < atual.produto.getCodigo()) {
          atual.esquerda = removerProdutoRec(atual.esquerda, codigo);
      } else if (codigo > atual.produto.getCodigo()) {
          atual.direita = removerProdutoRec(atual.direita, codigo);
      } else {
          if (atual.esquerda == null && atual.direita == null) {
              return null;
          }
          if (atual.esquerda == null) {
              return atual.direita;
          }
          if (atual.direita == null) {
              return atual.esquerda;
          }
          Produto menorProduto = encontrarMenor(atual.direita);
          atual.produto = menorProduto;
          atual.direita = removerProdutoRec(atual.direita, menorProduto.getCodigo());
      }

      return atual;
  }

  private Produto encontrarMenor(No atual) {
      while (atual.esquerda != null) {
          atual = atual.esquerda;
      }
      return atual.produto;
  }

  public void exibirProdutosEmOrdem() {
      exibirProdutosEmOrdemRec(raiz);
  }

  private void exibirProdutosEmOrdemRec(No atual) {
      if (atual != null) {
          exibirProdutosEmOrdemRec(atual.esquerda);
          System.out.println("Código: " + atual.produto.getCodigo() + ", Nome: " + atual.produto.getNome() + ", Quantidade: " + atual.produto.getQuantidade());
          exibirProdutosEmOrdemRec(atual.direita);
      }
  }

  public void exibirProdutoComMenorCodigo() {
      if (raiz == null) {
          System.out.println("A árvore está vazia.");
      } else {
          No atual = raiz;
          while (atual.esquerda != null) {
              atual = atual.esquerda;
          }
          Produto menorProduto = atual.produto;
          System.out.println("Produto com menor código: " + menorProduto.getNome() + ", Código: " + menorProduto.getCodigo());
      }
  }

  public void exibirProdutoComMaiorCodigo() {
      if (raiz == null) {
          System.out.println("A árvore está vazia.");
      } else {
          No atual = raiz;
          while (atual.direita != null) {
              atual = atual.direita;
          }
          Produto maiorProduto = atual.produto;
          System.out.println("Produto com maior código: " + maiorProduto.getNome() + ", Código: " + maiorProduto.getCodigo());
      }
  }
}

public class Main {
  public static void main(String[] args) {
      ArvoreBinariaDeBusca estoque = new ArvoreBinariaDeBusca();

      estoque.inserirProduto(new Produto(101, "Notebook", 50));
      estoque.inserirProduto(new Produto(50, "Mouse", 200));
      estoque.inserirProduto(new Produto(200, "Teclado", 150));

      Produto p = estoque.buscarProduto(101);
    
      if (p != null) {
          System.out.println("Produto encontrado: " + p.getNome() + ", Quantidade: " + p.getQuantidade());
      }
    
      
      //estoque.exibirProdutosEmOrdem();

      //estoque.exibirProdutoComMenorCodigo();
      
      //estoque.exibirProdutoComMaiorCodigo();

      //estoque.removerProduto(101);
      
  }
}
