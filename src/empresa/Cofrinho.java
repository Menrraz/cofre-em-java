package empresa;
import java.util.Scanner;
import java.util.ArrayList;
public class Cofrinho {
	Scanner input = new Scanner(System.in);
	// OS ARRAYS SÃO DIFERENTES E A LIGAÇÃO ENTRE ELES SERÁ A PARTIR DOS INDEXES
	ArrayList<String> listaValor = new ArrayList<String>();
	ArrayList<String> listaMoeda = new ArrayList<String>();
	
	public void menu() {
		System.out.println("COFRINHO\n"
				+ "1 - Adicionar Moeda\n"
				+ "2 - Remover Moeda\n"
				+ "3 - Listar Moedas\n"
				+ "4 - Calcular total convertido para real\n"
				+ "5 - Encerrar");
		// PEGA A ESCOLHA DO USUÁRIO
		Scanner input = new Scanner(System.in);
		int escolha = input.nextInt();
		
		// 1 - ADICIONAR MOEDA
		if (escolha == 1) {
			String[] moedasNomes = {"Real", "Dolar", "Euro"};
			escolha = menuAdicionar();
			adicionar(moedasNomes[escolha-1]);
		}
		// 2 - REMOVER MOEDAS
		else if (escolha == 2) {
			int moeda = menuAdicionar();
			remover(moeda);
		}
		// 3 - LISTAR MOEDAS
		else if (escolha == 3) {
			listagemMoedas();
		}
		// 4 - CALCULAR CONVERSÃO
		else if (escolha == 4) {
			totalConvertido();
		}
		// 5 - ENCERRAR
		else if (escolha == 5) {
			System.out.println("-----Fim do Programa-----");
			System.exit(0);
		}
		else {
			System.out.println("Opção Inválida!");
			menu();
		}
	}
	public int menuAdicionar() {
		System.out.println("Escolha uma Moeda:\n"
				+ "1 - Real\n"
				+ "2 - Dolar\n"
				+ "3 - Euro\n");
		Scanner input = new Scanner(System.in);
		// RETORNA A ESCOLHA DO USUÁRIO
		return input.nextInt();
	}
	
	public void adicionar(String moedasNome) {
		listaMoeda.add(moedasNome); // ADICIONA O NOME DA MOEDA NO ARRAY
		System.out.print("Digite o valor: ");
		String valor = input.next();
		// CONVERTE AS ',' PARA '.' PARA CONVERTÊ-LOS PARA NÚMERO DEPOIS
		valor = valor.replace(',', '.');
		listaValor.add(valor); // ADICIONA O VALOR DA MOEDA NO ARRAY
		menu();
	}
	public void remover(int moeda) {
		System.out.print("Digite o Valor: ");
		Scanner input = new Scanner(System.in);
		String opcao = input.next();
		// POSSIBILITA A CONVERSÃO PARA NÚMERO POSTERIORMENTE
		opcao = opcao.replace(',', '.');
		if (moeda == 1) { // 1 == REAL
			removerItem(opcao, "Real");
		}
		if (moeda == 2) { // 2 == DOLAR
			removerItem(opcao, "Dolar");
		}
		if (moeda == 3) { // 3 == EURO
			removerItem(opcao, "Euro");
		}
		menu();
	}
	public void removerItem(String opcao, String moeda) {
		int index = 0;
		for (int i = 0; i < listaMoeda.size(); i++) {
			// CONVERTE OS VALORES PARA FAZER A COMPARAÇÃO
			double numberListaValor = Double.valueOf(listaValor.get(i));
			double numberOpcao = Double.valueOf(opcao);
			// VERIFICA SE O VALOR NA LISTA FOR IGUAL A OPÇÃO DO USUÁRIO E
			// SE A MOEDA ESCOLHIDA PELO USUÁRIO É A CORRETA
			if (numberListaValor == numberOpcao && listaMoeda.get(i) == moeda) {
				index = i; // INDENTIFICA O INDEX DELETADO
			}
		}
		// DELETA OS VALOR E O NOME DA MOEDA RELACIONADOS 
		listaValor.remove(index);
		listaMoeda.remove(index);
	}
	public void listagemMoedas() {
		for(int i = 0; i < listaMoeda.size(); i++) {
			System.out.println(listaMoeda.get(i) + " - " + listaValor.get(i));
		}
		menu();
	}
	public void totalConvertido() {
		double total = 0;
		for (int i = 0; i < listaValor.size(); i++) {
			
			if (listaMoeda.get(i) == "Dolar") {		
				// CONVERTE PARA NÚMERO PERMITINDO OS CALCULOS
				double d = Double.valueOf(listaValor.get(i));
				Dolar dolar = new Dolar(d);
				dolar.valor = d;
				total = total + dolar.converter();

			}
			if (listaMoeda.get(i) == "Euro" ) {
				double e = Double.valueOf(listaValor.get(i));
				Euro euro = new Euro(e);
				euro.valor = e;
				total = total + euro.converter();
			}
			if (listaMoeda.get(i) == "Real") {
				double r = Double.valueOf(listaValor.get(i));
				Real real = new Real(r);
				real.valor = r;
				total = total + real.converter();
			}
		}
		System.out.println("Conversão: " + total);
		menu();
	}
}
