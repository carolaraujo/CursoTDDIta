package pilha;


public class Pilha {

	private Object [] elementos = new Object[10];
	private int quantidade = 0;

	public boolean estaVazia() {
		return quantidade == 0;
	}

	public Integer tamanho() {
		return quantidade;
	}

	public void empilha(Object elemento) {
		this.elementos[quantidade] = elemento;
		quantidade ++;
		
	}

	public Object topo() {
		return elementos[quantidade - 1];
	}

	public Object desempilha() {
		Object topo = topo();
		quantidade --;
		return topo;
	}

}