import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		/******** 
		* MAIN *
		********/
		Banco B = new Banco("Nubank2");
		
		Scanner sc = new Scanner(System.in);

    System.out.println("Bem vindo ao " + B.getNome());
	
		int opcao = -1;
		
		while(opcao != 0) {
			exibirMenu();
			opcao = sc.nextInt();
            sc.nextLine();
			
            switch (opcao) {
            
            case 1:
            	perguntasCadastro(B, sc);
            	break;
            case 2:
                realizarDeposito(B, sc);
                break;
            case 3:
                realizarTransferencia(B, sc);
                break;
            case 4:
                realizarPix(B, sc);
                break;
            case 5:
                consultarSaldo(B, sc);
                break;
            case 6:
                alterarDadosCliente(B, sc);
                break;
            case 7:
            	  delete(B, sc);
            	  break;
            case 0:
                System.out.println("Encerrando...");
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
                break;
        }
        System.out.println();
    }		
}
		
		/******** 
		 * MENU *
		********/
		public static void exibirMenu() {
	        System.out.println("----- MENU -----");
	        System.out.println("1. Abrir uma Conta");
	        System.out.println("2. Realizar Depósito");
	        System.out.println("3. Realizar Transferência");
	        System.out.println("4. Realizar PIX");
	        System.out.println("5. Consultar Saldo");
	        System.out.println("6. Alterar Dados do Cliente");
	        System.out.println("7. Deletar conta");
	        System.out.println("0. Sair");
	        System.out.print("Escolha uma opção: ");
		}
		
		public static void perguntasCadastro(Banco banco, Scanner scanner) {
			System.out.println("--- Cadastrando Conta ---");
			
			System.out.println("Selecione o tipo de cliente que você é: ");
			System.out.println("1. Físico");
			System.out.println("2. Jurídico");
			int x = scanner.nextInt();
			
			System.out.println("Selecione o tipo de serviço que deseja possuir: ");
			System.out.println("1. Poupança");
			System.out.println("2. Corrente");
			int y = scanner.nextInt();
			
			switch (x) {
			case 1:
				cadastrarClienteFisico(banco, scanner, y);
				break;
			case 2:
				cadastrarClienteJuridico(banco, scanner, y);
				break;
			default:
				System.out.println("Desculpe, selecione uma opção válida.");
				break;
			}
		}
		
		// CLIENTE FISICO
		public static void cadastrarClienteFisico(Banco banco, Scanner scanner, int key) {
	        System.out.println("--- Cadastro de Cliente Físico ---");
	        
	        // Solicitar os dados do cliente físico
	        System.out.print("Nome: ");
	        String nome = scanner.nextLine();
	        // Consumir a quebra de linha pendente
	        scanner.nextLine();
	        
	        System.out.print("Data de Nascimento: ");
	        String data = scanner.nextLine();
	        
	        System.out.print("Número de celular: ");
	        String cel = scanner.nextLine();
	        
	        System.out.print("Endereço: ");
	        String endereco = scanner.nextLine();
	        
	        System.out.print("Crie um Login: ");
	        String login = scanner.nextLine();
	        
	        System.out.print("Crie uma senha: ");
	        String senha = scanner.nextLine();
	        
	        System.out.print("Digite seu email: ");
	        String email = scanner.nextLine();

	        System.out.print("CPF: ");
	        String cpf = scanner.nextLine();
	        
	        System.out.print("RG: ");
	        String rg = scanner.nextLine();
	        
	        System.out.print("Insira sua renda: ");
	        double renda = scanner.nextDouble();

	        // Criar um novo objeto
	        clienteFisico cf = new clienteFisico(nome, data, cel, endereco, login, senha, email, cpf, rg, renda);

	        // Adicionar o cliente ao banco   
	        try {
		        banco.addClienteFisico(cf);
		        
		        if(key == 1) {
		        	abrirContaPoupanca(banco, scanner, cf);
		        } else {
		        	abrirContaCorrente(banco, scanner, cf);
		        }
		        
	        	System.out.println("Cliente físico cadastrado com sucesso!");
	        	
	        } catch (IdadeMinimaException e) {
	        	System.out.println("ERRO: " + e.getMessage());
	        } catch (RuntimeException e) {
	        	System.out.println("ERRO: " + e.getMessage());
	        }
	    }

		// CLIENTE JURIDICO
	    public static void cadastrarClienteJuridico(Banco banco, Scanner scanner, int key) {
	        System.out.println("--- Cadastro de Cliente Jurídico ---");
	        
	        // Solicitar os dados do cliente juridico
	        System.out.print("Nome: ");
	        String nome = scanner.nextLine();
	        // Consumir a quebra de linha pendente
	        scanner.nextLine();
	        
	        System.out.print("Data de Nascimento: ");
	        String data = scanner.nextLine();
	        
	        System.out.print("Número de celular: ");
	        String cel = scanner.nextLine();
	        
	        System.out.print("Endereço: ");
	        String endereco = scanner.nextLine();
	        
	        System.out.print("Crie um Login: ");
	        String login = scanner.nextLine();
	        
	        System.out.print("Crie uma senha: ");
	        String senha = scanner.nextLine();
	        
	        System.out.print("Digite seu email: ");
	        String email = scanner.nextLine();
	        
	        System.out.print("Insira seu CNPJ: ");
	        String cnpj = scanner.nextLine();
	        
	        System.out.print("Digite sua fatura: ");
	        double fatura = scanner.nextDouble();
	        // Consumir a quebra de linha pendente
	        scanner.nextLine();
	        
	        System.out.print("Razão Social: ");
	        String razao = scanner.nextLine();
	        
	        clienteJuridico cj = new clienteJuridico(nome, data, cel, endereco, login, senha, email, cnpj, fatura, razao);
	        
	        // Adicionar o cliente ao banco   
	        try {
		        banco.addClienteJuridico(cj);
		        
		        if(key == 1) {
		        	abrirContaPoupanca(banco, scanner, cj);
		        } else {
		        	abrirContaCorrente(banco, scanner, cj);
		        }
		        
	        	System.out.println("Cliente jurídico cadastrado com sucesso!");
	        	
	        } catch (IdadeMinimaException e) {
	        	System.out.println("ERRO: " + e.getMessage());
	        } catch (RuntimeException e) {
	        	System.out.println("ERRO: " + e.getMessage());
	        }
	        
	    }

	    public static void abrirContaPoupanca(Banco banco, Scanner scanner, Cliente c) {
	        System.out.println("--- Abertura de Conta Poupanca ---");
	        
        	// Conta(saldo, numConta, numAgencia, titular)
        	System.out.print("Seu saldo inicial: ");
        	double saldo = scanner.nextDouble();
            // Consumir a quebra de linha pendente
            scanner.nextLine();
        	
        	System.out.print("Seu número de conta: ");
        	String num = scanner.nextLine();
        	
        	System.out.print("O número da sua agência: ");
        	String ag = scanner.nextLine();
      	        
        	Cliente titular = c;
        	
        	System.out.print("Sua taxa de rendimento: ");
        	double taxaRendimento = scanner.nextDouble();
        	
        	contaPoupanca P = new contaPoupanca(saldo, num, ag, titular, taxaRendimento);
        	banco.addContaPoupanca(P);
	    }
	    
	    public static void abrirContaCorrente(Banco banco, Scanner scanner, Cliente c) {
	        System.out.println("--- Abertura de Conta ---");
	        
        	// Conta(saldo, numConta, numAgencia, titular)
        	System.out.print("Seu saldo inicial: ");
        	double saldo = scanner.nextDouble();
            // Consumir a quebra de linha pendente
            scanner.nextLine();
        	
        	System.out.print("Seu número de conta: ");
        	String num = scanner.nextLine();
        	
        	System.out.print("O número da sua agência: ");
        	String ag = scanner.nextLine();
        	
        	Cliente titular = c;
        	
        	System.out.print("Limite de crédito: ");
        	double lim = scanner.nextDouble();
        	
        	contaCorrente C = new contaCorrente(saldo, num, ag, titular, lim);
        	banco.addContaCorrente(C);
        	
	    }

      // DEPÓSITO
	    public static void realizarDeposito(Banco banco, Scanner scanner) {
	        System.out.println("--- Realizar Depósito ---");
	        
	        System.out.print("Digite o número da conta: ");
	        String numeroConta = scanner.nextLine();
	        scanner.nextLine();
	        
	        Conta conta = banco.buscarConta(numeroConta);
	        
	        if (conta == null) {
	            System.out.println("Conta não encontrada. Verifique o número da conta e tente novamente.");
	            return;
	        }
	        
	        System.out.print("Informe o valor do depósito: ");
	        double valorDeposito = scanner.nextDouble();
	        scanner.nextLine();
	        
	        conta.depositar(valorDeposito);
	        
	    }

	    public static void realizarTransferencia(Banco banco, Scanner scanner) {
	        System.out.println("--- Realizar Transferência ---");
	        
	        System.out.print("Digite o número da conta de origem: ");
	        String numeroContaOrigem = scanner.nextLine();
	        
	        System.out.print("Digite o número da conta de destino: ");
	        String numeroContaDestino = scanner.nextLine();
	        
	        System.out.print("Digite o valor da transferência: ");
	        double valorTransferencia = scanner.nextDouble();

	        Conta contaOrigem = banco.buscarConta(numeroContaOrigem);
	        Conta contaDestino = banco.buscarConta(numeroContaDestino);

	        if (contaOrigem == null || contaDestino == null) {
	            System.out.println("Conta de origem ou conta de destino não encontrada.");
	            return;
	        }

	        contaOrigem.transferir(contaDestino, valorTransferencia);
	        
	    }

      // PIX
	    public static void realizarPix(Banco banco, Scanner scanner) {
	        System.out.println("--- Realizar PIX ---");
	        
	        System.out.print("Informe a chave PIX de destino: ");
	        String chavePixDestino = scanner.nextLine();
	        
	        System.out.print("Informe o número da sua conta: ");
	        String num = scanner.nextLine();

	        System.out.print("Informe o valor a ser enviado: ");
	        double valor = scanner.nextDouble();
	        scanner.nextLine();
	        
	        Conta c = banco.buscarConta(num);
	        
	        try {
	        	banco.fazerPix(chavePixDestino, valor, c);
	        	
	        	System.out.println("Pix realizado com sucesso!");
	        } catch (InsufficientMoneyException e) {
	        	System.out.println(e.getMessage());
	        }
	        
	    }
	    
	    public static void consultarSaldo(Banco banco, Scanner scanner) {
	        System.out.println("--- Realizar Consulta ---");
	        
	        System.out.print("Insira seu email ou login: ");
	        String data = scanner.nextLine();
	        System.out.print("Insira sua senha: ");
	        String senha = scanner.nextLine();
	        
	        double s = banco.saldoConsulta(data, senha);
	        
	        if(s != -1) {
	        	System.out.println("Saldo atual: R$" + s);
	        } else {
	        	System.out.println("Nenhuma conta encontrada com essas credenciais");
	        }
	    }

      // ALTERADOR DE DADOS DO CLIENTE
	    public static void alterarDadosCliente(Banco banco, Scanner scanner) {
	        System.out.println("--- Realizar Alteração ---");
	        
	        boolean checkmark = false;

	        while (!checkmark) {
	        	
	        	System.out.println("Insira seu email ou login para prosseguir: ");
	        	String data = scanner.nextLine();
	        	
	        	System.out.println("Insira sua senha: ");
	        	String senha = scanner.nextLine();
	        	
	        	System.out.println("Verificando...");
	        	
	        	if (banco.checkPermission(data, senha) == true) {
	        		
	    	        System.out.println(" ");
	    	        
		        	System.out.println("Insira o número da sua conta: ");
		        	String num = scanner.nextLine();
	    	        
	    	        System.out.println("Selecione o dado que deseja alterar: ");
	    	        System.out.println("1. Nome");
	    	        System.out.println("2. Senha");
	    	        System.out.println("3. Login");
	    	        System.out.println("4. Email");
	    	        int dado = scanner.nextInt();
	    	        
	    	        Conta c = banco.buscarConta(num); // Conta alvo
	    	        
	    	        switch (dado) {
	    	        
	    	        case 1:
	    	        	System.out.println("Insira um novo nome: ");
	    	        	String n = scanner.nextLine();
	    	            // Consumir a quebra de linha pendente
	    	            scanner.nextLine();
	    	        	
	    	        	c.setNome(n);
	    	        	break;
	    	        	
	    	        case 2:
	    	        	System.out.println("Insira a nova senha: ");
	    	        	String s = scanner.nextLine();
	    	            // Consumir a quebra de linha pendente
	    	            scanner.nextLine();
	    	        	
	    	        	c.setSenha(s);
	    	        	break;
	    	        	
	    	        case 3:
	    	        	System.out.println("Insira o novo login: ");
	    	        	String l = scanner.nextLine();
	    	            // Consumir a quebra de linha pendente
	    	            scanner.nextLine();
	    	        	
	    	        	c.setLogin(l);
	    	        	break;
	    	        	
	    	        case 4:
	    	        	System.out.println("Insira o novo email: ");
	    	        	String e = scanner.nextLine();
	    	            // Consumir a quebra de linha pendente
	    	            scanner.nextLine();
	    	        	
	    	        	c.setEmail(e);
	    	        	break;
	    	        }
	        		
	        		checkmark = true;
	        		
	        	} else {
	        		System.out.println("Credenciais incorretas");
	        	}	
	        }	        
	    }	


  	    // DELETAR CONTA
	    public static void delete(Banco banco, Scanner scanner) {
	    	System.out.println(" ");
	    	System.out.println("AVISO: Ao deletar sua conta, você perderá seus dados e não poderá mais acessar a conta.");
	    	System.out.println("Você tem certeza que deseja prosseguir?");
	    	System.out.println("1. Sim...");
	    	System.out.println("2. Não!");
	    	int resposta = scanner.nextInt();
	    	
	    	if (resposta == 2) {
	    		return;
	    	}
	    	
	    	scanner.nextLine(); // Consumir a quebra de linha pendente
	    	
	    	boolean checkmark = false;
	    	
	    	while(!checkmark) {
	    		System.out.println(" ");
	    		System.out.println("Insira seu email ou login para prosseguir: ");
	    		String data = scanner.nextLine();
	            
	    		System.out.println("Insira sua senha para prosseguir: ");
	    		String senha = scanner.nextLine();
	    		
	    		
	    		System.out.println("Verificando...");
	    	
	    		if(banco.checkPermission(data, senha) == true) {
	    			
	    			System.out.println("Por fim, digite o número da sua conta: ");
	    			String num = scanner.nextLine();
	    			
	    			banco.removerConta(num);
	    			
	    			System.out.println("Conta deletada com sucesso");
	    			
	    			checkmark = true;
	    		} else {
	    			System.out.println("Credenciais incorretas");
	    		}
	    		
	    	}
	    }

  
}