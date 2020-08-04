package negocio;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ProductoDao;
import modelo.Producto;

@Stateless

public class ProductoON {
	@Inject
	private ProductoDao pdao;
	
	public void guardar(Producto pro) {
		pdao.create(pro);
		
	}
	

}
