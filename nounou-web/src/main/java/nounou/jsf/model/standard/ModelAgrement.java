package nounou.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounou.commun.dto.DtoAgrement;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceAgrement;
import nounou.jsf.data.Agrement;
import nounou.jsf.data.mapper.IMapper;
import nounou.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelAgrement implements Serializable {

	
	// Champs
	
	private List<Agrement>		liste;
	
	private Agrement			courant;
	
	@EJB
	private IServiceAgrement	serviceAgrement;
	
	@Inject
	private IMapper				mapper;

	
	// Getters 
	
	public List<Agrement> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoAgrement dto : serviceAgrement.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}

	public Agrement getCourant() {
		if ( courant == null ) {
			courant = new Agrement();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoAgrement dto = serviceAgrement.retrouver( courant.getId() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "L'agrément demandé n'existe pas" );
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
				serviceAgrement.inserer( mapper.map(courant) );
			} else {
				serviceAgrement.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Agrement item ) {
		try {
			serviceAgrement.supprimer( item.getId() );
			liste.remove(item);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e );
		}
		return null;
	}
	
}
