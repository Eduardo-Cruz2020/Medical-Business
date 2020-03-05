
package Negocio;

import java.util.ArrayList;

import Dominio.Materia_Prima;


public interface ServicioMprima {
	ArrayList<Materia_Prima> obtenerproductos();

	boolean generaRegistro(int id, String nombre, double precio);

	ArrayList<Materia_Prima> obtenerInformacionProductos();
}
