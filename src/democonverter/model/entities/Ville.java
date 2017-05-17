package democonverter.model.entities;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import net.entetrs.commons.uuid.GeneratedUUID;
import net.entetrs.commons.uuid.UUIDRepresentation;

/**
 * Entity implementation class for Entity: Ville
 *
 */
@SuppressWarnings("serial")

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Ville implements Serializable {

	@Id
	@Inject
	@GeneratedUUID(representation = UUIDRepresentation.HEXA_STRING)
	@Getter
	String nom;

	@Getter
	@Setter
	String codePostal;

   
}
