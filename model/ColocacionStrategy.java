/*
 * El usuario ha definido que desea que el sistema registre distintas pautas de colocación.
 * Una pauta de colocación es un algoritmo matemático por el cual el sistema en lugar de
 * tomar las últimas tres ediciones debe tomar otras ediciones en consideración.
 * Estas pautas de colocación son variables en el tiempo y también el sistema debe permitir 
 * incorporar nuevas y asignarlas a la colocación de una publicación en especial.
 */

package model;

import java.util.ArrayList;

public interface ColocacionStrategy {
	public void cargar(ArrayList<Colocacion> ultimas3Colocaciones);
	
}
