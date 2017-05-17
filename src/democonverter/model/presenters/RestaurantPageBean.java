package democonverter.model.presenters;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.spi.CDI;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import democonverter.model.dao.DaoRestaurantJPA;
import democonverter.model.entities.Restaurant;
import democonverter.model.entities.Ville;
import democonverter.model.facades.FacadeVille;
import lombok.Getter;
import lombok.Setter;
import net.entetrs.commons.jsf.JsfUtils;

@SuppressWarnings("serial")
@Named
@ViewScoped // reste la même vue tant qu'il y a des probelems de saisie pour
			// l'utilisateur
//@ManagedBean
public class RestaurantPageBean implements Serializable {
	@Getter
	@Setter
	private String text;

	@Inject
	private DaoRestaurantJPA daoRestaurant;

	@Inject
	@Getter // pour y acceder depuis la page web
	private Restaurant nouveauRestaurant;
	
	
	@Inject
	FacadeVille facadeVille;
	
	
	/**
	 * Tape sur la facade injectée
	 */
	public List<Ville> getListeVilles(){
		return facadeVille.getListeVilles();
	}
	

	public void ajouterRestaurant() {
		daoRestaurant.create(nouveauRestaurant);
		// grace à CDI remet un paquet neuf
		nouveauRestaurant = CDI.current().select(Restaurant.class).get();
		// TODO envoyer un message de succes JSF

		// Version OLD SCHOOL
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("A POIL DE ZONE !!"));
		// Version Utilisatire ETRS
		JsfUtils.sendMessage("Ajout d'un restaurant OK");

	}

	public List<Restaurant> listerRestaurants() {
		return daoRestaurant.readAll();
	}

	public void suppression(Restaurant r) {
		daoRestaurant.delete(r);
	}

	public void validerAdresseRestaurant(FacesContext ctx, UIComponent cmp, Object value) {
		if (value != null && (value instanceof String)) {
			String address = StringUtils.stripAccents((String) value);

			for (TypeVoie str : TypeVoie.values()) {
				if (StringUtils.containsIgnoreCase(address, str.toString())) {
					return; // sort silencieusement
				}
			}

		}

	}

	public enum TypeVoie {
		RUE, ALLEE, AVENUE;
	}

}
