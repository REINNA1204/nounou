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

import nounou.commun.dto.DtoContrat;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceContrat;
import nounou.ejb.dao.IDaoContrat;
import nounou.ejb.data.Contrat;
import nounou.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
@RolesAllowed({ ADMINISTRATEUR })
public class ServiceContrat implements IServiceContrat {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoContrat daoContrat;

	// Actions

	@Override
	public int inserer(DtoContrat dtoContrat) throws ExceptionValidation {
		verifierValiditeDonnees(dtoContrat);
		int id = daoContrat.inserer(mapper.map(dtoContrat));
		return id;
	}

	@Override
	public void modifier(DtoContrat dtoContrat) throws ExceptionValidation {
		verifierValiditeDonnees(dtoContrat);
		daoContrat.modifier(mapper.map(dtoContrat));
	}

	@Override
	public void supprimer(int idContrat) throws ExceptionValidation {
		daoContrat.supprimer(idContrat);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoContrat retrouver(int idContrat) {
		Contrat contrat = daoContrat.retrouver(idContrat);
		return mapper.map(contrat);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoContrat> listerTout() {
		List<DtoContrat> liste = new ArrayList<>();
		for (Contrat contrat : daoContrat.listerTout()) {
			liste.add( mapper.map(contrat) );
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoContrat dtoContrat) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoContrat.getNomenfant() == null || dtoContrat.getNomenfant().isEmpty()) {
			message.append("\nLe nom de l'enfant est absent.");
		} else if (dtoContrat.getNomenfant().length() > 25) {
			message.append("\nLe nom de l'enfant est trop long.");
		}

		if (dtoContrat.getPrenomenfant() == null || dtoContrat.getPrenomenfant().isEmpty()) {
			message.append("\nLe prénom de l'enfant est absent.");
		} else if (dtoContrat.getPrenomenfant().length() > 25) {
			message.append("\nLe prénom de l'enfant est trop long.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
