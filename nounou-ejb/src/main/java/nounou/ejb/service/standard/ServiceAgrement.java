package nounou.ejb.service.standard;

import static nounou.commun.dto.Roles.ADMINISTRATEUR;
import static nounou.commun.dto.Roles.UTILISATEUR;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import nounou.commun.dto.DtoAgrement;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceAgrement;
import nounou.ejb.dao.IDaoAgrement;
import nounou.ejb.dao.IDaoPersonnel;
import nounou.ejb.data.Agrement;
import nounou.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
@RolesAllowed(ADMINISTRATEUR)
public class ServiceAgrement implements IServiceAgrement {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoAgrement daoAgrement;
	@Inject
	private IDaoPersonnel daoPersonnel;

	// Actions

	@Override
	public int inserer(DtoAgrement dtoAgrement) throws ExceptionValidation {
		verifierValiditeDonnees(dtoAgrement);
		int id = daoAgrement.inserer(mapper.map(dtoAgrement));
		return id;
	}

	@Override
	public void modifier(DtoAgrement dtoAgrement) throws ExceptionValidation {
		verifierValiditeDonnees(dtoAgrement);
		daoAgrement.modifier(mapper.map(dtoAgrement));
	}

	@Override
	public void supprimer(int idAgrement) throws ExceptionValidation {
		if (daoPersonnel.compterPourAgrement(idAgrement) != 0) {
			throw new ExceptionValidation("L'agrément n'est pas vide");
		}
		daoAgrement.supprimer(idAgrement);
	}

	@Override
	@RolesAllowed({ ADMINISTRATEUR, UTILISATEUR })
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoAgrement retrouver(int idAgrement) {
		return mapper.map(daoAgrement.retrouver(idAgrement));
	}

	@Override
	@RolesAllowed({ ADMINISTRATEUR, UTILISATEUR })
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoAgrement> listerTout() {
		List<DtoAgrement> liste = new ArrayList<>();
		for (Agrement agrement : daoAgrement.listerTout()) {
			liste.add(mapper.map(agrement));
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoAgrement dtoAgrement) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoAgrement.getLibelle() == null || dtoAgrement.getLibelle().isEmpty()) {
			message.append("\nLe libellé est absent.");
		} else if (dtoAgrement.getLibelle().length() < 3) {
			message.append("\nLe libellé est trop court.");
		} else if (dtoAgrement.getLibelle().length() > 25) {
			message.append("\nLe libellé est trop long.");
		}
		
		if (dtoAgrement.getNombremaxenfants() == 0 || dtoAgrement.getNombremaxenfants() < 0) {
			message.append("\nLe nombre max d'enfants autorisé pour cet agrément  est absent ou invalide.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
