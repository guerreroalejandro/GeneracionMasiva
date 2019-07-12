package generacionDatos;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class mainGenerarDatos {

	public static void main(String[] args) {
		
		// Generación del fichero
		FileWriter fichero = null;
		PrintWriter pw = null;
		String cadena = "";
		
		try {
			
			// Generamos el número aleatorio
			Random num = new Random();
			int valorCadena = num.nextInt(9)+1;  // Entre 0 y 9, más 1.
			
			// Generamos el fichero
			fichero = new FileWriter ("D:/Programacion/GeneracionFicheros/cargaDatos.sql");
			pw = new PrintWriter(fichero);
			
			
			for (int i=0; i<15000000; i++) {	
				
				// Comprobación para que nos de un nuevo número cada 10 registros
				if(i%10==0) {
					valorCadena = num.nextInt(9)+1; 
				}
				cadena = "Insert into SIDCA_OWN.HCE_LOG_ACCESO VALUES (SYSDATE, 'CargaMasiva"+valorCadena+"', '/ec/busquedaHistorias?accion=visualizar"+i+"', '10.22.105.17');";
				pw.println(cadena);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				// Aprovechamos el finally para asegurarnos que se cierra el fichero
				if(fichero!=null) {
					System.out.println ("Fichero generado correctamente");
					fichero.close(); 	
				}
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}	
	}
}
