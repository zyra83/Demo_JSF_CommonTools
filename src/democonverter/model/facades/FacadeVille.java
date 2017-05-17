package democonverter.model.facades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import democonverter.model.entities.Ville;

@ApplicationScoped
public class FacadeVille implements Serializable {

	private List<Ville> listeVilles;
	
	@PostConstruct // déclenché par CDI
	private void init(){
		
		List <Ville> tmpVilles = new ArrayList<>();
		tmpVilles.add(Ville.builder().nom("Paris").codePostal("75000").build());
		tmpVilles.add(Ville.builder().nom("Marseille").codePostal("13000").build());
		tmpVilles.add(Ville.builder().nom("Rennes").codePostal("33510").build());
		listeVilles = Collections.unmodifiableList(tmpVilles);
	}
	
	public List<Ville> getListeVilles(){
		return listeVilles;
	}
	
}
