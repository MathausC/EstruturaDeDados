import java.util.Scanner;
import com.adivocacia.CadastroPessoas;

public class SistemaPrédio {

	public static void main(String[] args) {
		CadastroPessoas cd = new CadastroPessoas();
		Scanner in = new Scanner(System.in);
		char resp;
		System.out.println("Bem vindo ao prédio do escritório de consultoria Advogados S.A.");
		do {
			exibeMenu();
			resp = in.next().charAt(0); in.nextLine();
			switch(resp) {
				case '1': cd.cadastrarPessoa(); break;
				case '2': cd.cancelarCadastroImediato(); break;
				case '3': cd.exibirPessoas(); break;
				case '4': cd.verificarPresença(); break;
				case '5': cd.pessoasPresentes(); break;
				case '6': cd.removerPessoa(); break;
				case '0': System.out.println("Obrigado e até mais!"); break;
				default: System.out.println("Opção inválida."); break;
			}
		} while(resp != '0');
	}
	
	private static void exibeMenu() {
		String menu = "Informe uma das opção abaixo:\n"
				+ "1 - Cadastrar entrada da pessoa;\n"
				+ "2 - Cancelar cadastro imediato;\n"
				+ "3 - Exibir dados das pessoas presentes;\n"
				+ "4 - Verificar presença específica;\n"
				+ "5 - Exibir quantidade de pessoas presentes;\n"
				+ "6 - Remover pessoa que não está mais presente;\n"
				+ "0 - Encerrar.\n"
				+ "Opção: ";
		System.out.print(menu);
	}
}
