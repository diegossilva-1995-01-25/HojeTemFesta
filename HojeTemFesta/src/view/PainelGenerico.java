package view;

import javax.swing.JPanel;

import model.Membro;

public abstract class PainelGenerico extends JPanel {

	private static final long serialVersionUID = 8318324971848069808L;

	public abstract Membro painelParaMembro(Membro m, String origem);
	
	public abstract void membroParaPainel(Membro m);
	
	public abstract void limparTela();
	
}
