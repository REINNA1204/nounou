package nounou.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;
import static nounou.commun.dto.Roles.ADMINISTRATEUR;

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
@RolesAllowed({ ADMINISTRATEUR })
public class ServicePersonnel implements IServicePersonnel {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoPersonnel daoPersonnel;

	// Actions

	@Override
	public int inserer(DtoPersonnel dtoPersonne) throws ExceptionValidation {
		verifierValiditeDonnees(dtoPersonne);
		int id = daoPersonnel.inserer(mapper.map(dtoPersonne));
		return id;
	}

	@Override
	public void modifier(DtoPersonnel dtoPersonnel) throws ExceptionValidation {
		verifierValiditeDonnees(dtoPersonnel);
		daoPersonnel.modifier(mapper.map(dtoPersonnel));
	}

	@Override
	public void supprimer(int idPersonnel) throws ExceptionValidation {
		daoPersonnel.supprimer(idPersonnel);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoPersonnel retrouver(int idPersonnel) {
		Personnel personnel = daoPersonnel.retrouver(idPersonnel);
		return mapper.map(personnel);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoPersonnel> listerTout() {
		List<DtoPersonnel> liste = new ArrayList<>();
		for (Personnel personnel : daoPersonnel.listerTout()) {
			liste.add( mapper.mapMinimal(personnel) );
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoPersonnel dtoPersonnel) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoPersonnel.getNom() == null || dtoPersonnel.getNom().isEmpty()) {
			message.append("\nLe nom est absent.");
		} else if (dtoPersonnel.getNom().length() > 25) {
			message.append("\nLe nom est trop long.");
		}

		if (dtoPersonnel.getPrenom() == null || dtoPersonnel.getPrenom().isEmpty()) {
			message.append("\nLe prénom est absent.");
		} else if (dtoPersonnel.getPrenom().length() > 25) {
			message.append("\nLe prénom est trop long.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
