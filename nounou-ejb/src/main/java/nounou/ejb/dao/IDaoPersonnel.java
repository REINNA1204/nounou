package nounou.ejb.dao;

import java.util.List;

import nounou.ejb.data.Personnel;


public interface IDaoPersonnel {

	int			inserer( Personnel personne );

	void 		modifier( Personnel personne );

	void 		supprimer( int idPersonne );

	Personnel 	retrouver( int idPersonne );

	List<Personnel> listerTout();
    
    int 		compterPourCategorie( int idCategorie );

}
