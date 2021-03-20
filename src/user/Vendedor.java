package user;

public class Vendedor extends User {
  
  private double valorAReceber;
  private String cnpj;
  
  public Vendedor(String nome, double saldo, String cnpj) {
    super(nome, saldo);
    this.valorAReceber = 0.0;
    this.cnpj = cnpj;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null || !other.getClass().equals(Vendedor.class)) {
      return false;
    } else {
      Vendedor otherVendedor = (Vendedor) other;
      return this.cnpj.equals(otherVendedor.cnpj);
    }
  }

  @Override
  public int hashCode() {
    return this.cnpj.hashCode();
  }
}
