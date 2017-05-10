package democonverter.model.entities;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
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
@Table(name = "POSITION_GPS")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NamedQuery(name = "READ_ALL_POSITIONS", query = "SELECT p FROM PositionGPS p ORDER BY p.lat, p.lon")
@NoArgsConstructor
@AllArgsConstructor
public class PositionGPS implements Serializable {

	@Id
	@Inject
	@GeneratedUUID(representation = UUIDRepresentation.HEXA_STRING)
	@Getter
	String id;

	@Getter
	@Setter
	double lat;

	@Getter
	@Setter
	double lon;

}
