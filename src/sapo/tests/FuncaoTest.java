package sapo.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FuncaoTest extends BaseTest{
	
	@Test
	void testCadastraAluno(){
		pc.cadastraAluno("111.111.111-11", "Ada Lovelace", this.preparaHabilidades(), "1211", 2);
		String representacao = pc.exibirPessoa("111.111.111-11");
		assertEquals("Ada Lovelace - 111.111.111-11\nAluno - 1211 - 2\n- matematica\n- programacao\n", representacao);
	}
	
	@Test
	void testCadastraProfessor(){
		pc.cadastraProfessor("333.333.333-33", "Alan Turing", this.preparaHabilidades(), "1211", this.preparaDisciplinas());
		String representacao = pc.exibirPessoa("333.333.333-33");
		assertEquals("Alan Turing - 333.333.333-33\nProfessor - 1211 - programacao, criptografia\n- matematica\n- programacao\n", representacao);
	
}
	
	
	String[] preparaHabilidades() {
		String[] habilidades = new String[2];
		habilidades[0] = "matematica";
		habilidades[1] = "programacao";
		
		return habilidades;
	}
	
	String[] preparaDisciplinas() {
		String[] disciplinas = new String[2];
		disciplinas[0] = "programacao";
		disciplinas[1] = "criptografia";
		
		return disciplinas;
	}
}