package principal;

import view.TelaPrograma;

import java.time.DayOfWeek;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import control.CtrMembro;
import model.Membro;

public class Classe0 {
	private static CtrMembro controleMembro;
	private static TelaPrograma tp;
	private static Membro m;
	private static List<Membro> listaAniversariantes;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Bem-vindo(a) ao Hoje Tem Festa?"
				+ "\nProjetado e desenvolvido por:"
				+ "\nDiego Souza Silva,"
				+ "\nE-mail: diego00023@gmail.com"
				+ "\nJesus Salva!"
				+ "\nIs 54:16-17"
				+ "\n12/07/2017.");
		
		JOptionPane.showMessageDialog(null, "Verificando se h� anivers�riantes..."
				+ "\nLeia as mesnsagensa com calma e aten��o,"
				+ "\npor favor.");
		
		// Que dia � hoje?
		if(LocalDate.now().getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			// Se for Domingo, calcule hoje e de seis dia pra c�
			exibirEmTelaAniversarianteDiasPassados(6);
			
		} else if(LocalDate.now().getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
			// Se for S�bado, calcule hoje e de cinco dia pra c�
			exibirEmTelaAniversarianteDiasPassados(5);
			
		} else if(LocalDate.now().getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
			// Se for Sexta-feira, calcule hoje e de quatro dia pra c�
			exibirEmTelaAniversarianteDiasPassados(4);
			
		} else if(LocalDate.now().getDayOfWeek().equals(DayOfWeek.THURSDAY)) {
			// Se for Quinta-feira, calcule hoje e de tr�s dia pra c�
			exibirEmTelaAniversarianteDiasPassados(3);
			
		} else if(LocalDate.now().getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) {
			// Se for Quarta-feira, calcule hoje e de dois dia pra c�
			exibirEmTelaAniversarianteDiasPassados(2);
			
		} else if(LocalDate.now().getDayOfWeek().equals(DayOfWeek.TUESDAY)) {
			// Se for Ter�a-feira, calcule hoje e ontem
			exibirEmTelaAniversarianteDiasPassados(1);
			
		} else if(LocalDate.now().getDayOfWeek().equals(DayOfWeek.MONDAY)) {
			// Se for Segunda-feira, calcule hoje somente
			
		}
		
		exibirEmTelaAniversarianteHoje();
		tp = new TelaPrograma();
		tp.setVisible(true);
	}
	
	// A mensagem ser� exibida em um pop-up.
	public static void exibirEmTelaAniversarianteHoje() {
		listaAniversariantes = new ArrayList<>();
		controleMembro = new CtrMembro();
		
		// Captura e formata a data de hoje
		LocalDate hoje = LocalDate.now();
		//DateTimeFormatter formato = SimpleDateFormat("dd/MM/yyyy"); // Funciona?
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataEntrada = hoje.format(formato);
		
		listaAniversariantes = controleMembro.buscarAniversariantes(dataEntrada);
		
		int cont = 0;
		
		while(cont < listaAniversariantes.size()) {
			m = new Membro();
			
			m.setIdMembro(listaAniversariantes.get(cont).getIdMembro());
			m.setNome(listaAniversariantes.get(cont).getNome());
			m.setApelido(listaAniversariantes.get(cont).getApelido());
			m.setSobrenomes(listaAniversariantes.get(cont).getSobrenomes());
			m.setCargo(listaAniversariantes.get(cont).getCargo());
			m.setDia(listaAniversariantes.get(cont).getDia());
			m.setMes(listaAniversariantes.get(cont).getMes());
			m.setAno(listaAniversariantes.get(cont).getAno());
			
			JOptionPane.showMessageDialog(null, "Parab�ns,\n" + m.getCargo() + " "
					+ m.getNome() + " \"" + m.getApelido() + "\" " + m.getSobrenomes()
					+ "\npor seu anivers�rio.");
			
			cont++;
			
		}
		
		if(cont > 0) {
			JOptionPane.showMessageDialog(null, "Que as mais seletas b�n��os possam vos\n"
					+ "alcan�ar e que Jesus vos multiplique vossos\n"
					+ "anos de vida e vos d� a Vida Eterna!!!\n;-D");
		} else {
			JOptionPane.showMessageDialog(null, "Que pena! \nSem aniversariantes hoje."
					+ "\n :-C");
		}
		
		
	}
	
	public static void exibirEmTelaAniversarianteDiasPassados(int nDiasAtras) {
		
		while(nDiasAtras > 0) {
			listaAniversariantes = new ArrayList<>();
			controleMembro = new CtrMembro();
			
			// Captura e formata a data de hoje
			LocalDate hoje = LocalDate.now().minusDays(nDiasAtras);
			//DateTimeFormatter formato = SimpleDateFormat("dd/MM/yyyy"); // Funciona?
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dataEntrada = hoje.format(formato);
			
			listaAniversariantes = controleMembro.buscarAniversariantes(dataEntrada);
			
			int cont = 0;
			
			while(cont < listaAniversariantes.size()) {
				m = new Membro();
				
				m.setIdMembro(listaAniversariantes.get(cont).getIdMembro());
				m.setNome(listaAniversariantes.get(cont).getNome());
				m.setApelido(listaAniversariantes.get(cont).getApelido());
				m.setSobrenomes(listaAniversariantes.get(cont).getSobrenomes());
				m.setCargo(listaAniversariantes.get(cont).getCargo());
				m.setDia(listaAniversariantes.get(cont).getDia());
				m.setMes(listaAniversariantes.get(cont).getMes());
				m.setAno(listaAniversariantes.get(cont).getAno());
				
				JOptionPane.showMessageDialog(null, "Parab�ns,\n" + m.getCargo() + " "
						+ m.getNome() + " \"" + m.getApelido() + "\" " + m.getSobrenomes()
						+ "\npor seu anivers�rio em " + formato.format(LocalDate.now().minusDays(nDiasAtras)));
				
				cont++;
				
			}
			
			if(cont > 0) {
				JOptionPane.showMessageDialog(null, "Que as mais seletas b�n��os possam vos\n"
						+ "alcan�ar e que Jesus vos multiplique vossos\n"
						+ "anos de vida e vos d� a Vida Eterna!!!\n;-D");
			} else {
				JOptionPane.showMessageDialog(null, "Que pena! \nSem aniversariantes no dia "
						+ formato.format(LocalDate.now().minusDays(nDiasAtras)) + "\n :-C");
			}
			
			nDiasAtras--;
		}
		
		
	}

}
