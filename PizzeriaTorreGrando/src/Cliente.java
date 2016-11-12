
public class Cliente extends Thread {
	
	Lista listino;
	int a;
	String pizza;
	
	public Cliente(Lista listino){
		this.listino=listino;
	}
	
	public void setPizza(String pizza,int a){
		this.pizza=pizza;
		this.a=a;
	}

	public synchronized void run(){
		System.out.println("pizza: "+listino.pizze[a]);
		listino.pizzeInCoda.add(pizza);
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
