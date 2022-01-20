package nounou.jsf.model.mock;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounou.jsf.data.Parent;
import nounou.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelParent implements Serializable {

	
	// Champs
	
	private List<Parent>		liste;
	
	private Parent			courant;
	
	@Inject
	private Donnees				données;

	
	// Getters
	
	public List<Parent> getListe() {
		if ( liste == null ) {
			liste = données.getParents();
		}
		return liste;
	}

	public Parent getCourant() {
		if ( courant == null ) {
			courant = new Parent();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			courant = données.parentRetrouver( courant.getId() );
			if ( courant == null ) {
				UtilJsf.messageError( "Le parent demandé n'existe pas" );
				return "liste";
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		if ( courant.getId() == null) {
			données.compteAjouter(courant.getCompte());
			données.parentAjouter(courant);
		} else {
			données.parentModifier(courant);
		}
		UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
		return "liste";
	}
	
	public String supprimer( Parent item ) {
		données.parentSupprimer( item.getId() );
		données.compteSupprimer(item.getCompte().getId());
		liste.remove(item);
		UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		return null;
	}
	
}
