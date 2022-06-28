package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.Controller;

class AlunoTest {
	
	public Controller controller;
	
	@BeforeEach
    public void setUp() {
        controller = new Controller();
    }

    @Test
    public void cadastraAluno() {
        controller.put("1", "aluno1");
        assertTrue(controller.containsAluno("1"));
    }

    @Test
    public void sizeAlunos() {
        controller.put("1", "aluno1");
        controller.put("2", "aluno2");
        assertEquals(2, controller.size());
    }

    @Test
    public void alunoAprovado() {
        controller.put("1", "aluno1");
        controller.setNota1("1", 7);
        controller.setNota2("1", 8);
        controller.setNota3("1", 9);
        assertTrue(controller.getMedia("1") >= 7);
    }

    @Test
    public void alunoReprovado() {
        controller.put("1", "aluno1");
        controller.setNota1("1", 4);
        controller.setNota2("1", 5);
        controller.setNota3("1", 6);
        assertFalse(controller.getMedia("1") >= 7);
    }

    @Test
    public void maxAlunos() {
        controller.put("1", "aluno1");
        controller.put("2", "aluno2");
        controller.put("3", "aluno3");
        controller.put("4", "aluno4");
        controller.put("5", "aluno5");
        assertEquals(controller.size(), 5);
    }

    @Test
    public void overAlunos() {
        controller.put("1", "aluno1");
        controller.put("2", "aluno2");
        controller.put("3", "aluno3");
        controller.put("4", "aluno4");
        controller.put("5", "aluno5");
        assertEquals(controller.put("6", "aluno6"), "Não é possível adicionar mais alunos");
    }

}
