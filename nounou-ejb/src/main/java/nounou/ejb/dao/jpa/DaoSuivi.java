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

import nounou.ejb.dao.IDaoSuivi;
import nounou.ejb.data.Suivi;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoSuivi implements IDaoSuivi {
	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;

	
	// Actions
	
	@Override
	public int inserer(Suivi suivi) {
		em.persist(suivi);
		em.flush();
		return suivi.getId();
	}

	@Override
	public void modifier(Suivi suivi) {
		em.merge( suivi );
	}

	@Override
	public void supprimer(int idSuivi) {
		em.remove( retrouver(idSuivi) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Suivi retrouver(int idSuivi) {
		var graph = em.createEntityGraph( Suivi.class );
		var props = new HashMap<String, Object>();
		props.put( "javax.persistence.loadgraph", graph );
		return em.find( Suivi.class, idSuivi, props );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Suivi> listerTout() {
		em.clear();
		var jpql = "SELECT s FROM Suivi s ORDER BY s.contrat.nomenfant, s.contrat.prenomenfant";
		var query = em.createQuery( jpql, Suivi.class );
		return query.getResultList();
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public int compterPourContrat(int idContrat) {
		var jpql = "SELECT COUNT(s) FROM Suivi s WHERE s.contrat.id = :idContrat";
		var query = em.createQuery( jpql, Long.class );
		query.setParameter( "idContrat", idContrat );
		return query.getSingleResult().intValue();
	}

}
