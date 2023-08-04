public class contaCorrente extends Conta {
  /*************
   * ATRIBUTOS *
   *************/
  private double limCredito;

  /*CONSTRUTOR*/
  public contaCorrente(double saldo, String numConta, String numAgencia, Cliente nomeTitular, double limCredito){
    super(saldo, numConta, numAgencia, nomeTitular);
    this.limCredito = limCredito;
  }

  /***********
   * MÉTODOS *
   ***********/
/*
  public void fazerPix(String chavePix, double valor) {
    if (valor > 0 && valor <= saldo) {
      saldo -= valor;
      System.out.println("PIX realizado!");
      System.out.println("Chave PIX: " + chavePix);
    }else {
      System.out.println("PIX inválido. Saldo insuficiente ou valor inválido.");
    }
  }
*/
  /********************* 
   * SETTERS E GETTERS *
   *********************/
  
  public double getLimcredito(){
      return limCredito;
    }

  public void setLimCredito(double limCredito){
      this.limCredito = limCredito;
    }
}