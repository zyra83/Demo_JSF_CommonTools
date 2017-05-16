package democonverter.model.entities;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	String adresse;

	@Getter
	@Setter
	@OneToOne
	PositionGPS position;

}
