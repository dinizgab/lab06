package sapo.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PessoaTest extends BaseTest{
	
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
	
	

	@Test
	void testCadastraPessoa() {			
		pc.cadastraPessoa("111.111.111-11", "Ada Lovelace", this.preparaHabilidades());
		String representacao = pc.exibirPessoa("111.111.111-11");
		assertEquals("Ada Lovelace - 111.111.111-11\n- matematica\n- programacao\n", representacao);
	}
	
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
	void testAlterarNome() {
		pc.cadastraPessoa("111.111.111-11", "Ada Lovelace", this.preparaHabilidades());
		String representacao = pc.exibirPessoa("111.111.111-11");
		assertEquals("Ada Lovelace - 111.111.111-11\n- matematica\n- programacao\n", representacao);
		pc.alterarNome("111.111.111-11", "Simone de Beauvoir");
		representacao = pc.exibirPessoa("111.111.111-11");
		assertEquals("Simone de Beauvoir - 111.111.111-11\n- matematica\n- programacao\n", representacao);
	}
	
	@Test
	void testHalterarHabilidades() {
		pc.cadastraPessoa("111.111.111-11", "Ada Lovelace", this.preparaHabilidades());
		String representacao = pc.exibirPessoa("111.111.111-11");
		assertEquals("Ada Lovelace - 111.111.111-11\n- matematica\n- programacao\n", representacao);
		
		String[] NovasHabilidades = new String[1];
		NovasHabilidades[0] = "piano";
		pc.alterarHabilidadesPessoa("111.111.111-11", NovasHabilidades);
		representacao = pc.exibirPessoa("111.111.111-11");
		assertEquals("Ada Lovelace - 111.111.111-11\n- piano\n", representacao);
	}
	
	@Test
	void testAdicionarEListarComentarios() {
		pc.cadastraPessoa("111.111.111-11", "Ada Lovelace", this.preparaHabilidades());
		pc.cadastraPessoa("222.222.222-22", "Alan Turing", this.preparaHabilidades());
		pc.adicionarComentario("111.111.111-11", "uma grande referencia no campo de computação", "222.222.222-22");
		String listaDeComentarios = pc.listarComentarios("222.222.222-22");
		assertEquals("Alan Turing - 222.222.222-22Comentários:\n", listaDeComentarios);
	}
	
	@Test
	void testRemoverPessoa() {
		// TO DO
	}

	
	
	
	
	
}
