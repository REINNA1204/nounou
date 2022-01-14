package nounou.ejb.data.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import nounou.commun.dto.DtoAgrement;
import nounou.commun.dto.DtoCompte;
import nounou.commun.dto.DtoPersonnel;
import nounou.ejb.data.Agrement;
import nounou.ejb.data.Compte;
import nounou.ejb.data.Personnel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-13T21:25:18+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210419-1022, environment: Java 15.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class IMapperEjbImpl implements IMapperEjb {

    @Override
    public Compte map(DtoCompte source) {
        if ( source == null ) {
            return null;
        }

        Compte compte = new Compte();

        compte.setEmail( source.getEmail() );
        compte.setId( source.getId() );
        compte.setMotDePasse( source.getMotDePasse() );
        compte.setPseudo( source.getPseudo() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            compte.setRoles( new ArrayList<String>( list ) );
        }

        return compte;
    }

    @Override
    public DtoCompte map(Compte source) {
        if ( source == null ) {
            return null;
        }

        DtoCompte dtoCompte = new DtoCompte();

        dtoCompte.setEmail( source.getEmail() );
        dtoCompte.setId( source.getId() );
        dtoCompte.setMotDePasse( source.getMotDePasse() );
        dtoCompte.setPseudo( source.getPseudo() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            dtoCompte.setRoles( new ArrayList<String>( list ) );
        }

        return dtoCompte;
    }

    @Override
    public Agrement map(DtoAgrement source) {
        if ( source == null ) {
            return null;
        }

        Agrement agrement = new Agrement();

        agrement.setId( source.getId() );
        agrement.setLibelle( source.getLibelle() );

        return agrement;
    }

    @Override
    public DtoAgrement map(Agrement source) {
        if ( source == null ) {
            return null;
        }

        DtoAgrement dtoAgrement = new DtoAgrement();

        dtoAgrement.setId( source.getId() );
        dtoAgrement.setLibelle( source.getLibelle() );

        return dtoAgrement;
    }

    @Override
    public Personnel map(DtoPersonnel source) {
        if ( source == null ) {
            return null;
        }

        Personnel personnel = new Personnel();

        personnel.setAdresse( source.getAdresse() );
        personnel.setAgrement( map( source.getAgrement() ) );
        personnel.setId( source.getId() );
        personnel.setNom( source.getNom() );
        personnel.setPrenom( source.getPrenom() );
        personnel.setTelephone( source.getTelephone() );

        return personnel;
    }

    @Override
    public DtoPersonnel map(Personnel source) {
        if ( source == null ) {
            return null;
        }

        DtoPersonnel dtoPersonnel = new DtoPersonnel();

        dtoPersonnel.setAdresse( source.getAdresse() );
        dtoPersonnel.setAgrement( map( source.getAgrement() ) );
        dtoPersonnel.setId( source.getId() );
        dtoPersonnel.setNom( source.getNom() );
        dtoPersonnel.setPrenom( source.getPrenom() );
        dtoPersonnel.setTelephone( source.getTelephone() );

        return dtoPersonnel;
    }

    @Override
    public DtoPersonnel mapMinimal(Personnel source) {
        if ( source == null ) {
            return null;
        }

        DtoPersonnel dtoPersonnel = new DtoPersonnel();

        dtoPersonnel.setAdresse( source.getAdresse() );
        dtoPersonnel.setId( source.getId() );
        dtoPersonnel.setNom( source.getNom() );
        dtoPersonnel.setPrenom( source.getPrenom() );
        dtoPersonnel.setTelephone( source.getTelephone() );

        return dtoPersonnel;
    }
}
