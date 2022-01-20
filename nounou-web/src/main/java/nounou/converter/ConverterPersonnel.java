package nounou.converter;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import nounou.jsf.data.Personnel;

@Named
@RequestScoped
public class ConverterPersonnel implements Converter<Personnel> {

	// Actions

	@SuppressWarnings("unchecked")
	@Override
	public Personnel getAsObject(FacesContext context, UIComponent uic, String value) {

		if (value == null || value.isEmpty()) {
			return null;
		}

		List<Personnel> items = null;
		for (UIComponent c : uic.getChildren()) {
			if (c instanceof UISelectItems) {
				items = (List<Personnel>) ((UISelectItems) c).getValue();
				break;
			}
		}

		var id = Integer.valueOf("x"+value);
		for (Personnel item : items) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Personnel item) {

		if (item == null) {
			return "";
		}
		return String.valueOf(item.getId());
	}
}
