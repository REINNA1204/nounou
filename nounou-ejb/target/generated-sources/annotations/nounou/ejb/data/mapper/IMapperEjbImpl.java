package nounou.ejb.data.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
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

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-20T08:52:59+0100",
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
        agrement.setNombremaxenfants( source.getNombremaxenfants() );

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
        dtoAgrement.setNombremaxenfants( source.getNombremaxenfants() );

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
        personnel.setCompte( map( source.getCompte() ) );
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
        dtoPersonnel.setCompte( map( source.getCompte() ) );
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
        dtoPersonnel.setAgrement( map( source.getAgrement() ) );
        dtoPersonnel.setCompte( map( source.getCompte() ) );
        dtoPersonnel.setId( source.getId() );
        dtoPersonnel.setNom( source.getNom() );
        dtoPersonnel.setPrenom( source.getPrenom() );
        dtoPersonnel.setTelephone( source.getTelephone() );

        return dtoPersonnel;
    }

    @Override
    public Parent map(DtoParent source) {
        if ( source == null ) {
            return null;
        }

        Parent parent = new Parent();

        parent.setAdresse( source.getAdresse() );
        parent.setCompte( map( source.getCompte() ) );
        parent.setId( source.getId() );
        parent.setNom( source.getNom() );
        parent.setPrenom( source.getPrenom() );
        parent.setTelephone( source.getTelephone() );

        return parent;
    }

    @Override
    public DtoParent map(Parent source) {
        if ( source == null ) {
            return null;
        }

        DtoParent dtoParent = new DtoParent();

        dtoParent.setAdresse( source.getAdresse() );
        dtoParent.setCompte( map( source.getCompte() ) );
        dtoParent.setId( source.getId() );
        dtoParent.setNom( source.getNom() );
        dtoParent.setPrenom( source.getPrenom() );
        dtoParent.setTelephone( source.getTelephone() );

        return dtoParent;
    }

    @Override
    public Contrat map(DtoContrat source) {
        if ( source == null ) {
            return null;
        }

        Contrat contrat = new Contrat();

        contrat.setDatedebut( source.getDatedebut() );
        contrat.setDatefin( source.getDatefin() );
        contrat.setDatenaissanceenfant( source.getDatenaissanceenfant() );
        contrat.setId( source.getId() );
        contrat.setNomenfant( source.getNomenfant() );
        contrat.setParent( map( source.getParent() ) );
        contrat.setPersonnel( map( source.getPersonnel() ) );
        contrat.setPrenomenfant( source.getPrenomenfant() );
        contrat.setTarifhoraire( source.getTarifhoraire() );

        return contrat;
    }

    @Override
    public DtoContrat map(Contrat source) {
        if ( source == null ) {
            return null;
        }

        DtoContrat dtoContrat = new DtoContrat();

        dtoContrat.setParent( map( source.getParent() ) );
        dtoContrat.setDatedebut( source.getDatedebut() );
        dtoContrat.setDatefin( source.getDatefin() );
        dtoContrat.setDatenaissanceenfant( source.getDatenaissanceenfant() );
        dtoContrat.setId( source.getId() );
        dtoContrat.setNomenfant( source.getNomenfant() );
        dtoContrat.setPrenomenfant( source.getPrenomenfant() );
        dtoContrat.setTarifhoraire( source.getTarifhoraire() );

        return dtoContrat;
    }

    @Override
    public Suivi map(DtoSuivi source) {
        if ( source == null ) {
            return null;
        }

        Suivi suivi = new Suivi();

        suivi.setId( source.getId() );
        suivi.setDatedujour( source.getDatedujour() );
        suivi.setHeurearrivee( source.getHeurearrivee() );
        suivi.setHeuredepart( source.getHeuredepart() );
        suivi.setIsrepas( source.isIsrepas() );
        suivi.setMontantjour( source.getMontantjour() );
        suivi.setContrat( map( source.getContrat() ) );

        return suivi;
    }

    @Override
    public DtoSuivi map(Suivi source) {
        if ( source == null ) {
            return null;
        }

        DtoSuivi dtoSuivi = new DtoSuivi();

        dtoSuivi.setContrat( map( source.getContrat() ) );
        dtoSuivi.setDatedujour( source.getDatedujour() );
        dtoSuivi.setHeurearrivee( source.getHeurearrivee() );
        dtoSuivi.setHeuredepart( source.getHeuredepart() );
        dtoSuivi.setId( source.getId() );
        dtoSuivi.setIsrepas( source.isIsrepas() );
        dtoSuivi.setMontantjour( source.getMontantjour() );

        return dtoSuivi;
    }
}
