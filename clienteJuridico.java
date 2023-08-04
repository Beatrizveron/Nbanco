////conta PJ Bmg você não tem taxas, faz transferência grátis para qualquer banco, agenda de pagamentos, realiza pagamento de contas e faz saque sem cartão.

public class clienteJuridico extends Cliente{
  /*************
	  * ATRIBUTOS *
	  *************/
	  private String CNPJ;
	  private double faturamento;
	  private String razaoSocial;

	  /*CONSTRUTOR*/
	  public clienteJuridico(String nome, String dataNascimento, String numeroCelular, String endereco, String login, String senha, String email, String CNPJ, double faturamento, String razaoSocial){
	    super(nome, dataNascimento, numeroCelular, endereco, login, senha, email);
	    this.CNPJ = CNPJ;
	    this.faturamento = faturamento;
	    this.razaoSocial = razaoSocial;
	    
	  }

	  /********************* 
	  * SETTERS E GETTERS *
	  *********************/
	    
	  /** SETTERS **/
	  public void setFaturamento(double faturamento){
	    this.faturamento = faturamento;
	  }

	   /** GETTERS **/
	  public String getCNPJ() {
	    return CNPJ;
	  }

	  public double getFaturamento() {
	    return faturamento;
	  }

	  public String getRazaoSocial() {
	    return razaoSocial;
	  }
}

//os bancos oferecem alguns benefícios específicos para a pessoa jurídica que vão desde tarifas mais baixas que as das contas de bancos tradicionais, segurança do seu dinheiro (cobertura do FGC até R$250 mil, a mesma proteção das instituições tradicionais) e até mesmo oferta de alguns serviços de investimentos

//metodos:
//fazer tranferencia
//agendar pagamentos de boletos
//realizar pagamentos
//receber pagamentos
  




  
