package nounou.commun.service;

import java.util.List;

import nounou.commun.dto.DtoPersonnel;
import nounou.commun.exception.ExceptionValidation;


public interface IServicePersonnel {
	
	int				inserer( DtoPersonnel dtoPersonnel ) throws ExceptionValidation;
	
	void			modifier( DtoPersonnel dtoPersonnel ) throws ExceptionValidation;
	
	void			supprimer( int idPersonnel ) throws ExceptionValidation;
	
	DtoPersonnel 	retrouver( int idPersonnel );
	
	List<DtoPersonnel> listerTout();
	

}
