package democonverter.model.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import democonverter.model.entities.PositionGPS;
import net.entetrs.commons.jpa.AbstractDaoEntrepriseEdition;

@Stateless
@LocalBean
public class DaoPositionGPSJPA extends AbstractDaoEntrepriseEdition<PositionGPS> {
	@PersistenceContext
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
