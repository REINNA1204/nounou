package nounou.ejb.dao;

import java.util.List;

import nounou.ejb.data.Agrement;


public interface IDaoAgrement {

	int			inserer( Agrement categorie );

	void 		modifier( Agrement categorie );

	void 		supprimer( int idCategorie );

	Agrement 	retrouver( int idCategorie );

	List<Agrement> listerTout();

}
