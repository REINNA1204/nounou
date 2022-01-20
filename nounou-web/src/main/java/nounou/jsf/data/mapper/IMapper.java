package nounou.jsf.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import nounou.commun.dto.DtoAgrement;
import nounou.commun.dto.DtoCompte;
import nounou.commun.dto.DtoContrat;
import nounou.commun.dto.DtoParent;
import nounou.commun.dto.DtoPersonnel;
import nounou.commun.dto.DtoSuivi;
import nounou.jsf.data.Agrement;
import nounou.jsf.data.Compte;
import nounou.jsf.data.Contrat;
import nounou.jsf.data.Parent;
import nounou.jsf.data.Personnel;
import nounou.jsf.data.Suivi;


@Mapper( componentModel = "cdi" )
public interface IMapper {
  

	// Compte
	
	Compte    map( DtoCompte source );
	
	DtoCompte map( Compte source );
	
	Compte duplicate( Compte source );

	Compte update( @MappingTarget Compte target, Compte source );


	// Agrement
	
	Agrement    map( DtoAgrement source );
	
	DtoAgrement map( Agrement source );
	
	Agrement duplicate( Agrement source );

	
	// Personne
	
	Personnel    map( DtoPersonnel source );
	
	DtoPersonnel map( Personnel source );
	
    Personnel duplicate( Personnel source );
    
	// Parent
	
	Parent    map( DtoParent source );
	
	DtoParent map( Parent source );
	
    Parent duplicate( Parent source );
    
	// Contrat
	
	Contrat    map( DtoContrat source );
	
	DtoContrat map( Contrat source );
	
	Contrat duplicate( Contrat source );
	
	// Suivi
	
	Suivi    map( DtoSuivi source );
	
	DtoSuivi map( Suivi source );
	
	Suivi duplicate( Suivi source );

}
