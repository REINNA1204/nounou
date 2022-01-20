package nounou.jsf.model.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import nounou.commun.dto.Roles;
import nounou.jsf.data.Agrement;
import nounou.jsf.data.Compte;
import nounou.jsf.data.Contrat;
import nounou.jsf.data.Parent;
import nounou.jsf.data.Personnel;
import nounou.jsf.data.Suivi;
import nounou.jsf.data.mapper.IMapper;


@SuppressWarnings("serial")
@ApplicationScoped
public class Donnees implements Serializable {

	
    // Champs 

    private final Map<Integer, Compte>  	mapComptes 		= new HashMap<>();
	private final Map<Integer, Agrement>	mapAgrements 	= new HashMap<>();
	private final Map<Integer, Personnel>	mapPersonnels	= new HashMap<>();
	private final Map<Integer, Parent>		mapParents  	= new HashMap<>();
	private final Map<Integer, Contrat>		mapContrats  	= new HashMap<>();
	private final Map<Integer, Suivi>		mapSuivis  	= new HashMap<>();

	//private int 	dernierIdTelephone;
	
	@Inject
	private IMapper	mapper;

	
	// Getters
	
	public List<Agrement> getAgrements() {
		List<Agrement> agrements = new ArrayList<>();
		for ( Agrement agrement : mapAgrements.values() ) {
			agrements.add( mapper.duplicate( agrement ) );
		}
		return agrements;
	}
	
	public List<Compte> getComptes() {
		List<Compte> comptes = new ArrayList<>();
		for ( Compte compte : mapComptes.values() ) {
			comptes.add( mapper.duplicate( compte ) );
		}
		return comptes;
	}
	
	public List<Personnel> getPersonnels() {
		List<Personnel> personnels = new ArrayList<>();
		for ( Personnel personnel : mapPersonnels.values() ) {
			personnels.add( mapper.duplicate( personnel ) );
		}
		return personnels;
	}
	
	public List<Parent> getParents() {
		List<Parent> parents = new ArrayList<>();
		for ( Parent parent : mapParents.values() ) {
			parents.add( mapper.duplicate( parent ) );
		}
		return parents;
	}
	
	public List<Contrat> getContrats() {
		List<Contrat> contrats = new ArrayList<>();
		for ( Contrat contrat : mapContrats.values() ) {
			contrats.add( mapper.duplicate( contrat ) );
		}
		return contrats;
	}
	
	public List<Suivi> getSuivis() {
		List<Suivi> suivis = new ArrayList<>();
		for ( Suivi suivi : mapSuivis.values() ) {
			suivis.add( mapper.duplicate( suivi ) );
		}
		return suivis;
	}
	
	
	// Constructeur
	
	public Donnees() {
		initialiserDonnees();
	}
	
	
	// Actions
	
	public int agrementAjouter( Agrement agrement ) {
		Integer idMax = Collections.max( mapAgrements.keySet() );
		if ( idMax == null ) {
			idMax = 0;
		}
		agrement.setId( idMax + 1 );
		mapAgrements.put( agrement.getId(), mapper.duplicate( agrement ) );
		return agrement.getId();
	}
	public void agrementModifier( Agrement agrement ) {
		mapAgrements.replace( agrement.getId(), mapper.duplicate( agrement ) );
	}
	public void agrementSupprimer( int id ) {
		mapAgrements.remove( id );
	}
	public Agrement agrementRetrouver( int id ) {
		return mapper.duplicate( mapAgrements.get( id ) );
	}
	
	public int compteAjouter( Compte compte ) {
		Integer idMax = Collections.max( mapComptes.keySet() );
		if ( idMax == null ) {
			idMax = 0;
		}
		compte.setId( idMax + 1 );
		mapComptes.put( compte.getId(), mapper.duplicate( compte ) );
		return compte.getId();
	}
	public void compteModifier( Compte compte ) {
		mapComptes.replace( compte.getId(), mapper.duplicate( compte ) );
	}
	public void compteSupprimer( int id ) {
		mapComptes.remove( id );
	}
	public Compte compteRetrouver( int id ) {
		return mapper.duplicate( mapComptes.get( id ) );
	}
	
