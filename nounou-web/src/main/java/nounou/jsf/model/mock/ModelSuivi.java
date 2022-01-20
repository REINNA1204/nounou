package nounou.jsf.model.mock;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounou.jsf.data.Suivi;
import nounou.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelSuivi implements Serializable {

	
	// Champs
	
	private List<Suivi>		liste;
	
	private Suivi			courant;
	
	@Inject
	private Donnees				données;

	
	// Getters
	
	public List<Suivi> getListe() {
		if ( liste == null ) {
			liste = données.getSuivis();
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
			courant = données.suiviRetrouver( courant.getId() );
			if ( courant == null ) {
				UtilJsf.messageError( "Le suivi demandée n'existe pas" );
				return "liste";
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		if ( courant.getId() == null) {
			données.suiviAjouter(courant);
		} else {
			données.suiviModifier(courant);
		}
		UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
		return "liste";
	}
	
	public String supprimer( Suivi item ) {
		données.suiviSupprimer( item.getId() );
		liste.remove(item);
		UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		return null;
	}
	
}
