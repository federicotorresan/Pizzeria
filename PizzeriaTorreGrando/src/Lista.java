import java.util.ArrayList;

public class Lista {
	
	ArrayList<String> pizze = new ArrayList<String>();
	
	public void listino(){
		pizze.add("Margherita");
		pizze.add("Diavola");
		pizze.add("Prosciutto e funghi");
		pizze.add("Quattro stagioni");
		pizze.add("Quattro formaggi");
		String pizza=pizze.remove(0);
	}
	
	public synchronized int pizzaInLista(String pizza){
		this.pizza=pizza;
		notifyAll();
		return pizza;
	}
}



