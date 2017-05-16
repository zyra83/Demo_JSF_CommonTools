package demobeanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import democonverter.model.entities.PositionGPS;
import democonverter.model.entities.Restaurant;

public class TestBeanUtils {

	/**
	 * Test de la fonction describe qui ramene tous les champs ayant un get et
	 * bosse par introspection.
	 */
	@Test
	public void test() {
		Restaurant r = new Restaurant();
		r.setAdresse("adress");
		r.setNom("Resto");
		r.setNote(10);
		r.setPosition(new PositionGPS("id", 10, 10));

		Map<String, String> desc;
		try {
			desc = BeanUtils.describe(r);
			desc.forEach((a, b) -> {
				System.out.printf("%s %s%n", a, b);
			});
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
