import com.escola.CadastroAlunos;

import java.util.Scanner;

public class SalaDeAula {
    public static void main(String[] args) {
        CadastroAlunos cadastroAlunos = new CadastroAlunos();
        Scanner in = new Scanner(System.in);
        System.out.println("Vamos começar nosso cadastro.");
        char resp;
        do{
            menu();
            resp = in.next().charAt(0); in.nextLine();
            switch (resp) {
                case '1': cadastroAlunos.cadastrarAluno(); break;
                case '2': cadastroAlunos.exibirAlunos(); break;
                case '3': cadastroAlunos.alterarMediaFinal(); break;
                case '4': cadastroAlunos.alterarFaltas(); break;
                case '5': cadastroAlunos.exibeAluno(); break;
                case '6': cadastroAlunos.removerAluno(); break;
                case '0': System.out.println("Até mais!"); break;
                default: System.out.println("Opção inválida."); break;
            }
        }while (resp != '0');
    }
    private static void menu() {
        String menu =   "Opções:\n" +
                        "1 - Cadastrar um aluno;\n" +
                        "2 - Listar  alunos;\n" +
                        "3 - Alterar média final de um aluno\n" +
                        "4 - Alterar faltas de um aluno\n" +
                        "5 - Exibir um aluno\n" +
                        "6 - Remover aluno\n" +
                        "0 - Encerrar\n" +
                        "Opção: ";
        System.out.print(menu);
    }
}

