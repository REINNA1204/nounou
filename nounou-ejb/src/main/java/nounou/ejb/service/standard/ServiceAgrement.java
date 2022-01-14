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
	private IDaoAgrement daoCategorie;
	@Inject
	private IDaoPersonnel daoPersonne;

	// Actions

	@Override
	public int inserer(DtoAgrement dtoCategorie) throws ExceptionValidation {
		verifierValiditeDonnees(dtoCategorie);
		int id = daoCategorie.inserer(mapper.map(dtoCategorie));
		return id;
	}

	@Override
	public void modifier(DtoAgrement dtoCategorie) throws ExceptionValidation {
		verifierValiditeDonnees(dtoCategorie);
		daoCategorie.modifier(mapper.map(dtoCategorie));
	}

	@Override
	public void supprimer(int idCategorie) throws ExceptionValidation {
		if (daoPersonne.compterPourCategorie(idCategorie) != 0) {
			throw new ExceptionValidation("La catégorie n'est pas vide");
		}
		daoCategorie.supprimer(idCategorie);
	}

	@Override
	@RolesAllowed({ ADMINISTRATEUR, UTILISATEUR })
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoAgrement retrouver(int idCategorie) {
		return mapper.map(daoCategorie.retrouver(idCategorie));
	}

	@Override
	@RolesAllowed({ ADMINISTRATEUR, UTILISATEUR })
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoAgrement> listerTout() {
		List<DtoAgrement> liste = new ArrayList<>();
		for (Agrement categorie : daoCategorie.listerTout()) {
			liste.add(mapper.map(categorie));
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoAgrement dtoCategorie) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoCategorie.getLibelle() == null || dtoCategorie.getLibelle().isEmpty()) {
			message.append("\nLe libellé est absent.");
		} else if (dtoCategorie.getLibelle().length() < 3) {
			message.append("\nLe libellé est trop court.");
		} else if (dtoCategorie.getLibelle().length() > 25) {
			message.append("\nLe libellé est trop long.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
