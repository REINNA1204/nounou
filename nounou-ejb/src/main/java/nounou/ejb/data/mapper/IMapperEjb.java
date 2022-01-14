package nounou.ejb.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import nounou.commun.dto.DtoAgrement;
import nounou.commun.dto.DtoCompte;
import nounou.commun.dto.DtoPersonnel;
import nounou.ejb.data.Agrement;
import nounou.ejb.data.Compte;
import nounou.ejb.data.Personnel;

 
@Mapper( componentModel = "cdi" )
public interface IMapperEjb {  
	
	static final IMapperEjb INSTANCE = Mappers.getMapper( IMapperEjb.class );
	
	
	// Compte
	
	Compte map( DtoCompte source );
	
	DtoCompte map( Compte source );

	
	// Categorie
	
	Agrement map( DtoAgrement source );
	
	DtoAgrement map( Agrement source );

	
	// Personne
	
	Personnel map( DtoPersonnel source );
	
	DtoPersonnel map( Personnel source );

	@Mapping( target="agrement", ignore = true )
//	@Mapping( target="telephones", ignore = true )
	DtoPersonnel mapMinimal( Personnel source );
	
	
	// Telephone
	
//	@Mapping( target="personne", ignore=true )
//	Telephone map( DtoTelephone source );
//	
//	DtoTelephone map( Telephone source );
	

	// Méthodes auxiliaires
	
//    @AfterMapping
//    public default void addBackReference(@MappingTarget Personnel target) {
//        for (Telephone telephone : target.getTelephones() ) {
//        	telephone.setPersonne( target );
//        }
//    }	
	
}
