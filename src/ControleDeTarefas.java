import com.empresa.CadastroTarefas;
import java.util.Scanner;

public class ControleDeTarefas {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CadastroTarefas ct = new CadastroTarefas();
		char resp;
		System.out.println("Vamos iniciar nosso controle de tarefas.");
		do {
			exibeMenu();
			resp = in.next().charAt(0);
			switch(resp) {
				case '1': ct.cadastrarTarefa(); break;
				case '2': ct.exibirQuantidadePrioritaria(); break;
				case '3': ct.executarTarefa(); break;
				case '4': ct.cancelarExecucao(); break;
				case '5': ct.exibirPorPrioridade(); break;
				case '6': ct.exibirTarefas(); break;
				case '7': ct.alterarPrioridade(); break;
				case '0': System.out.println("Obrigado e até logo.");
				default: System.out.println("Opção inválida.");
			}
		} while(resp != '0');
	}
	
	private static void exibeMenu() {
		String menu = "Informe uma das opções abaixo: \n"
				+ "1 - Adicionar tarefa;\n"
				+ "2 - Exibir tarefas com maior prioridade;\n"
				+ "3 - Executar tarefa atual;\n"
				+ "4 - Cancelar tarefa;\n"
				+ "5 - Exibir Tarefas com prioridade X;\n"
				+ "6 - Exibir tarefas;\n"
				+ "7 - Alterar prioridade da tarefa;\n"
				+ "0 - Encerrar.\n"
				+ "Opção: ";
		System.out.print(menu);		
	}

}
