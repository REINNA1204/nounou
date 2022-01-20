package nounou.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nounou.ejb.dao.IDaoParent;
import nounou.ejb.data.Parent;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoParent implements IDaoParent {
	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;

	
	// Actions
	
	@Override
	public int inserer(Parent parent) {
		em.persist(parent);
		em.flush();
		return parent.getId();
	}

	@Override
	public void modifier(Parent parent) {
		em.merge( parent );
	}

	@Override
	public void supprimer(int idParent) {
		em.remove( retrouver(idParent) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Parent retrouver(int idParent) {
		var graph = em.createEntityGraph( Parent.class );
		var props = new HashMap<String, Object>();
		props.put( "javax.persistence.loadgraph", graph );
		return em.find( Parent.class, idParent, props );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Parent> listerTout() {
		em.clear();
		var jpql = "SELECT p FROM Parent p ORDER BY p.nom, p.prenom";
		var query = em.createQuery( jpql, Parent.class );
		return query.getResultList();
	}

}
