package controller;

import java.util.LinkedHashMap;

import model.Aluno;

public class Controller {

	private LinkedHashMap<String, Aluno> usuarios = new LinkedHashMap<String, Aluno>();

	public String put(String matricula, String nome) {
		if (maxAlunos()) {
			return "Não é possível adicionar mais alunos";
		} else {
			Aluno aluno = new Aluno(matricula, nome);
			usuarios.put(matricula, aluno);
			return "Aluno cadastrado";
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

	public double getMediaParcial(String matricula) {
		return usuarios.get(matricula).getMediaParcial();
	}

	public String setNota1(String matricula, double d) {
		if (notaValida(d)) {
			usuarios.get(matricula).setNota1(d);
			return "Nota 1 alterada com sucesso!";
		} else {
			return ("Nota invalida");
		}
	}

	public String setNota2(String matricula, double nota) {
		if (notaValida(nota)) {
			usuarios.get(matricula).setNota2(nota);
			return "Nota 2 alterada com sucesso!";
		} else {
			return ("Nota invalida");
		}
	}

	public String setNota3(String matricula, double nota) {
		if (notaValida(nota)) {
			Aluno aluno = usuarios.get(matricula);
			aluno.setNota3(nota);
			aluno.setMedia((aluno.getNota1() + aluno.getNota2() + aluno.getNota3()) / 3);
			return "Nota 3 alterada com sucesso!";
		} else {
			return ("Nota invalida");
		}
	}

	public double getNota1(String matricula) {
		return usuarios.get(matricula).getNota1();
	}

	public double getNota2(String matricula) {
		return usuarios.get(matricula).getNota2();
	}

	public double getNota3(String matricula) {
		return usuarios.get(matricula).getNota3();
	}

	public double getMedia(String matricula) {
		return usuarios.get(matricula).getMedia();
	}

	private boolean notaValida(double d) {
		return d >= 0 && d <= 10;
	}

	private boolean maxAlunos() {
		return usuarios.size() >= 5;
	}
}
