package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Producto;
@Stateless
public class ProductoDao {
	@Inject
	private EntityManager em;
	public void create(Producto producto) {
		em.persist(producto);
	}
	
	public List<Producto> listarClientesQueCompraronMas() {
		String sql = "select p.descripcion, m.codigo,m.descripcion,m.egreso,m.ingreso,m.saldo from movimiento m,inventario i,producto p where m.unproducto_codigo=p.codigo and i.codigo=p.inventario_codigo;";
		Query q = em.createNativeQuery(sql);
		List<ComprasTmp> compras = new ArrayList<>();
		List<Object[]> lista = q.getResultList();
		for (Object item[] : lista) {
			ComprasTmp ct = new ComprasTmp();
			ct.setCodigo(Integer.valueOf(item[0].toString()));
			ct.setNombre(item[1].toString());
			ct.setApellidos(item[2].toString());
			ct.setCompras(Integer.valueOf(item[3].toString()));
			compras.add(ct);
		}
		return compras;
	}
	

}
