
public class Cliente implements Runnable {

	String Pizza;
	Lista listino;

	public Cliente (String Pizza, Lista listino){
		this.listino = listino;
		this.Pizza = Pizza;
	}
	
	@Override
	public void run() {
		//ordina la pizza
		listino.ordinaPizza(Pizza);	
		//controlla se la pizza è pronta
		listino.prelevaPizza(Pizza);
	
	}

}