package democonverter.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import democonverter.model.entities.validation.Normalized;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import net.entetrs.commons.uuid.GeneratedUUID;
import net.entetrs.commons.uuid.UUIDRepresentation;

@SuppressWarnings("serial")
@Dependent
@Entity
@Table(name = "RESTAURANT")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant implements Serializable{

	@Id
	@Inject
	@GeneratedUUID(representation=UUIDRepresentation.HEXA_STRING)
	@Getter
	String id;
	
	@Getter
	@Setter
	String nom;
	
	@Getter
	@Setter
	Integer note;
	
	@Getter
	@Setter
	Date dateNotation;
	
	@Getter
	@Setter
	LocalDate dateReferencement;
	
	@Getter
	@Setter
	@Normalized(message = "Le champ ville doit contenir la chaine \"NORMALIZED\" !!")
	String adresse;

	@Getter
	@Setter
	@OneToOne
	PositionGPS position;
	
	@Getter
	@Setter
	Ville ville; 

}
