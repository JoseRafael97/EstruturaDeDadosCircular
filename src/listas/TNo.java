package listas;

public class TNo <T>{
	
	public T dado;
	
	public TNo<T> prox;
	public TNo<T> ante;

	public TNo(T dado) {
		this.dado = dado;
	}

	@Override
	public String toString() {
		return "TNo [dado=" + dado  + "]";
	}
	
	
	
	
	

}
