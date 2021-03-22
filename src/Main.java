import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import store.Store;
import store.utils.Produto;
import systemIO.SystemIO;
import user.Comprador;
import user.Vendedor;

/**
 * BankSystem
 */
public class Main {
  public static void main(String[] args) {

    // TESTE DE FUNCIONALIDADES

    // Store loja = new Store();

    // Produto prod1 = new Produto("111", "produto1", 1.0);
    // Produto prod2 = new Produto("222", "produto2", 2.0);

    // Comprador usuario1 = new Comprador("luiz", 15, "123");
    // Comprador usuario3 = new Comprador("luiz", 15, "123");
    // Comprador usuario2 = new Comprador("filipe", 15, "124");

    // Vendedor vend1 = new Vendedor("camila", "1234");
    // Vendedor vend3 = new Vendedor("camila", "1234");
    // Vendedor vend2 = new Vendedor("sales", "1235");

    // loja.addVendedor(vend1);
    // loja.addVendedor(vend2);

    // vend1.addCatalog(prod1);
    // vend1.addCatalog(prod2);

    // vend2.addCatalog(prod2);

    // loja.addComprador(usuario1);
    // loja.addComprador(usuario2);

    // // System.out.println("--------- Show Compradores -----------");

    // // loja.showCompradores();

    // // System.out.println("--------- Show Vendedores -----------");

    // // loja.showVendedores();

    // System.out.println("--------- Show Vendedor -----------");

    // loja.showVendedor("1234");

    // System.out.println("--------- Show Comprador -----------");

    // loja.showComprador("124");

    // System.out.println("--------- Após Compra -----------");

    // List<String> pedido = new ArrayList<>();

    // pedido.add("111");
    // pedido.add("111");
    // pedido.add("111");
    // pedido.add("222");

    // LocalDate dataVencimento = LocalDate.of(2021, 4, 21);
    
    // loja.boleto("124", "1234", pedido, dataVencimento);

    // loja.showComprador("124");

    SystemIO lojaAtual = new SystemIO();

    lojaAtual.initialize();
  }
}