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
	
	@Test
	void testDefinirFuncaoAluno() {
		pc.cadastraPessoa("111.111.111-11", "Ada Lovelace", this.preparaHabilidades());
		pc.definirFuncaoAluno("111.111.111-11", "1211", 2);
		String representacao = pc.exibirPessoa("111.111.111-11");
		assertEquals("Ada Lovelace - 111.111.111-11\nAluno - 1211 - 2\n- matematica\n- programacao\n", representacao);
	}
	
	@Test
	void testDefinirFuncaoProfessor() {
		pc.cadastraPessoa("333.333.333-33", "Alan Turing", this.preparaHabilidades());
		pc.definirFuncaoProfessor("333.333.333-33", "1211", this.preparaDisciplinas());
	
		String representacao = pc.exibirPessoa("333.333.333-33");
		assertEquals("Alan Turing - 333.333.333-33\nProfessor - 1211 - programacao, criptografia\n- matematica\n- programacao\n", representacao);
	}
	
	@Test
	void pegarNivel() {
		pc.cadastraPessoa("333.333.333-33", "Alan Turing", this.preparaHabilidades());
		int nivel = pc.pegarNivel("333.333.333-33");
		assertEquals(nivel, 0);
	}
	
	@Test
	void pegarNivelAluno() {
		pc.cadastraPessoa("111.111.111-11", "Pedro", this.preparaHabilidades());
		pc.definirFuncaoAluno("111.111.111-11", "1211", 2);
		at.cadastrarAtividade("Revisar encapsulamento", "estudar para prova de OO", "111.111.111-11") ;
		tc.cadastraTarefa("RVS-0", "A", this.preparaHabilidades());
		tc.cadastraTarefa("RVS-0", "B", this.preparaHabilidades());
		tc.cadastraTarefa("RVS-0", "C", this.preparaHabilidades());
		
		tc.associarPessoaTarefa("RVS-0-0", "111.111.111-11");
		tc.associarPessoaTarefa("RVS-0-1", "111.111.111-11");
		tc.associarPessoaTarefa("RVS-0-2", "111.111.111-11");
		
		int nivel = pc.pegarNivel("111.111.111-11");
		assertEquals(nivel, 1);
	}
	
	@Test
	void pegarNivelAlunoComTarefaTerminada() {
		pc.cadastraPessoa("111.111.111-11", "Pedro", this.preparaHabilidades());
		pc.definirFuncaoAluno("111.111.111-11", "1211", 2);
		at.cadastrarAtividade("Revisar encapsulamento", "estudar para prova de OO", "111.111.111-11") ;
		tc.cadastraTarefa("RVS-0", "A", this.preparaHabilidades());
		tc.cadastraTarefa("RVS-0", "B", this.preparaHabilidades());
		tc.cadastraTarefa("RVS-0", "C", this.preparaHabilidades());
		
		tc.associarPessoaTarefa("RVS-0-0", "111.111.111-11");
		tc.associarPessoaTarefa("RVS-0-1", "111.111.111-11");
		tc.associarPessoaTarefa("RVS-0-2", "111.111.111-11");
		
		tc.concluirTarefa("RVS-0-0");
		int nivel = pc.pegarNivel("111.111.111-11");
		assertEquals(nivel, 3);
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