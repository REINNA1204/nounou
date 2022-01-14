package nounou.commun.service;

import java.util.List;

import nounou.commun.dto.DtoAgrement;
import nounou.commun.exception.ExceptionValidation;


public interface IServiceAgrement {
	
	int		inserer( DtoAgrement dtoAgrement ) throws ExceptionValidation;

	void	modifier( DtoAgrement dtoAgrement ) throws ExceptionValidation;

	void	supprimer( int idAgrement ) throws ExceptionValidation;

	DtoAgrement	retrouver( int idAgrement );

	List<DtoAgrement>	listerTout();

}
