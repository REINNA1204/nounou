package nounou.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounou.commun.dto.DtoPersonnel;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceCompte;
import nounou.commun.service.IServicePersonnel;
import nounou.jsf.data.Personnel;
import nounou.jsf.data.mapper.IMapper;
import nounou.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelPersonnel implements Serializable {

	
	// Champs
	
	private List<Personnel>		liste;
	
	private Personnel			courant;
	
	@EJB
	private IServicePersonnel	servicePersonnel;
	
	@EJB
	private IServiceCompte	serviceCompte;

	@Inject
	private IMapper				mapper;

	
	// Getters 
	
	public List<Personnel> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoPersonnel dto : servicePersonnel.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}

	public Personnel getCourant() {
		if ( courant == null ) {
			courant = new Personnel();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoPersonnel dto = servicePersonnel.retrouver( courant.getId() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "La personne demandée n'existe pas" );
				return "liste";
			} else {
				courant = mapper.map( dto );
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		try {
			if ( courant.getId() == null) {
				servicePersonnel.inserer( mapper.map(courant) );
			} else {
				servicePersonnel.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Personnel personnel ) {
		try {
			servicePersonnel.supprimer( personnel.getId() );
			liste.remove(personnel);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
}
