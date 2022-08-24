package sapo.tests;

import static org.junit.Assert.assertArrayEquals;
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
	
	void cadastrarDuasPessoas() {
		pc.cadastraPessoa("222.222.222-22", "Alan Turing", this.preparaHabilidades());
		pc.cadastraPessoa("111.111.111-11", "Ada Lovelace", this.preparaHabilidades());
	}
	
	@Test
	void testCadastraPessoa() {			
		pc.cadastraPessoa("111.111.111-11", "Ada Lovelace", this.preparaHabilidades());
		String representacao = pc.exibirPessoa("111.111.111-11");
		assertEquals("Ada Lovelace - 111.111.111-11\n- matematica\n- programacao\n", representacao);
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
	void testAdicionarComentarios() {
		this.cadastrarDuasPessoas();
		
		pc.adicionarComentario("111.111.111-11", "uma grande referencia no campo da computação", "222.222.222-22");
		String listaDeComentarios = pc.listarComentarios("111.111.111-11");
		assertEquals("Ada Lovelace - 111.111.111-11Comentários:\numa grande referencia no campo da computação (Alan Turing)\n", listaDeComentarios);
	}
	
	@Test
	void listarComentarios() {
		this.cadastrarDuasPessoas();
		pc.cadastraPessoa("333.333.333-33", "Sabrina Barbosa", this.preparaHabilidades());
		
		pc.adicionarComentario("111.111.111-11", "uma grande referencia no campo da computação", "222.222.222-22");
		pc.adicionarComentario("111.111.111-11", "uma inspiração para as mulheres de TI", "333.333.333-33");
		
		String listaDeComentarios = pc.listarComentarios("111.111.111-11");
		assertEquals("Ada Lovelace - 111.111.111-11Comentários:\numa grande referencia no campo da computação (Alan Turing)\n"
				+ "uma inspiração para as mulheres de TI (Sabrina Barbosa)\n", listaDeComentarios);
	}
	
	@Test
	void TestListarPessoas() {
		this.cadastrarDuasPessoas();
		
		String[] listaDePessoas = new String[2]; 
		listaDePessoas[0] = ("Ada Lovelace - 111.111.111-11\n- matematica\n- programacao\n");
		listaDePessoas[1] = ("Alan Turing - 222.222.222-22\n- matematica\n- programacao\n");
		
		assertArrayEquals(pc.listarPessoas(), listaDePessoas);
	}
	
	@Test
	void testRemoverPessoa() {
		pc.cadastraPessoa("111.111.111-11", "Ada Lovelace", this.preparaHabilidades());
		String[] listaDePessoas = new String[1]; 
		listaDePessoas[0] = ("Ada Lovelace - 111.111.111-11\n- matematica\n- programacao\n");
		assertArrayEquals(pc.listarPessoas(), listaDePessoas);
		pc.removerPessoa("111.111.111-11");
		assertArrayEquals(pc.listarPessoas(), new String[0]);
	}

	
	
	
	
	
}
