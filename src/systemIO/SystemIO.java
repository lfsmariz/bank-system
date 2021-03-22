package systemIO;

import java.io.IOException;
import java.util.Scanner;

import store.Store;
import store.utils.Produto;
import user.Comprador;
import user.Vendedor;

public class SystemIO {

  private boolean run;
  private Store loja;
  private String input;
  private Scanner ioManager;

  public SystemIO() {
    this.run = true;
    this.loja = new Store();
    this.ioManager = new Scanner(System.in);
  }

  private static void showOptions() {
    System.out.println("1 - Cadastrar Comprador.");
    System.out.println("2 - Cadastrar Vendedor.");
    System.out.println("3 - Cadastrar Produto.");
    System.out.println("4 - Realizar Pagamento.");
    System.out.println("5 - Mostrar Compradores Cadastrados");
    System.out.println("6 - Mostrar Vendedores Cadastrados");
    System.out.println("7 - Mostrar Produtos Cadastrados");
    System.out.println("8 - Mostrar Comprador por CPF");
    System.out.println("9 - Mostrar Vendedor por CNPJ");
    System.out.println("10 - Associar produto ao vendedor");
    System.out.println("11 - Realizar pagamento");
    System.out.println("0 - SAIR");
  }

  private static void optPagamentos() {
    System.out.println("\n FORMAS DE PAGAMENTO:\n");
    System.out.println("p - Pagamento por pix.");
    System.out.println("b - Pagamento por boleto.");
    System.out.println("d - Pagamento por debito.");
    System.out.println("c - Pagamento por credito.");
    System.out.println("r - Retornar ao menu anterior");
  }

  private void selectFormaPagamento() {
    String formaDePagamento;
    formaDePagamento = this.ioManager.nextLine();

    switch (formaDePagamento) {
    case "p":
      System.out.println("\nPix Selecionado\n");
      break;
    case "d":
      System.out.println("\nDebito Selecionado\n");
      break;
    case "c":
      System.out.println("\nCredito Selecionado\n");
      break;
    case "b":
      System.out.println("\nBoleto Selecionado\n");
      break;
    default:
      System.out.println("Nenhuma opcao selecionada");
      break;
    }
  }

  private static void waitForEnter() {
    try {
      System.in.read();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void cadastroComprador() {
    String nomeComprador;
    String cpfComprador;
    Double saldoComprador;
    System.out.println("\nInsira o nome do comprador.\n");
    nomeComprador = this.ioManager.nextLine();

    System.out.println("\nInsira o saldo do comprador.\n");
    saldoComprador = this.ioManager.nextDouble();

    System.out.println("\nInsira o cpf do comprador.\n");
    cpfComprador = this.ioManager.next();

    Comprador novoComprador = new Comprador(nomeComprador, saldoComprador, cpfComprador);

    this.loja.addComprador(novoComprador);
  }

  private void cadastroVendedor() {
    String nomeVendedor;
    String cnpjVendedor;
    System.out.println("\nInsira o nome do Vendedor.\n");
    nomeVendedor = this.ioManager.nextLine();

    System.out.println("\nInsira o cnpj do Vendedor.\n");
    cnpjVendedor = this.ioManager.next();

    Vendedor novoVendedor = new Vendedor(nomeVendedor, cnpjVendedor);

    this.loja.addVendedor(novoVendedor);
  }

  private void cadastroProduto() {
    String novoCodigo;
    String novoNome;
    double novoPreco;

    System.out.println("\nInsira o nome do Produto.\n");
    novoNome = this.ioManager.nextLine();

    System.out.println("\nInsira o codigo do Produto.\n");
    novoCodigo = this.ioManager.next();

    System.out.println("\nInsira o preco do Produto.\n");
    novoPreco = this.ioManager.nextDouble();

    Produto novoProduto = new Produto(novoCodigo, novoNome, novoPreco);

    this.loja.addProduto(novoProduto);
  }

  private void mostrarCompradores() {
    this.loja.showCompradores();
  }

  private void mostrarCNPJ() {
    String cnpjVendedor;
    System.out.println("Digite o cnpj do vendedor");
    cnpjVendedor = this.ioManager.nextLine();

    this.loja.showVendedor(cnpjVendedor);
  }

  private void mostrarCPF() {
    String cpfComprador;
    System.out.println("Digite o cpf do comprador");
    cpfComprador = this.ioManager.nextLine();

    this.loja.showComprador(cpfComprador);
  }

  private void mostrarVendedores() {
    this.loja.showVendedores();
  }

  private void mostrarProdutos() {
    this.loja.showProdutos();
  }

  private void associarProduto() {
    String cnpjVendedor;
    String codigoProduto;
    Produto produtoAtual = null;
    System.out.println("Digite o CNPJ do Vendedor");
    cnpjVendedor = this.ioManager.next();
    System.out.println("Digite o Codigo do Produto");
    codigoProduto = this.ioManager.next();

    for (Produto prod : this.loja.getListaProdutos()) {
      if (prod.getCodigo().equals(codigoProduto)) {
        produtoAtual = prod;
      }
    }

    if (produtoAtual != null) {
      for (Vendedor vend : this.loja.getListaVendedor()) {
        if (vend.getCnpj().equals(cnpjVendedor)) {
          vend.addCatalog(produtoAtual);
        }
      }
    }
  }

  private void selectOption() {
    switch (this.input) {
    case "1":
      System.out.println("\nCadastrando comprador...\n");
      cadastroComprador();
      break;
    case "2":
      System.out.println("\nCadastrando vendedor...\n");
      cadastroVendedor();
      break;
    case "3":
      System.out.println("\nCadastrando produto...\n");
      cadastroProduto();
      break;
    case "4":
      System.out.println("\nRealizando pagamento...\n");
      break;
    case "5":
      System.out.println("\nLista Compradores:\n");
      mostrarCompradores();
      System.out.println("\nPressione qualquer tecla para voltar ao menu principal\n");
      waitForEnter();
      break;
    case "6":
      System.out.println("\nLista Vendedores\n");
      mostrarVendedores();
      System.out.println("\nPressione qualquer tecla para voltar ao menu principal\n");
      waitForEnter();
      break;
    case "7":
      System.out.println("\nLista de Produtos\n");
      mostrarProdutos();
      System.out.println("\nPressione qualquer tecla para voltar ao menu principal\n");
      waitForEnter();
      break;
    case "8":
      System.out.println("\nComprador:\n");
      mostrarCPF();
      System.out.println("\nPressione qualquer tecla para voltar ao menu principal\n");
      waitForEnter();
      break;
    case "9":
      System.out.println("\nVendedor:\n");
      mostrarCNPJ();
      System.out.println("\nPressione qualquer tecla para voltar ao menu principal\n");
      waitForEnter();
      break;
    case "10":
      System.out.println("\nAssociação de produto\n");
      associarProduto();
      break;
    case "11":
      optPagamentos();
      selectFormaPagamento();
      break;
    case "0":
      System.out.println("\nEncerrando programa...\n");
      this.run = false;
      break;
    default:
      break;
    }
  }

  public void initialize() {
    System.out.println("Sistema de Loja Iniciado!\n");
    while (run) {
      System.out.println("Selecione a opção abaixo:\n");
      showOptions();
      this.input = this.ioManager.nextLine();
      selectOption();
    }
    this.ioManager.close();
    System.out.println("Sistema de Loja Encerrado!\n");
  }

}
