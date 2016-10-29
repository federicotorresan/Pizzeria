import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Grafica {

	protected Shell shell;

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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(500, 400);
		shell.setText("SWT Application");
		
		Button btnApriPizzeria = new Button(shell, SWT.NONE);
		btnApriPizzeria.setBounds(10, 55, 89, 25);
		btnApriPizzeria.setText("Apri pizzeria");
		
		Button btnChiudiPizzeria = new Button(shell, SWT.NONE);
		btnChiudiPizzeria.setBounds(142, 55, 89, 25);
		btnChiudiPizzeria.setText("Chiudi pizzeria");
		
		Button btnArriva = new Button(shell, SWT.NONE);
		btnArriva.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		btnArriva.setBounds(315, 55, 109, 25);
		btnArriva.setText("Arriva un cliente!");
		
		List pizze_coda = new List(shell, SWT.BORDER);
		pizze_coda.setBounds(10, 130, 124, 191);
		
		List pizze_cottura = new List(shell, SWT.BORDER);
		pizze_cottura.setBounds(177, 130, 124, 191);
		
		List pizze_pronte = new List(shell, SWT.BORDER);
		pizze_pronte.setBounds(351, 130, 109, 191);

	}
}
