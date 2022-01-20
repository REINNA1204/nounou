package nounou.jsf.model.mock;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import nounou.jsf.data.Contrat;
import nounou.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelContrat implements Serializable {

	
	// Champs
	
	private List<Contrat>		liste;
	
	private Contrat			courant;
	
	@Inject
	private Donnees				données;

	
	// Getters
	
	public List<Contrat> getListe() {
		if ( liste == null ) {
			liste = données.getContrats();
		}
		return liste;
	}

	public Contrat getCourant() {
		if ( courant == null ) {
			courant = new Contrat();
		}
		return courant;
	}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			courant = données.contratRetrouver( courant.getId() );
			if ( courant == null ) {
				UtilJsf.messageError( "Le contrat demandée n'existe pas" );
				return "liste";
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		if ( courant.getId() == null) {
			données.contratAjouter(courant);
		} else {
			données.contratModifier(courant);
		}
		UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
		return "liste";
	}
	
	public String supprimer( Contrat item ) {
		données.contratSupprimer( item.getId() );
		liste.remove(item);
		UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		return null;
	}
	
}
