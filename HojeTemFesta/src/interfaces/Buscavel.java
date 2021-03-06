package interfaces;

import java.util.List;
import model.Membro;

/*
 * Autor: Diego Souza Silva
 * Data: 28/06/2017
 */

public interface Buscavel {
	
	public List<Membro> buscarAniversariantes(String entrada);
	
	public List<Membro> consultarMembro(String entrada);
	
}
