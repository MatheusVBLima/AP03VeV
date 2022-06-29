package model;

public class Aluno {

    private String nome;
    private String matricula;
    private double nota1;
    private double nota2;
    private double nota3;
    private double media;

    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota1 = 0;
        this.nota2 = 0;
        this.nota3 = 0;
        this.media = 0;

    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double d) {
        this.nota1 = d;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }
    
    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getMediaParcial() {
        return (nota1 + nota2 + nota3) / 3;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double f) {
        this.media = f;
    }

    @Override
    public String toString() {
        if (this.getMediaParcial() >= 7) {
            return "Aluno: " + this.nome + " - Matricula: " + this.matricula + " - Nota 1: " + this.nota1
                    + " - Nota 2: " + this.nota2 + " - Nota 3: " + this.nota3 + " - Media Parcial: " + this.getMediaParcial()
                    + " - Aluno Aprovado!";

        } else {
            return "Aluno: " + this.nome + " - Matricula: " + this.matricula + " - Nota 1: " + this.nota1
                    + " - Nota 2: " + this.nota2 + " - Nota 3: " + this.nota3 + " - Media Parcial: " + this.getMediaParcial()
                    + " - Aluno Reprovado!";
        }
    }

}
