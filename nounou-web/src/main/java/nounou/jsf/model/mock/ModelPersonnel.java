package nounou.jsf.model.mock;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounou.jsf.data.Personnel;
import nounou.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelPersonnel implements Serializable {

	
	// Champs
	
	private List<Personnel>		liste;
	
	private Personnel			courant;
	
	@Inject
	private Donnees				données;

	
	// Getters
	
	public List<Personnel> getListe() {
		if ( liste == null ) {
			liste = données.getPersonnels();
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
			courant = données.personnelRetrouver( courant.getId() );
			if ( courant == null ) {
				UtilJsf.messageError( "Le personnel demandée n'existe pas" );
				return "liste";
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		if ( courant.getId() == null) {
			données.compteAjouter(courant.getCompte());
			données.personnelAjouter(courant);
		} else {
			données.personnelModifier(courant);
		}
		UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
		return "liste";
	}
	
	public String supprimer( Personnel item ) {
		données.personnelSupprimer( item.getId() );
		données.compteSupprimer(item.getCompte().getId());
		liste.remove(item);
		UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		return null;
	}
	
}
