
public class Cliente extends Thread {
	
	Lista listino;
	int a;
	
	public Cliente(Lista listino){
		this.listino=listino;
	}

	public synchronized void run(){
		a=(int)(Math.random()*5);
		System.out.println("pizza: "+listino.pizze[a]);
		listino.pizzeInCoda.add(listino.pizze[a]);
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
