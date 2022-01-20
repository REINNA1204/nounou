package nounou.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounou.commun.dto.DtoSuivi;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceSuivi;
import nounou.jsf.data.Suivi;
import nounou.jsf.data.mapper.IMapper;
import nounou.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelSuivi implements Serializable {

	
	// Champs
	
	private List<Suivi>		liste;
	
	private Suivi			courant;
	
	@EJB
	private IServiceSuivi	serviceSuivi;

	@Inject
	private IMapper				mapper;

	
	// Getters 
	
	public List<Suivi> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoSuivi dto : serviceSuivi.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}

	public Suivi getCourant() {
		if ( courant == null ) {
			courant = new Suivi();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoSuivi dto = serviceSuivi.retrouver( courant.getId() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "Le suivi demandé n'existe pas" );
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
				serviceSuivi.inserer( mapper.map(courant) );
			} else {
				serviceSuivi.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Suivi suivi ) {
		try {
			serviceSuivi.supprimer( suivi.getId() );
			liste.remove(suivi);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
}
