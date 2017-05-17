package democonverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = LocalDate.class)
public class LocalDateConverter implements Converter {
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		try {
			return LocalDate.parse(value, formatter);
		} catch (DateTimeParseException e) {
			throw new ConverterException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Entrée non valide", "c'est pas une date..."));
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && value instanceof LocalDate) {
			return formatter.format((LocalDate) value);
		}
		return "";

	}

}
