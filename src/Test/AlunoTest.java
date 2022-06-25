import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import controller.controller;
import model.Aluno;

Class AlunosTest{

    @BeforeAll
    public static void setUp() {
        Alunos alunos = new controller();
    }

    @Test
    void test cadastraAluno() {
        alunos.put("1", "aluno1");
        assertTrue(alunos.containsKey("1"));
    }

    @Test
    void test sizeAlunos() {
        alunos.put("1", "aluno1");
        alunos.put("2", "aluno2");
        assertEquals(2, alunos.size());
    }

    @Test
    void test alunoAprovado() {
        alunos.put("1", "aluno1");
        alunos.setNota1("1", 7);
        alunos.setNota2("1", 8);
        alunos.setNota3("1", 9);
        assertTrue(alunos.getMedia("1") >= 7);
    }

    @Test
    void test alunoReprovado() {
        alunos.put("1", "aluno1");
        alunos.setNota1("1", 4);
        alunos.setNota2("1", 5);
        alunos.setNota3("1", 6);
        assertFalse(alunos.getMedia("1") >= 7);
    }

    @Test
    void test maxAlunos() {
        alunos.put("1", "aluno1");
        alunos.put("2", "aluno2");
        alunos.put("3", "aluno3");
        alunos.put("4", "aluno4");
        alunos.put("5", "aluno5");
        assertEquals(alunos.sizeAlunos(), 5);
    }

    @Test
    void test overAlunos() {
        alunos.put("1", "aluno1");
        alunos.put("2", "aluno2");
        alunos.put("3", "aluno3");
        alunos.put("4", "aluno4");
        alunos.put("5", "aluno5");
        assertEquals(alunos.put("6", "aluno6"), "Não é possível adicionar mais alunos");
    }
}