	public int personnelAjouter( Personnel personnel ) {
		Integer idMax = Collections.max( mapPersonnels.keySet() );
		if ( idMax == null ) {
			idMax = 0;
		}
		personnel.setId( idMax + 1 );
		//affecterIdTelephones(personne);
		mapPersonnels.put( personnel.getId(), mapper.duplicate( personnel ) );
		return personnel.getId();
	}
	public void personnelModifier( Personnel personnel ) {
		mapPersonnels.replace( personnel.getId(), mapper.duplicate( personnel ) );
	}
	public void personnelSupprimer( int id ) {
		mapPersonnels.remove( id );
	}
	public Personnel personnelRetrouver( int id ) {
		return mapper.duplicate( mapPersonnels.get( id ) );
	}
	
	public int parentAjouter( Parent parent ) {
		Integer idMax = Collections.max( mapParents.keySet() );
		if ( idMax == null ) {
			idMax = 0;
		}
		parent.setId( idMax + 1 );
		mapParents.put( parent.getId(), mapper.duplicate( parent ) );
		return parent.getId();
	}
	public void parentModifier( Parent parent ) {
		mapParents.replace( parent.getId(), mapper.duplicate( parent ) );
	}
	public void parentSupprimer( int id ) {
		mapParents.remove( id );
	}
	public Parent parentRetrouver( int id ) {
		return mapper.duplicate( mapParents.get( id ) );
	}
	
	public int contratAjouter( Contrat contrat ) {
		Integer idMax = Collections.max( mapContrats.keySet() );
		if ( idMax == null ) {
			idMax = 0;
		}
		contrat.setId( idMax + 1 );
		mapContrats.put( contrat.getId(), mapper.duplicate( contrat ) );
		return contrat.getId();
	}
	public void contratModifier( Contrat contrat ) {
		mapContrats.replace( contrat.getId(), mapper.duplicate( contrat ) );
	}
	public void contratSupprimer( int id ) {
		mapContrats.remove( id );
	}
	public Contrat contratRetrouver( int id ) {
		return mapper.duplicate( mapContrats.get( id ) );
	}
	
	public int suiviAjouter( Suivi suivi ) {
		Integer idMax = Collections.max( mapSuivis.keySet() );
		if ( idMax == null ) {
			idMax = 0;
		}
		suivi.setId( idMax + 1 );
		mapSuivis.put( suivi.getId(), mapper.duplicate( suivi ) );
		return suivi.getId();
	}
	public void suiviModifier( Suivi suivi ) {
		mapSuivis.replace( suivi.getId(), mapper.duplicate( suivi ) );
	}
	public void suiviSupprimer( int id ) {
		mapSuivis.remove( id );
	}
	public Suivi suiviRetrouver( int id ) {
		return mapper.duplicate( mapSuivis.get( id ) );
	}

	
	// Méthodes auxiliaires

	private void initialiserDonnees() {
		
		
		// Comptes
		
		Compte compte;
		compte = new Compte( 1, "geek", "geek", "geek@3il.fr" );
		compte.getRoles().add( Roles.ADMINISTRATEUR  );
		compte.getRoles().add( Roles.UTILISATEUR  );
		mapComptes.put( compte.getId(), compte );

		compte = new Compte(2, "chef", "chef", "chef@3il.fr");
		compte.getRoles().add( Roles.UTILISATEUR  );
		mapComptes.put( compte.getId(), compte );
		
		compte = new Compte( 3, "job", "job", "job@3il.fr" );
		compte.getRoles().add( Roles.UTILISATEUR  );
		mapComptes.put( compte.getId(), compte );

		compte = new Compte(4, "_" + this.getClass().getPackage().getName(), "xxx", "xxx@3il.fr");
		compte.getRoles().add( Roles.UTILISATEUR  );
		mapComptes.put( compte.getId(), compte );

		
		// Agréments
	
		Agrement agrement;
		agrement =  new Agrement( 1, "CTA-2", 10 );
		mapAgrements.put( agrement.getId(), agrement );
		agrement =  new Agrement( 2, "CTA-3", 15 );
    	mapAgrements.put( agrement.getId(), agrement );
	
	}
}
