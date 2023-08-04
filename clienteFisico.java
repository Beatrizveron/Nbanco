public class clienteFisico extends Cliente{
  /*************
	  * ATRIBUTOS *
	  *************/
	  private String CPF;
	  private String RG;
	  private double renda;

	  /*CONSTRUTOR*/
	  public clienteFisico(String nome, String dataNascimento, String numeroCelular, String endereco, String login, String senha, String email, String CPF, String RG, double renda){
	    super(nome, dataNascimento, numeroCelular, endereco, login, senha, email);
	    this.CPF = CPF;
	    this.RG = RG;
	    this.renda = renda;
	  }

	  /********************* 
	  * SETTERS E GETTERS *
	  *********************/
	    
	  /** SETTERS **/
	  public void setRenda(double renda){
	    this.renda = renda;
	  }
	    
	  /** GETTERS **/
	  public String getCPF() {
	    return CPF;
	  }

	  public String getRG() {
	    return RG;
	  }

	  public double getRenda() {
	    return renda;
	  }
}
