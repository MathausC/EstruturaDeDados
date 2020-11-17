package com.banco;
import Lista9.Queue;

public class ControleSenha {
    private Queue<Integer> filaEspera;
    private int senha;

    public ControleSenha() {
        filaEspera = new Queue<Integer>();
    }

    public void fornecerSenha() {
        if(filaEspera.size() < 10) {
            senha++;
            System.out.println("Sua senha é " + senha);
            filaEspera.enQueue(senha);
        } else {
            System.out.println("Fila cheia, retorne quando tiver vaga.");
        }
    }

    public void atenderCliente() {
        if(!filaEspera.isEmpty()) {
            System.out.println("Não a clientes a serem atendidos.");
        } else {
            System.out.println("Próxima senha: " + filaEspera.deQueue());
        }
    }
}
