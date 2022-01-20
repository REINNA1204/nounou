package nounou.ejb.dao;

import java.util.List;

import nounou.ejb.data.Personnel;


public interface IDaoPersonnel {

	int			inserer( Personnel personnel );

	void 		modifier( Personnel personnel );

	void 		supprimer( int idPersonnel );

	Personnel 	retrouver( int idPersonnel );

	List<Personnel> listerTout();
    
    int 		compterPourAgrement( int idAgrement );

}
