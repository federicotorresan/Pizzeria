import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class Grafica {

	protected Shell shlPizzeria;
	protected Shell dialog;
	protected Shell pizza;
	List list;
	Label lblNewLabel;
	Label lblLabelpizza;
	private Text textPizza;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Grafica window = new Grafica();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlPizzeria.open();
		shlPizzeria.layout();
		while (!shlPizzeria.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPizzeria = new Shell();
		shlPizzeria.setSize(500, 400);
		shlPizzeria.setText("Pizzeria ");
		
		pizza = new Shell();
		pizza.setText("Pizza");
		pizza.setSize(200, 200);

		dialog = new Shell();
		dialog.setText("Cliente");
		dialog.setSize(200, 200);

		Lista lp = new Lista();
		Pizzaiolo p = new Pizzaiolo(lp);
		Cliente c1 = new Cliente(lp);

		lblNewLabel = new Label(pizza, SWT.NONE);
		lblNewLabel.setBounds(0, 50, 200, 200);

		lblLabelpizza = new Label(dialog, SWT.NONE);
		lblLabelpizza.setBounds(80, 43, 55, 15);

		
		Button btnApriPizzeria = new Button(shlPizzeria, SWT.NONE);
		btnApriPizzeria.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				

			}	
		}
		);
		btnApriPizzeria.setBounds(10, 76, 89, 25);
		btnApriPizzeria.setText("Apri pizzeria");
		
		Button btnChiudiPizzeria = new Button(shlPizzeria, SWT.NONE);
		btnChiudiPizzeria.setBounds(194, 76, 89, 25);
		btnChiudiPizzeria.setText("Chiudi pizzeria");
		
		Button btnArriva = new Button(shlPizzeria, SWT.NONE);
		btnArriva.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				
			}
		});
		btnArriva.setBounds(351, 76, 109, 25);
		btnArriva.setText("Arriva un cliente!");
		
		List pizze_coda = new List(shlPizzeria, SWT.BORDER);
		pizze_coda.setBounds(10, 130, 124, 191);
		
		List pizze_cottura = new List(shlPizzeria, SWT.BORDER);
		pizze_cottura.setBounds(177, 130, 124, 191);
		
		List pizze_pronte = new List(shlPizzeria, SWT.BORDER);
		pizze_pronte.setBounds(351, 130, 109, 191);
		
		Label lblPizz = new Label(shlPizzeria, SWT.NONE);
		lblPizz.setBounds(24, 107, 75, 15);
		lblPizz.setText("Pizze in coda");
		
		Label lblPizzeInCottura = new Label(shlPizzeria, SWT.NONE);
		lblPizzeInCottura.setBounds(194, 107, 89, 15);
		lblPizzeInCottura.setText("Pizze in cottura");
		
		Label lblPizzePronte = new Label(shlPizzeria, SWT.NONE);
		lblPizzePronte.setBounds(370, 107, 64, 15);
		lblPizzePronte.setText("Pizze pronte");
		
		Label lblPizza = new Label(shlPizzeria, SWT.NONE);
		lblPizza.setBounds(25, 31, 89, 15);
		lblPizza.setText("Inserisci la pizza:");
		
		textPizza = new Text(shlPizzeria, SWT.BORDER);
		textPizza.setBounds(120, 25, 76, 21);

	}
}
