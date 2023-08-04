abstract class Conta {
	
	 /*************
	  * ATRIBUTOS *
	  *************/
	  protected double saldo;
	  protected String numConta;
	  protected String numAgencia;
	  protected Cliente titular;
	  
	  //construtor
	  public Conta(double saldo, String numConta, String numAgencia, Cliente titular){
	    this.saldo = saldo;
	    this.numConta = numConta;
	    this.numAgencia = numAgencia;
	    this.titular = titular;
	  }

	 /***********
	  * MÉTODOS *
	  ***********/

	  //DEPOSITAR
	  public void depositar(double valor){
	    if (valor > 0) {
	      saldo += valor;
	      System.out.println("Depósito realizado com sucesso");
	    } else {
	      System.out.println("Valor inválido para depósito.");
	    }
	  }

	  //TRANSFERENCIA
	  public void transferir(Conta destino, double valor) {
	    if (valor > 0 && valor <= saldo) {
	        this.saldo -= valor;
	        destino.depositar(valor);
	        System.out.println("Transferência realizada");
	    } else {
	        System.out.println("Transferência inválida. Saldo insuficiente ou valor inválido.");
	    }

	  }
	  
	  /** MODIFICADORES DE DADOS **/
	  
	    // LOGIN CHECKER
	    public boolean loginCheck(String dado, String senha) {
	    	if ( (this.titular.login == dado || this.titular.email == dado) && this.titular.senha == senha) {
	    		// Caso o dado(string) fornecido seja o email ou login correto
	    		return true;
	    	} else {
	    		return false;
	    	}
	    }
	  
	  /********************* 
	  * SETTERS E GETTERS *
	  *********************/

  	protected void setNome(String novo) {
		  this.titular.nome = novo;
	  }
	  protected void setSenha(String nova) {
		  this.titular.senha = nova;
	  }
	  protected void setEmail(String novo) {
		  this.titular.email = novo;
	  }
	  protected void setLogin(String novo) {
		  this.titular.login = novo;
	  }
	  
	  public void getInfo() {
		  titular.getInfo();
		  System.out.println("Saldo: " + getSaldo());
		  System.out.println("Numero da Conta: " + getNumconta());
		  System.out.println("Numero da Agencia: " + getNumagencia());
	  }
	  
	  //CONSULTAR SALDO
	  public String getSaldo() {
	    return "R$" + saldo;
	  }

	  public String getNumconta(){
	    return numConta;
	  }

	  public String getNumagencia(){
	    return numAgencia;
	  }

	  public Cliente getTitular(){
	    return titular;
	  }

}