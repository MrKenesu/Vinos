package fp.vinos;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class FactoriaVinos {
	private static Vino parsearVino(String leerCSV) {
		//Creamos un array de los elementos de la linea de CSV
		String[] campo = leerCSV.split(","); 
		//usamos split para partir por la coma los elementos de la linea 
		
		//Excepcion
		
		if (campo.length != 5) {
			throw new IllegalArgumentException("formato de cadena no válido" + campo.length);
			
		}
		
		// Creacion de variables para el objeto, según su correspondiente array
		String pais = campo[0].trim();
		String region = campo[1].trim();
		Integer puntos = Integer.valueOf(campo[2].trim());
		//Integer.valueOf(String) -> Devuelve un Integer que contiene el valor del String
		Double precio = Double.valueOf(campo[3].trim());
		String uva = campo[4].trim();
	
		//
		
		return new Vino(pais, region, puntos, precio, uva);
		
	}
	
	public static Vinos leerVinos(String fichero) {
		
		
		Vinos ap = null;
		try {
		Stream<Vino> sv = Files.lines(Paths.get(fichero), StandardCharsets.UTF_8)
				.skip(1).map(FactoriaVinos::parsearVino);
		
		ap = new Vinos(sv);
		
		} catch (IOException e) {
			
		System.out.println("Fichero no encontrado " + fichero);
		e.printStackTrace();
		}
		return ap;
		
	}
}