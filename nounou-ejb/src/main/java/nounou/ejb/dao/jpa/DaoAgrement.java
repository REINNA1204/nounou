package nounou.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nounou.ejb.dao.IDaoAgrement;
import nounou.ejb.data.Agrement;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoAgrement implements IDaoAgrement {

	
	// Champs

	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Agrement agrement) {
		em.persist(agrement);
		em.flush();
		return agrement.getId();
	}

	@Override
	public void modifier(Agrement agrement) {
		em.merge( agrement );
	}

	@Override
	public void supprimer(int idAgrement) {
		em.remove( retrouver(idAgrement) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Agrement retrouver(int idAgrement) {
		return em.find( Agrement.class, idAgrement );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Agrement> listerTout() {
		em.clear();
		var jpql = "SELECT a FROM Agrement a ORDER BY a.libelle";
		var query = em.createQuery( jpql, Agrement.class );
		return query.getResultList();
	}
	
}
