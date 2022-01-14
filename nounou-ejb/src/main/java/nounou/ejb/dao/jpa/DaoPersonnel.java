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
	public int inserer(Personnel personne) {
		em.persist(personne);
		em.flush();
		return personne.getId();
	}

	@Override
	public void modifier(Personnel personne) {
		em.merge( personne );
	}

	@Override
	public void supprimer(int idPersonne) {
		em.remove( retrouver(idPersonne) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Personnel retrouver(int idPersonne) {
		var graph = em.createEntityGraph( Personnel.class );
		graph.addAttributeNodes( "categorie" );
		graph.addAttributeNodes( "telephones" );
		var props = new HashMap<String, Object>();
		props.put( "javax.persistence.loadgraph", graph );
		return em.find( Personnel.class, idPersonne, props );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Personnel> listerTout() {
		em.clear();
		var jpql = "SELECT p FROM Personne p ORDER BY p.nom, p.prenom";
		var query = em.createQuery( jpql, Personnel.class );
		return query.getResultList();
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public int compterPourCategorie(int idCategorie) {
		var jpql = "SELECT COUNT(p) FROM Personne p WHERE p.categorie.id = :idCategorie";
		var query = em.createQuery( jpql, Long.class );
		query.setParameter( "idCategorie", idCategorie );
		return query.getSingleResult().intValue();
	}

}
