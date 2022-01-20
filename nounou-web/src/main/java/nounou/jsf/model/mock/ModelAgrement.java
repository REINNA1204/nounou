package nounou.jsf.model.mock;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounou.jsf.data.Agrement;
import nounou.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelAgrement implements Serializable {

	
	// Champs
	
	private List<Agrement>	liste;
	
	private Agrement		courant;
	
	@Inject
	private Donnees			données;

	
	// Getters 
	
	public List<Agrement> getListe() {
		if ( liste == null ) {
			liste = données.getAgrements();
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
			courant = données.agrementRetrouver( courant.getId() );
			if ( courant == null ) {
				UtilJsf.messageError( "L'agrément demandé n'existe pas" );
				return "liste";
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		if ( courant.getId() == null) {
			données.agrementAjouter(courant);
		} else {
			données.agrementModifier(courant);
		}
		UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
		return "liste";
	}
	
	public String supprimer( Agrement item ) {
		données.agrementSupprimer( item.getId() );
		liste.remove(item);
		UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		return null;
	}
	
}
