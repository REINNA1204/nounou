package nounou.ejb.dao;

import java.util.List;

import nounou.ejb.data.Suivi;


public interface IDaoSuivi {

	int			inserer( Suivi suivi );

	void 		modifier( Suivi suivi );

	void 		supprimer( int idSuivi );

	Suivi 	retrouver( int idSuivi );

	List<Suivi> listerTout();
    
    int 		compterPourContrat( int idContrat );

}
