package AP03.src.controller;
import AP03.src.model.Aluno;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map

public class controller {

    private LinkedHashMap<String, Aluno> usuarios = new LinkedHashMap<String, Aluno>();

    public void put(String matricula, String nome) {
        if(maxAlunos){
            System.out.println("Não é possível adicionar mais alunos");
        }else {
            aluno = new Aluno(matricula, nome);
		    usuarios.put(matricula, aluno); 
        }
	}

    public Aluno get(String matricula) {
        return usuarios.get(matricula);
    }

    public boolean containsAluno(String matricula) {
        return usuarios.containsKey(matricula);
    }

    public int size() {
        return usuarios.size();
    }

    public void removeAluno(String matricula) {
        usuarios.remove(matricula);
    }

    public float getMediaParcial(String matricula) {
        return usuarios.get(matricula).getMediaParcial();
    }

    public String setNota1(String matricula, float nota) {
        if( notaValida(nota) ) {
            usuarios.get(matricula).setNota1(nota);
            return "Nota 1 alterada com sucesso!";
        }else {
            return ("Nota inválida");
        }
    }

    public String setNota2(String matricula, float nota) {
        if( notaValida(nota) ) {
            usuarios.get(matricula).setNota1(nota);
            return "Nota 2 alterada com sucesso!";
        }else {
            return ("Nota inválida");
        }
    }

    public String setNota3(String matricula, float nota) {
        if( notaValida(nota) ) {
            aluno = usuarios.get(matricula);
            aluno.setNota3(nota);
            aluno.setMedia(aluno.getNota1() + aluno.getNota2() + aluno.getNota3());
            return "Nota 3 alterada com sucesso!";
        }else {
            return ("Nota inválida");
        }
    }

    public float getNota1(String matricula) {
        return usuarios.get(matricula).getNota1();
    }

    public float getNota2(String matricula) {
        return usuarios.get(matricula).getNota2();
    }

    public float getNota3(String matricula) {
        return usuarios.get(matricula).getNota3();
    }

    public float getMedia(String matricula) {
        return usuarios.get(matricula).getMedia();
    }

    private boolean notaValida(float nota) {
        return nota >= 0 && nota <= 10;
    }

    private boolean maxAlunos() {
        return usuarios.size() >= 5;
    }
}
