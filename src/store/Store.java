package store;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
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
    this.taxaBoleto = 5.0;
    this.taxaCartao = 0.05;
  }

  public void addComprador(Comprador comp) {
    this.listaComprador.add(comp);
  }

  public void addVendedor(Vendedor vend) {
    this.listaVendedor.add(vend);
  }

  public void pix(String cpfComprador, String cnpjVendedor, List<String> codigos) {
    Comprador compradorAtual = new Comprador("samplep", 0, "samplep");
    Vendedor vendedorAtual = new Vendedor("samplevp", "samplevp");
    double valorCompra = 0;
    for (Comprador comprador : listaComprador) {
      if (comprador.getCpf().equals(cpfComprador)) {
        compradorAtual = comprador;
      }
    }

    for (Vendedor vendedor : listaVendedor) {
      if (vendedor.getCnpj().equals(cnpjVendedor)) {
        vendedorAtual = vendedor;
      }
    }

    for (String codAt : codigos) {
      for (Produto prod : vendedorAtual.getCatalogo()) {
        if (codAt.equals(prod.getCodigo())) {
          valorCompra += prod.getPreco();
        }
      }
    }

    if (compradorAtual.getSaldo() > valorCompra) {
      double novoSaldoComprador = compradorAtual.getSaldo() - valorCompra;
      double novoSaldoVendedor = vendedorAtual.getSaldo() + valorCompra;
      compradorAtual.setSaldo(novoSaldoComprador);
      vendedorAtual.setSaldo(novoSaldoVendedor);
      compradorAtual.addCompraRealizada();
      vendedorAtual.addVendaRealizada();
    }
  }

  public void debito(String cpfComprador, String cnpjVendedor, List<String> codigos) {
    Comprador compradorAtual = new Comprador("sampled", 0, "sampled");
    Vendedor vendedorAtual = new Vendedor("sampleva", "sampleva");
    double valorCompra = 0;
    for (Comprador comprador : listaComprador) {
      if (comprador.getCpf().equals(cpfComprador)) {
        compradorAtual = comprador;
      }
    }

    for (Vendedor vendedor : listaVendedor) {
      if (vendedor.getCnpj().equals(cnpjVendedor)) {
        vendedorAtual = vendedor;
      }
    }

    for (String codAt : codigos) {
      for (Produto prod : vendedorAtual.getCatalogo()) {
        if (codAt.equals(prod.getCodigo())) {
          valorCompra += prod.getPreco();
        }
      }
    }

    if (compradorAtual.getSaldo() > valorCompra) {
      double novoSaldoComprador = compradorAtual.getSaldo() - valorCompra * (1 + taxaCartao);
      double novoSaldoVendedor = vendedorAtual.getSaldo() + valorCompra;
      compradorAtual.setSaldo(novoSaldoComprador);
      vendedorAtual.setSaldo(novoSaldoVendedor);
      compradorAtual.addCompraRealizada();
      vendedorAtual.addVendaRealizada();
    }
  }

  public void credito(String cpfComprador, String cnpjVendedor, List<String> codigos) {
    Comprador compradorAtual = new Comprador("samplec", 0, "samplec");
    Vendedor vendedorAtual = new Vendedor("samplev", "samplev");
    double valorCompra = 0;
    for (Comprador comprador : listaComprador) {
      if (comprador.getCpf().equals(cpfComprador)) {
        compradorAtual = comprador;
      }
    }

    for (Vendedor vendedor : listaVendedor) {
      if (vendedor.getCnpj().equals(cnpjVendedor)) {
        vendedorAtual = vendedor;
      }
    }

    for (String codAt : codigos) {
      for (Produto prod : vendedorAtual.getCatalogo()) {
        if (codAt.equals(prod.getCodigo())) {
          valorCompra += prod.getPreco();
        }
      }
    }

    if (compradorAtual.getSaldo() > valorCompra) {
      double novoSaldoComprador = compradorAtual.getSaldo() - valorCompra * (1 + taxaCartao);
      double novoSaldoVendedor = vendedorAtual.getSaldo() + valorCompra;
      compradorAtual.setSaldo(novoSaldoComprador);
      vendedorAtual.setSaldo(novoSaldoVendedor);
      compradorAtual.addCompraRealizada();
      vendedorAtual.addVendaRealizada();
    }
  }

  public void boleto(String cpfComprador, String cnpjVendedor, List<String> codigos, LocalDate date) {
    Comprador compradorAtual = new Comprador("sample", 0, "sample");
    Vendedor vendedorAtual = new Vendedor("sampleve", "sampleve");
    double valorCompra = 0;
    for (Comprador comprador : listaComprador) {
      if (comprador.getCpf().equals(cpfComprador)) {
        compradorAtual = comprador;
      }
    }

    for (Vendedor vendedor : listaVendedor) {
      if (vendedor.getCnpj().equals(cnpjVendedor)) {
        vendedorAtual = vendedor;
      }
    }

    for (String codAt : codigos) {
      for (Produto prod : vendedorAtual.getCatalogo()) {
        if (codAt.equals(prod.getCodigo())) {
          valorCompra += prod.getPreco();
        }
      }
    }

    if (compradorAtual.getSaldo() > valorCompra && (date.isAfter(LocalDate.now()) || date.isEqual(LocalDate.now()))) {
      double novoSaldoComprador = compradorAtual.getSaldo() - valorCompra - taxaBoleto;
      double novoSaldoVendedor = vendedorAtual.getSaldo() + valorCompra;
      compradorAtual.setSaldo(novoSaldoComprador);
      vendedorAtual.setSaldo(novoSaldoVendedor);
      compradorAtual.addCompraRealizada();
      vendedorAtual.addVendaRealizada();
    }

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
