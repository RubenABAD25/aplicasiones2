package dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Producto;
@Stateless
public class ProductoDao {
	@Inject
	private EntityManager em;
	public void create(Producto producto) {
		em.persist(producto);
	}

}
