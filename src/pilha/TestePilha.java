package pilha;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class TestePilha {
	
	private Pilha p;
	
	@Before
	void inicializaPilha() {
		p = new Pilha(10);
	}

	@Test
	void pilhaVazia() {
		assertTrue(p.estaVazia());
		assertEquals(0, p.tamanho());
	}
	
	@Test
	void empilhaUmElemento() {
		p.empilha("primeiro");
		assertFalse(p.estaVazia());
		assertEquals(1,p.tamanho());
		assertEquals("primeiro", p.topo());
	}

	@Test
	void empilhaEDesempilha() {
		p.empilha("primeiro");
		p.empilha("segundo");
		assertEquals(2,p.tamanho());
		assertEquals("segundo", p.topo());
		Object desempilhado = p.desempilha();
		assertEquals(1,p.tamanho());
		assertEquals("primeiro", p.topo());
		assertEquals("segundo", desempilhado);
		}
	
	@Test(expected=PilhaVaziaException.class)
	void removeDaPilhaVazia() {
		p.desempilha();
	}
	
	@Test
	void adicionaNaPilhaCheia() {
		for(int i=0; i<10; i++) {
			p.empilha("elemento" + i);
		}
		try {
			p.empilha("boom");
			fail();
		} catch (PilhaCheiaException e) {}
		
	}
}
