package nounou.ejb.dao;

import java.util.List;

import nounou.ejb.data.Personnel;
import nounou.ejb.data.Telephone;


public interface IDaoTelephone {

	void insererPourPersonne(Personnel personne);

	void modifierPourPersonne(Personnel personne);

	void supprimerPourPersonne(int idPersonne);

	List<Telephone> listerPourPersonne( Personnel personne );

}
