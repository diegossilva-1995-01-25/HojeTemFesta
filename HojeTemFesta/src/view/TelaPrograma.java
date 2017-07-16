package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrograma extends Tela implements ActionListener {

	private static final long serialVersionUID = -7817165750578093162L;
	private JPanel contentPane;
	private PainelCadastro pCad;
	private PainelConsulta pCon;
	
	public TelaPrograma() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DiegoSSilva\\Desktop\\Projeto Hoje Tem Festa\\HojeTemFesta\\Visualpharm-Happy-Easter-Cake.ico"));
		setBackground(new Color(0, 102, 255));
		setFont(new Font("Edwardian Script ITC", Font.PLAIN, 28));
		setTitle("Hoje Tem Festa? (Utilize os bot\u00F5es - clique nas op\u00E7\u00F5es)");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 900, 900);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmCadastrarMembros = new JMenuItem("Cadastrar Membros");
		mntmCadastrarMembros.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 28));
		mntmCadastrarMembros.addActionListener(this);
		menuBar.add(mntmCadastrarMembros);
		
		JMenuItem mntmConsultarMembros = new JMenuItem("Consultar Membros");
		mntmConsultarMembros.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 28));
		mntmConsultarMembros.addActionListener(this);
		menuBar.add(mntmConsultarMembros);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 28));
		mntmSair.addActionListener(this);
		menuBar.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	@Override
	public void colocarPainel(PainelGenerico pg) {
		// TODO Auto-generated method stub
		contentPane.add(pg);
		atualizarTela();
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Cadastrar Membros")) {
			
			if(pCad == null) {
				pCad = new PainelCadastro();
			}
			
			if(pCon != null) {
				contentPane.remove(pCon);
			}
			
			colocarPainel(pCad);
			
			
		} else if(e.getActionCommand().equals("Consultar Membros")) {
			
			if(pCon == null) {
				pCon = new PainelConsulta();
			}
			
			if(pCad != null) {
				contentPane.remove(pCad);
			}
			
			colocarPainel(pCon);
			
			
		} else if(e.getActionCommand().equals("Sair")) {
			System.exit(0);
		}
	}
	
	private void atualizarTela() {
		contentPane.invalidate();
		contentPane.revalidate();
		contentPane.repaint();
	}
	
}
