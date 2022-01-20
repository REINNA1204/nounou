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

import nounou.ejb.dao.IDaoContrat;
import nounou.ejb.data.Contrat;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoContrat implements IDaoContrat {
	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;

	
	// Actions
	
	@Override
	public int inserer(Contrat contrat) {
		em.persist(contrat);
		em.flush();
		return contrat.getId();
	}

	@Override
	public void modifier(Contrat contrat) {
		em.merge( contrat );
	}

	@Override
	public void supprimer(int idContrat) {
		em.remove( retrouver(idContrat) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Contrat retrouver(int idContrat) {
		var graph = em.createEntityGraph( Contrat.class );
		var props = new HashMap<String, Object>();
		props.put( "javax.persistence.loadgraph", graph );
		return em.find( Contrat.class, idContrat, props );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Contrat> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Contrat c ORDER BY c.nomenfant, c.prenomenfant";
		var query = em.createQuery( jpql, Contrat.class );
		return query.getResultList();
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public int compterPourParent(int idParent) {
		var jpql = "SELECT COUNT(c) FROM Contrat c WHERE c.parent.id = :idParent";
		var query = em.createQuery( jpql, Long.class );
		query.setParameter( "idParent", idParent );
		return query.getSingleResult().intValue();
	}
	
	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public int compterPourPersonnel(int idPersonnel) {
		var jpql = "SELECT COUNT(c) FROM Contrat c WHERE c.personnel.id = :idPersonnel";
		var query = em.createQuery( jpql, Long.class );
		query.setParameter( "idPersonnel", idPersonnel );
		return query.getSingleResult().intValue();
	}

}
