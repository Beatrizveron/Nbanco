public class contaPoupanca extends Conta {
  /*************
  * ATRIBUTOS *
  *************/
  private double taxaRendimento; // Rendimento da poupança do mês
  
  /*CONSTRUTOR*/
  public contaPoupanca(double saldo, String numConta, String numAgencia, Cliente nomeTitular, double taxaRendimento){
    super(saldo, numConta, numAgencia, nomeTitular);
    this.taxaRendimento = taxaRendimento;
  }

  /********************* 
   * SETTERS E GETTERS *
   *********************/
  public double getTaxaRendimento(){
    return taxaRendimento;
  }
}