package AP03.src.controller;

import java.util.HashMap;
import java.util.Map;
import AP03.src.model.Aluno;

public class Controller {

    Map alunos = new HashMap<String, Aluno>();

    public void cadastraAluno(String nome, String matricula) {
        if (contemAluno(matricula)) {
            throw new IllegalArgumentException("MATRÍCULA JÁ CADASTRADA!");
        } else {
            alunos.put(matricula, new Aluno(nome, matricula));
            System.out.println("Cadastro realizado!" + System.lineSeparator());
        }
    }

    private boolean contemAluno(String matricula) {
        if (alunos.containsKey(matricula)) {
            return true;
        } else {
            return false;
        }
    }

    public String consultaAluno(String matricula) {
        String string = "";
        if (contemAluno(matricula)) {
            string += alunos.get(matricula).toString();
        } else {
            string += "Aluno não cadastrado.";
        }
        return string;
    }

  
        
}
