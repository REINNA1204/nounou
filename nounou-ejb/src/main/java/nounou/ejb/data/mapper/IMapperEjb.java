package nounou.ejb.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import nounou.commun.dto.DtoAgrement;
import nounou.commun.dto.DtoCompte;
import nounou.commun.dto.DtoContrat;
import nounou.commun.dto.DtoParent;
import nounou.commun.dto.DtoPersonnel;
import nounou.commun.dto.DtoSuivi;
import nounou.ejb.data.Agrement;
import nounou.ejb.data.Compte;
import nounou.ejb.data.Contrat;
import nounou.ejb.data.Parent;
import nounou.ejb.data.Personnel;
import nounou.ejb.data.Suivi;

 
@Mapper( componentModel = "cdi" )
public interface IMapperEjb {  
	
	static final IMapperEjb INSTANCE = Mappers.getMapper( IMapperEjb.class );
	
	
	// Compte
	
	Compte map( DtoCompte source );
	
	DtoCompte map( Compte source );

	
	// Categorie
	
	Agrement map( DtoAgrement source );
	
	DtoAgrement map( Agrement source );

	
	// Personnel
	
	Personnel map( DtoPersonnel source );
	
	DtoPersonnel map( Personnel source );

	//@Mapping( target="agrement", ignore = true )
	DtoPersonnel mapMinimal( Personnel source );
	
	// Parent
	
	Parent map( DtoParent source );
	
	DtoParent map( Parent source );
	
	// Contrat
	
	Contrat map( DtoContrat source );
	@Mapping( target="personnel", ignore = true )
	@Mapping( target="parent", ignore = false )
	DtoContrat map(Contrat source);
	
	// Suici
	
	Suivi map( DtoSuivi source );
	
	DtoSuivi map(Suivi source);
	
}
