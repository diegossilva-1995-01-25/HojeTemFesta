package view;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import control.CtrBusca;
import model.Membro;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class PainelConsulta extends PainelGenerico implements ActionListener {

	private static final long serialVersionUID = -3455220062160717551L;
	private JTextField txtCriterio;
	private JScrollPane rolagem;
	private JTable tabelaPesquisa;
	private JRadioButton rdbtnPorCodigo;
	private JRadioButton rdbtnPorNome;
	private JRadioButton rdbtnPorData;
	private CtrBusca controleBusca;

	/**
	 * Create the panel.
	 */
	public PainelConsulta() {
		controleBusca = new CtrBusca();
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelPesquisa = new JPanel();
		add(panelPesquisa, BorderLayout.NORTH);
		panelPesquisa.setLayout(new GridLayout(0, 3, 5, 5));
		
		JLabel lblCriterio = new JLabel("Crit\u00E9rio");
		lblCriterio.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 32));
		panelPesquisa.add(lblCriterio);
		
		txtCriterio = new JTextField();
		txtCriterio.setFont(new Font("Arial", Font.PLAIN, 12));
		panelPesquisa.add(txtCriterio);
		txtCriterio.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 32));
		btnPesquisar.addActionListener(this);
		panelPesquisa.add(btnPesquisar);
		
		rdbtnPorCodigo = new JRadioButton("Por Id");
		rdbtnPorCodigo.setSelected(true);
		rdbtnPorCodigo.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 32));
		panelPesquisa.add(rdbtnPorCodigo);
		
		rdbtnPorNome = new JRadioButton("Por Nome");
		rdbtnPorNome.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 32));
		panelPesquisa.add(rdbtnPorNome);
		
		rdbtnPorData = new JRadioButton("Por Data");
		rdbtnPorData.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 32));
		panelPesquisa.add(rdbtnPorData);
		
		rolagem = new JScrollPane();
		tabelaPesquisa = new JTable(controleBusca);
		tabelaPesquisa.setFont(new Font("Arial", Font.PLAIN, 12));
		rolagem.getViewport().add(tabelaPesquisa);
		add(rolagem, BorderLayout.CENTER);
		
		// Agrupa os botões de rádio
		ButtonGroup grupoBotoes = new ButtonGroup();
		grupoBotoes.add(rdbtnPorCodigo);
		grupoBotoes.add(rdbtnPorNome);
		grupoBotoes.add(rdbtnPorData);
		
		controleBusca.consultarMembroOrdNome("");
		atualizarTabela();
		limparTela();
		
	}

	// Deixe este método vazio
	@Override
	public Membro painelParaMembro(Membro m, String origem) {
		// TODO Auto-generated method stub
		return null;
	}

	// Deixe este método vazio
	@Override
	public void membroParaPainel(Membro m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Pesquisar")) {
				
			if(rdbtnPorCodigo.isSelected()) {
				
				if(txtCriterio.getText().trim().isEmpty() == false) {
					controleBusca.consultarMembro(txtCriterio.getText());
					atualizarTabela();
					limparTela();
					
				} else {
					JOptionPane.showMessageDialog(null, "O campo \"Critério\","
							+ "deve estar preenchidos antes de acionar"
							+ "\neste botão (exceto em pesquisa por nome).");
					
				}
				
				
			} else if(rdbtnPorNome.isSelected()) {
				controleBusca.consultarMembroOrdNome(txtCriterio.getText());
				atualizarTabela();
				limparTela();
				
				
			} else if(rdbtnPorData.isSelected()) {
				
				if(txtCriterio.getText().trim().isEmpty() == false) {
					controleBusca.consultarMembroOrdData(txtCriterio.getText());
					atualizarTabela();
					limparTela();
					
				} else {
					JOptionPane.showMessageDialog(null, "O campo \"Critério\","
							+ "deve estar preenchidos antes de acionar"
							+ "\neste botão (exceto em pesquisa por nome).");
				}
			
			} 
		
		}
		
	}

	@Override
	public void limparTela() {
		// TODO Auto-generated method stub
		txtCriterio.setText("");
	}
	
	public void atualizarTabela(){
		tabelaPesquisa.invalidate();
		tabelaPesquisa.revalidate();
		tabelaPesquisa.repaint();
	}

}
