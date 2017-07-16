package view;

import javax.swing.JFrame;

public abstract class Tela extends JFrame {
	
	private static final long serialVersionUID = -8550006838694591760L;

	public abstract void colocarPainel(PainelGenerico pg);
	
}
