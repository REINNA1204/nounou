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

import nounou.commun.dto.DtoSuivi;
import nounou.commun.exception.ExceptionValidation;
import nounou.commun.service.IServiceSuivi;
import nounou.ejb.dao.IDaoSuivi;
import nounou.ejb.data.Suivi;
import nounou.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
@RolesAllowed({ ADMINISTRATEUR })
public class ServiceSuivi implements IServiceSuivi {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoSuivi daoSuivi;

	// Actions

	@Override
	public int inserer(DtoSuivi dtoSuivi) throws ExceptionValidation {
		verifierValiditeDonnees(dtoSuivi);
		int id = daoSuivi.inserer(mapper.map(dtoSuivi));
		return id;
	}

	@Override
	public void modifier(DtoSuivi dtoSuivi) throws ExceptionValidation {
		verifierValiditeDonnees(dtoSuivi);
		daoSuivi.modifier(mapper.map(dtoSuivi));
	}

	@Override
	public void supprimer(int idSuivi) throws ExceptionValidation {
		daoSuivi.supprimer(idSuivi);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoSuivi retrouver(int idSuivi) {
		Suivi suivi = daoSuivi.retrouver(idSuivi);
		return mapper.map(suivi);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoSuivi> listerTout() {
		List<DtoSuivi> liste = new ArrayList<>();
		for (Suivi suivi : daoSuivi.listerTout()) {
			liste.add( mapper.map(suivi) );
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoSuivi dtoSuivi) throws ExceptionValidation {

		
	}

}
