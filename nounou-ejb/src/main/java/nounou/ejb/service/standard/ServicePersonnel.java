package nounou.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;
import static nounou.commun.dto.Roles.ADMINISTRATEUR;
import static nounou.commun.dto.Roles.UTILISATEUR;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import nounou.commun.dto.DtoPersonnel;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServicePersonnel;
import nounou.ejb.dao.IDaoPersonnel;
import nounou.ejb.data.Personnel;
import nounou.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
@RolesAllowed({ ADMINISTRATEUR, UTILISATEUR })
public class ServicePersonnel implements IServicePersonnel {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoPersonnel daoPersonne;

	// Actions

	@Override
	public int inserer(DtoPersonnel dtoPersonne) throws ExceptionValidation {
		verifierValiditeDonnees(dtoPersonne);
		int id = daoPersonne.inserer(mapper.map(dtoPersonne));
		return id;
	}

	@Override
	public void modifier(DtoPersonnel dtoPersonne) throws ExceptionValidation {
		verifierValiditeDonnees(dtoPersonne);
		daoPersonne.modifier(mapper.map(dtoPersonne));
	}

	@Override
	public void supprimer(int idPersonne) throws ExceptionValidation {
		daoPersonne.supprimer(idPersonne);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoPersonnel retrouver(int idPersonne) {
		Personnel personne = daoPersonne.retrouver(idPersonne);
		return mapper.map(personne);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoPersonnel> listerTout() {
		List<DtoPersonnel> liste = new ArrayList<>();
		for (Personnel personne : daoPersonne.listerTout()) {
			liste.add( mapper.mapMinimal(personne) );
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoPersonnel dtoPersonne) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoPersonne.getNom() == null || dtoPersonne.getNom().isEmpty()) {
			message.append("\nLe nom est absent.");
		} else if (dtoPersonne.getNom().length() > 25) {
			message.append("\nLe nom est trop long.");
		}

		if (dtoPersonne.getPrenom() == null || dtoPersonne.getPrenom().isEmpty()) {
			message.append("\nLe prénom est absent.");
		} else if (dtoPersonne.getPrenom().length() > 25) {
			message.append("\nLe prénom est trop long.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
