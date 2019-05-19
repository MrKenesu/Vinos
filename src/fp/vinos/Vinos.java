package fp.vinos;

import java.util.HashSet; // HashSet es una implementacion de la interfaz Set
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import java.util.Set; // importación de interfaz Set en java
import java.util.Collection;
import java.util.HashMap;

import fp.utiles.Checkers;

public class Vinos {
	// Atributos

	private Set<Vino> vinos; // conjunto de vinos /*private Set<Vino> micolecciones

	// Constructor vacio
	public Vinos() {
		this.vinos = new HashSet<Vino>();

	}

	// Constructor a partir de un Stream

	public Vinos(Stream<Vino> vinos) {
		this.vinos = vinos.collect(Collectors.toSet());

	}

	// Añadir vino

	public void añadirVino(Vino vino) {

		vinos.add(vino);
	}

	// tostring

	@Override
	public String toString() {
		return "Vinos [vinos=" + vinos + "]";
	}

// hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vinos == null) ? 0 : vinos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vinos other = (Vinos) obj;
		if (vinos == null) {
			if (other.vinos != null)
				return false;
		} else if (!vinos.equals(other.vinos))
			return false;
		return true;
	}
	/*
	 * public Integer calcularNumeroVinoPais(String pais) { return (int)
	 * vinos.stream().filter(vino -> vino.getPais().equals(pais)).count(); // El
	 * atributo que le pasamo por los parámetros, lo comparamos con el .filter
	 * 
	 * 
	 * }
	 */

	// ESQUEMA CONTADOR

	public Integer calcularNumeroVinoPais(String pais) {
		Integer cont = 0;

		for (Vino vino : vinos) {
			if (vino.getPais().equals(pais)) {
				cont++; // cont = cont + 1
			}

		}

		return cont;

	}

	public Vino obtenerVinoMejorPutuado() {
		Vino max = null;
		Integer puntuacionMax = 0;
		for (Vino vino : vinos) {
			if (vino.getPuntos() >= puntuacionMax) {
				puntuacionMax = vino.getPuntos();
				max = vino;

			}

		}
		return max;

	}

	/*
	 * public Vino obtenerVinoMejorPuntuado2(){ Vino max = null;
	 * 
	 * for(Vino vino: vinos){
	 * 
	 * if(max==null){ max = vino;
	 * 
	 * } else { else if (vino.getPuntos()>=max.getPuntos()){ max = vino; } } return
	 * max;
	 * 
	 * }
	 * 
	 * 
	 */

	public Set<String> calcularUvasRegion(String region) {
		Set<String> uvas = new HashSet<String>();

		for (Vino vino : vinos) { // for (Tipo de objeto que hay en esa lista : lo que se recorre)
			if (vino.getRegion().equals(region)) {

				uvas.add(vino.getUva());

			}
			
		}
		// nota: un programador con profesional utiliza siempre el equals
		return uvas;
	}

	public Collection<Vino> obtenerVinosRangoPuntos(Integer min, Integer max) {

		Checkers.check("Limites no validos", min <= max);

		/*
		 * Boolean restriction = min<=max; if(!restriction) {
		 * 
		 * throw new IllegalArgumentException("Limites no validos"); }
		 * 
		 */

		Set<Vino> conj = new HashSet<Vino>();
		for (Vino vino : this.getVinos()) {
			if (vino.getPuntos() >= min && vino.getPuntos() <= max) {
				conj.add(vino);
			}
			
		}
		return conj;

	}

	public Set<Vino> getVinos() {
		return vinos;
	}
	
	public Map<String,Integer> calcularCuantasUvasPorPais(){
		
		Map<String,Integer> res = new HashMap<String,Integer>();
		
		for (Vino vino: vinos) {
			
			String clave = vino.getPais();
			
			if (res.containsKey(clave)) {
				
				res.put(clave,res.get(clave)+1);
			
			} else {
				
				
				
				res.put(clave, 1);
				
				
				}
			
			
		}
		
		return res;
	}
	
	public Map<String,Integer> calcularCalidadPrecioPorRegionMayorDe(Double mayorQue){
		
		Map<String,Integer> res = new HashMap<String,Integer>();
		
		for (Vino vino : vinos) {
			
			String clave = vino.getRegion();
			
			if(vino.getCalidadPrecio()>mayorQue) {
				
				if (res.containsKey(clave)) {
					
					Integer valor = res.get(clave) + 1;
					res.put(clave, valor);
					
					
				} else {
					
					res.put(clave, 1);
				}
				
				
			}
			
			
		}
		
		
		
		return res;
	}

}
