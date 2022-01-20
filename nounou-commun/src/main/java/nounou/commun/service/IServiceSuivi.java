package nounou.commun.service;

import java.util.List;

import nounou.commun.dto.DtoSuivi;
import nounou.commun.exception.ExceptionValidation;


public interface IServiceSuivi {
	
	int				inserer( DtoSuivi dtoSuivi ) throws ExceptionValidation;
	
	void			modifier( DtoSuivi dtoSuivi ) throws ExceptionValidation;
	
	void			supprimer( int idSuivi ) throws ExceptionValidation;
	
	DtoSuivi 	retrouver( int idSuivi );
	
	List<DtoSuivi> listerTout();
	

}
