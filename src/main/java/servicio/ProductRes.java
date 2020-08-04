package servicio;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import modelo.Producto;
import negocio.ProductoON;

@Path("/producto")
public class ProductRes {
	@Inject
	private ProductoON pon;
	
	@POST
	@Path("/guardar")
	@Consumes("application/json")
	public void saveProducto(Producto pro) {
		
		try {
			 pon.guardar(pro);
			 System.out.println("entro");
			
		}catch(Exception e) {
			System.out.println("no entro");
			
		}			
		
	}

}
