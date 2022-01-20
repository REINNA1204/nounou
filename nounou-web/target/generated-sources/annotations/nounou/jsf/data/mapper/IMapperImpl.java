package nounou.jsf.data.mapper;

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
import nounou.jsf.data.Agrement;
import nounou.jsf.data.Compte;
import nounou.jsf.data.Contrat;
import nounou.jsf.data.Parent;
import nounou.jsf.data.Personnel;
import nounou.jsf.data.Suivi;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-20T23:04:51+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210419-1022, environment: Java 15.0.2 (Oracle Corporation)"
)
@ApplicationScoped
public class IMapperImpl implements IMapper {

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
        if ( source.getId() != null ) {
            dtoCompte.setId( source.getId() );
        }
        dtoCompte.setMotDePasse( source.getMotDePasse() );
        dtoCompte.setPseudo( source.getPseudo() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            dtoCompte.setRoles( new ArrayList<String>( list ) );
        }

        return dtoCompte;
    }

    @Override
    public Compte duplicate(Compte source) {
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
    public Compte update(Compte target, Compte source) {
        if ( source == null ) {
            return null;
        }

        target.setEmail( source.getEmail() );
        target.setId( source.getId() );
        target.setMotDePasse( source.getMotDePasse() );
        target.setPseudo( source.getPseudo() );
        if ( target.getRoles() != null ) {
            List<String> list = source.getRoles();
            if ( list != null ) {
                target.getRoles().clear();
                target.getRoles().addAll( list );
            }
            else {
                target.setRoles( null );
            }
        }
        else {
            List<String> list = source.getRoles();
            if ( list != null ) {
                target.setRoles( new ArrayList<String>( list ) );
            }
        }

        return target;
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

        if ( source.getId() != null ) {
            dtoAgrement.setId( source.getId() );
        }
        dtoAgrement.setLibelle( source.getLibelle() );
        dtoAgrement.setNombremaxenfants( source.getNombremaxenfants() );

        return dtoAgrement;
    }

    @Override
    public Agrement duplicate(Agrement source) {
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
        if ( source.getId() != null ) {
            dtoPersonnel.setId( source.getId() );
        }
        dtoPersonnel.setNom( source.getNom() );
        dtoPersonnel.setPrenom( source.getPrenom() );
        dtoPersonnel.setTelephone( source.getTelephone() );

        return dtoPersonnel;
    }

    @Override
    public Personnel duplicate(Personnel source) {
        if ( source == null ) {
            return null;
        }

        Personnel personnel = new Personnel();

        personnel.setAdresse( source.getAdresse() );
        personnel.setAgrement( duplicate( source.getAgrement() ) );
        personnel.setCompte( duplicate( source.getCompte() ) );
        personnel.setId( source.getId() );
        personnel.setNom( source.getNom() );
        personnel.setPrenom( source.getPrenom() );
        personnel.setTelephone( source.getTelephone() );

        return personnel;
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
        if ( source.getId() != null ) {
            dtoParent.setId( source.getId() );
        }
        dtoParent.setNom( source.getNom() );
        dtoParent.setPrenom( source.getPrenom() );
        dtoParent.setTelephone( source.getTelephone() );

        return dtoParent;
    }

    @Override
    public Parent duplicate(Parent source) {
        if ( source == null ) {
            return null;
        }

        Parent parent = new Parent();

        parent.setAdresse( source.getAdresse() );
        parent.setCompte( duplicate( source.getCompte() ) );
        parent.setId( source.getId() );
        parent.setNom( source.getNom() );
        parent.setPrenom( source.getPrenom() );
        parent.setTelephone( source.getTelephone() );

        return parent;
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

        dtoContrat.setDatedebut( source.getDatedebut() );
        dtoContrat.setDatefin( source.getDatefin() );
        dtoContrat.setDatenaissanceenfant( source.getDatenaissanceenfant() );
        if ( source.getId() != null ) {
            dtoContrat.setId( source.getId() );
        }
        dtoContrat.setNomenfant( source.getNomenfant() );
        dtoContrat.setParent( map( source.getParent() ) );
        dtoContrat.setPersonnel( map( source.getPersonnel() ) );
        dtoContrat.setPrenomenfant( source.getPrenomenfant() );
        dtoContrat.setTarifhoraire( source.getTarifhoraire() );

        return dtoContrat;
    }

    @Override
    public Contrat duplicate(Contrat source) {
        if ( source == null ) {
            return null;
        }

        Contrat contrat = new Contrat();

        contrat.setDatedebut( source.getDatedebut() );
        contrat.setDatefin( source.getDatefin() );
        contrat.setDatenaissanceenfant( source.getDatenaissanceenfant() );
        contrat.setId( source.getId() );
        contrat.setNomenfant( source.getNomenfant() );
        contrat.setParent( duplicate( source.getParent() ) );
        contrat.setPersonnel( duplicate( source.getPersonnel() ) );
        contrat.setPrenomenfant( source.getPrenomenfant() );
        contrat.setTarifhoraire( source.getTarifhoraire() );

        return contrat;
    }

    @Override
    public Suivi map(DtoSuivi source) {
        if ( source == null ) {
            return null;
        }

        Suivi suivi = new Suivi();

        suivi.setContrat( map( source.getContrat() ) );
        suivi.setDatedujour( source.getDatedujour() );
        suivi.setHeurearrivee( source.getHeurearrivee() );
        suivi.setHeuredepart( source.getHeuredepart() );
        suivi.setId( source.getId() );
        suivi.setIsrepas( source.isIsrepas() );
        suivi.setMontantjour( source.getMontantjour() );

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
        if ( source.getId() != null ) {
            dtoSuivi.setId( source.getId() );
        }
        dtoSuivi.setIsrepas( source.isIsrepas() );
        dtoSuivi.setMontantjour( source.getMontantjour() );

        return dtoSuivi;
    }

    @Override
    public Suivi duplicate(Suivi source) {
        if ( source == null ) {
            return null;
        }

        Suivi suivi = new Suivi();

        suivi.setContrat( duplicate( source.getContrat() ) );
        suivi.setDatedujour( source.getDatedujour() );
        suivi.setDformat( source.getDformat() );
        suivi.setHeurearrivee( source.getHeurearrivee() );
        suivi.setHeuredepart( source.getHeuredepart() );
        suivi.setId( source.getId() );
        suivi.setIsrepas( source.isIsrepas() );
        suivi.setMontantjour( source.getMontantjour() );

        return suivi;
    }
}
