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
	public int inserer(Agrement categorie) {
		em.persist(categorie);
		em.flush();
		return categorie.getId();
	}

	@Override
	public void modifier(Agrement categorie) {
		em.merge( categorie );
	}

	@Override
	public void supprimer(int idCategorie) {
		em.remove( retrouver(idCategorie) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Agrement retrouver(int idCategorie) {
		return em.find( Agrement.class, idCategorie );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Agrement> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Categorie c ORDER BY c.libelle";
		var query = em.createQuery( jpql, Agrement.class );
		return query.getResultList();
	}
	
}
