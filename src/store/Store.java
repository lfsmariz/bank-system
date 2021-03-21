package store;

import java.util.HashSet;
import java.util.Set;

import store.utils.Produto;
import user.Comprador;
import user.Vendedor;

public class Store {
  private double taxaCartao;
  private double taxaBoleto;
  private Set<Comprador> listaComprador = new HashSet<>();
  private Set<Vendedor> listaVendedor = new HashSet<>();
  private Set<Produto> listaProdutos = new HashSet<>();

  public Store() {
    this.taxaBoleto = 10.0;
    this.taxaCartao = 0.05;
  }

  public void addComprador(Comprador comp) {
    this.listaComprador.add(comp);
  }

  public void addVendedor(Vendedor vend) {
    this.listaVendedor.add(vend);
  }

  public void showVendedor(String cnpj) {
    for (Vendedor vendedor : listaVendedor) {
      if (vendedor.getCnpj().equals(cnpj)) {
        System.out.println(vendedor + "\n");
        System.out.println("Produtos Cadastrados");
        vendedor.showCatalogo();
      }
    }
  }

  public void showComprador(String cpf) {
    for (Comprador comprador : listaComprador) {
      if (comprador.getCpf().equals(cpf)) {
        System.out.println(comprador);
      }
    }
  }

  public void showCompradores() {
    for (Comprador comprador : listaComprador) {
      System.out.println(comprador);
    }
  }

  public void showVendedores() {
    for (Vendedor vendedor : listaVendedor) {
      System.out.println(vendedor);
    }
  }
}
