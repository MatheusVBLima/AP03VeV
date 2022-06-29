package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.Controller;

class AlunoTest {

	public Controller controller;
	
	//Resetando o controller antes de cada teste.
	@BeforeEach
	public void setUp() {
		controller = new Controller();
	}

	//Teste para verificar se o aluno foi cadastrado com sucesso.
	@Test
	public void cadastraAluno() {
		controller.put("1", "aluno1");
		assertTrue(controller.containsAluno("1"));
	}

	//Teste para verificar se múltiplos alunos foram cadastrados.
	@Test
	public void sizeAlunos() {
		controller.put("1", "aluno1");
		controller.put("2", "aluno2");
		assertEquals(2, controller.size());
	}


	//Teste para verificar se um aluno é aprovado corretamente.
	@Test
	public void alunoAprovado() {
		controller.put("1", "aluno1");
		controller.setNota1("1", 7);
		controller.setNota2("1", 8);
		controller.setNota3("1", 9);
		assertTrue(controller.getMedia("1") >= 7);
	}

	//Teste para verificar se um aluno é aprovado com valor limite.
    @Test
    public void alunoAprovadoLimite() {
        controller.put("1", "aluno1");
        controller.setNota1("1", 7.1);
        controller.setNota2("1", 7.1);
        controller.setNota3("1", 7.1);
        assertTrue(controller.getMedia("1") >= 7);
    }

	//Teste para verificar se um aluno é reprovado corretamente.
    @Test
    public void alunoReprovado() {
        controller.put("1", "aluno1");
        controller.setNota1("1", 4);
        controller.setNota2("1", 5);
        controller.setNota3("1", 6);
        assertFalse(controller.getMedia("1") >= 7);
    }

	//Teste para verificar se um aluno é reprovado com valor limite.
    @Test
    public void alunoReprovadoLimite() {
        controller.put("1", "aluno1");
        controller.setNota1("1", 6.9);
        controller.setNota2("1", 6.9);
        controller.setNota3("1", 6.9);
        assertFalse(controller.getMedia("1") >= 7);
    }

	//Teste para verificar o limite de alunos cadastrados.
    @Test
    public void maxAlunos() {
        controller.put("1", "aluno1");
        controller.put("2", "aluno2");
        controller.put("3", "aluno3");
        controller.put("4", "aluno4");
        controller.put("5", "aluno5");
        assertEquals(controller.size(), 5);
    }

	//Teste para verificar se o limite de alunos cadastrados esta sendo respeitado.
	@Test
	public void overAlunos() {
		controller.put("1", "aluno1");
		controller.put("2", "aluno2");
		controller.put("3", "aluno3");
		controller.put("4", "aluno4");
		controller.put("5", "aluno5");
		assertEquals(controller.put("6", "aluno6"), "Nao e possivel adicionar mais alunos");
	}

}
