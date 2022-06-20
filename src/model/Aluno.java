package AP03.src.model;

public class Aluno {

    private String nome;
    private String matricula;
    private int nota1;
    private int nota2;
    private int nota3;
    private int mediaParcial;
    private int notaProvaFinal;
    private int mediaFinal;

    public Aluno(String nome, String matricula, int nota1, int nota2, int nota3, int mediaParcial, int notaProvaFinal) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.mediaParcial = 0;
        this.notaProvaFinal = 0;
        this.mediaFinal = 0;

    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getNota1() {
        return nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public int getNota3() {
        return nota3;
    }

    public int getMediaParcial() {
        return mediaParcial;
    }

    public int getNotaProvaFinal() {
        return notaProvaFinal;
    }

    public int getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaParcial(int mediaParcial) {
        this.mediaParcial = mediaParcial;
    }

    public void setMediaFinal(int mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    @Override
    public String toString() {
        if (this.mediaParcial >= 7) {
            return "Aluno: " + this.nome + " - Matricula: " + this.matricula + " - Nota 1: " + this.nota1
                    + " - Nota 2: " + this.nota2 + " - Nota 3: " + this.nota3 + " - Media Parcial: " + this.mediaParcial
                    + " - Media Final: " + this.mediaFinal;

        } else {
            return "Aluno: " + this.nome + " - Matricula: " + this.matricula + " - Nota 1: " + this.nota1
                    + " - Nota 2: " + this.nota2 + " - Nota 3: " + this.nota3 + " - Media Parcial: " + this.mediaParcial
                    + " - Nota da Prova Final " + this.notaProvaFinal + " - Media Final: " + this.mediaFinal;
        }

    }

}
