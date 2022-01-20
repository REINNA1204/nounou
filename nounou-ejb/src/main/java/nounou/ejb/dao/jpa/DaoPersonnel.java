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

import nounou.ejb.dao.IDaoPersonnel;
import nounou.ejb.data.Personnel;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoPersonnel implements IDaoPersonnel {
	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;

	
	// Actions
	
	@Override
	public int inserer(Personnel personnel) {
		em.persist(personnel);
		em.flush();
		return personnel.getId();
	}

	@Override
	public void modifier(Personnel personnel) {
		em.merge( personnel );
	}

	@Override
	public void supprimer(int idPersonnel) {
		em.remove( retrouver(idPersonnel) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Personnel retrouver(int idPersonnel) {
		var graph = em.createEntityGraph( Personnel.class );
		graph.addAttributeNodes( "agrement" );
		var props = new HashMap<String, Object>();
		props.put( "javax.persistence.loadgraph", graph );
		return em.find( Personnel.class, idPersonnel, props );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Personnel> listerTout() {
		em.clear();
		var jpql = "SELECT p FROM Personnel p ORDER BY p.nom, p.prenom";
		var query = em.createQuery( jpql, Personnel.class );
		return query.getResultList();
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public int compterPourAgrement(int idAgrement) {
		var jpql = "SELECT COUNT(p) FROM Personnel p WHERE p.agrement.id = :idAgrement";
		var query = em.createQuery( jpql, Long.class );
		query.setParameter( "idAgrement", idAgrement );
		return query.getSingleResult().intValue();
	}

}
