package democonverter.model.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import democonverter.model.entities.Restaurant;
import net.entetrs.commons.jpa.AbstractDaoEntrepriseEdition;

@Stateless
@LocalBean
public class DaoRestaurantJPA extends AbstractDaoEntrepriseEdition<Restaurant> {
	@PersistenceContext
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
