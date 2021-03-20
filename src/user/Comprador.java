package user;

public class Comprador extends User {

  private double valorAPagar;
  private String cpf;
  
  public Comprador(String nome, double saldo, String cpf) {
    super(nome, saldo);
    this.valorAPagar = 0.0;
    this.cpf = cpf;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null || !other.getClass().equals(Comprador.class)) {
      return false;
    } else {
      Comprador otherComprador = (Comprador) other;
      return this.cpf.equals(otherComprador.cpf);
    }
  }

  @Override
  public int hashCode() {
    return this.cpf.hashCode();
  }
}
