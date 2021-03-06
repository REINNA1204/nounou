package nounou.commun.service;

import java.util.List;

import nounou.commun.dto.DtoContrat;
import nounou.commun.exception.ExceptionValidation;


public interface IServiceContrat {
	
	int				inserer( DtoContrat dtoContrat ) throws ExceptionValidation;
	
	void			modifier( DtoContrat dtoContrat ) throws ExceptionValidation;
	
	void			supprimer( int idContrat ) throws ExceptionValidation;
	
	DtoContrat 	retrouver( int idContrat );
	
	List<DtoContrat> listerTout();
	

}
