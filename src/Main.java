import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);

		while (true) {
			System.out.println("==========================================================");
			System.out.println("Bem vindo ao Dio Bank!");
			System.out.println("Deseja criar uma nova conta ou acessar uma conta existente?");
			System.out.println("1 - Criar nova conta");
			System.out.println("2 - Acessar conta existente");
			System.out.println("==========================================================");

			int resposta = teclado.nextInt();
			teclado.nextLine();
			Cliente cliente = new Cliente();

			if (resposta == 1) {
				System.out.println("Digite o nome do cliente:");
				String nome = teclado.nextLine();
				cliente.setNome(nome);

				System.out.println("==========================================================");
				System.out.println("Deseja criar uma conta corrente ou poupança?");
				System.out.println("1 - Corrente");
				System.out.println("2 - Poupança");

				int tipo = teclado.nextInt();

				if (tipo == 1) {
					ContaCorrente conta = new ContaCorrente(cliente);
					System.out.println("==========================================================");
					System.out.println("Deseja depositar um valor inicial na conta?");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");

					int respostaDeposito = teclado.nextInt();

					if (respostaDeposito == 1) {
						System.out.println("==========================================================");
						System.out.println("Digite o valor inicial:");
						double valor = teclado.nextDouble();
						conta.depositar(valor);

						System.out.println("==========================================================");
						System.out.println("Conta criada com sucesso!");
						conta.imprimirExtrato();
					} else {
						System.out.println("==========================================================");
						System.out.println("Conta criada com sucesso!");
						conta.imprimirExtrato();
					}
				} else if (tipo == 2) {
					ContaPoupanca conta = new ContaPoupanca(cliente);
					System.out.println("==========================================================");
					System.out.println("Deseja depositar um valor inicial na conta?");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");

					int respostaDeposito = teclado.nextInt();

					if (respostaDeposito == 1) {
						System.out.println("==========================================================");
						System.out.println("Digite o valor inicial:");
						double valor = teclado.nextDouble();
						conta.depositar(valor);

						System.out.println("==========================================================");
						System.out.println("Conta criada com sucesso!");
						conta.imprimirExtrato();
					} else {
						System.out.println("==========================================================");
						System.out.println("Conta criada com sucesso!");
						conta.imprimirExtrato();
					}
				} else {
					System.out.println("==========================================================");
					System.out.println("Opção inválida!");
				}
				
			} else if (resposta == 2) {
				System.out.println("==========================================================");
				System.out.println("Digite o nome do titular:");
				String nome = teclado.nextLine();
				cliente.setNome(nome);
				ContaCorrente cc = new ContaCorrente(cliente);
				ContaPoupanca cp = new ContaPoupanca(cliente);

				System.out.println("==========================================================");
				System.out.println("Digite o tipo da conta que deseja acessar:");
				System.out.println("1 - Corrente");
				System.out.println("2 - Poupança");
				int tipo = teclado.nextInt();
				
				if (tipo == 1) {
					System.out.println("==========================================================");
					System.out.println("Qual o tipo de operação que deseja realizar?");
					System.out.println("1 - Saque");
					System.out.println("2 - Depósito");
					System.out.println("3 - Transferência");
					System.out.println("4 - Imprimir extrato");
					System.out.println("5 - Sair");

					int operacao = teclado.nextInt();

					if (operacao == 1) {
						System.out.println("==========================================================");
						System.out.println("Digite o valor do saque:");
						double valor = teclado.nextDouble();
						cc.sacar(valor);
						cc.imprimirExtrato();
					} else if (operacao == 2) {
						System.out.println("==========================================================");
						System.out.println("Digite o valor do depósito:");
						double valor = teclado.nextDouble();
						cc.depositar(valor);
						cc.imprimirExtrato();
					} else if (operacao == 3) {
						System.out.println("==========================================================");
						System.out.println("Transferência da conta corrente para a conta poupança");
						System.out.println("Digite o valor da transferência:");
						double valor = teclado.nextDouble();
						cc.transferir(valor, cp);
						cc.imprimirExtrato();
					} else if (operacao == 4) {
						cc.imprimirExtrato();
					} else if (operacao == 5) {
						System.out.println("==========================================================");
						System.out.println("Saindo...");
					} else {
						System.out.println("==========================================================");
						System.out.println("Opção inválida!");
					}
				} else if (tipo == 2) {
					System.out.println("==========================================================");
					System.out.println("Qual o tipo de operação que deseja realizar?");
					System.out.println("1 - Saque");
					System.out.println("2 - Depósito");
					System.out.println("3 - Transferência");
					System.out.println("4 - Imprimir extrato");
					System.out.println("5 - Sair");

					int operacao = teclado.nextInt();

					if (operacao == 1) {
						System.out.println("==========================================================");
						System.out.println("Digite o valor do saque:");
						double valor = teclado.nextDouble();
						cp.sacar(valor);
						cp.imprimirExtrato();
					} else if (operacao == 2) {
						System.out.println("==========================================================");
						System.out.println("Digite o valor do depósito:");
						double valor = teclado.nextDouble();
						cp.depositar(valor);
						cp.imprimirExtrato();
					} else if (operacao == 3) {
						System.out.println("==========================================================");
						System.out.println("Transferência da conta poupança para a conta corrente");
						System.out.println("Digite o valor da transferência:");
						double valor = teclado.nextDouble();
						cp.transferir(valor, cc);
						cp.imprimirExtrato();
					} else if (operacao == 4) {
						cp.imprimirExtrato();
					} else if (operacao == 5) {
						System.out.println("==========================================================");
						System.out.println("Saindo...");
					} else {
						System.out.println("==========================================================");
						System.out.println("Opção inválida!");
					}
				} else {
					System.out.println("==========================================================");
					System.out.println("Opção inválida!");
				}
			}

			System.out.println("==========================================================");
			System.out.println("Deseja realizar outra operação?");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			int continuar = teclado.nextInt();
			if (continuar == 1) {
				System.out.println("");
			} else {
				System.out.println("Até logo!\n");
				break;
			}
		}
		teclado.close();

		// Cliente venilton = new Cliente();
		// venilton.setNome("Venilton");

		// Conta cc = new ContaCorrente(venilton);
		// Conta poupanca = new ContaPoupanca(venilton);

		// cc.depositar(100);
		// cc.transferir(100, poupanca);

		// cc.imprimirExtrato();
		// poupanca.imprimirExtrato();
	}
}
