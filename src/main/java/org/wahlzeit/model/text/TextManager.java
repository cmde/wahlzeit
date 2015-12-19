package org.wahlzeit.model.text;

import java.util.HashMap;
import org.wahlzeit.model.types.ProductionType;
import org.wahlzeit.model.types.TextType;

public class TextManager {

	private final HashMap<String, TextType> textTypes;

	public TextManager() {
		textTypes = new HashMap<>();
	}

	public Text createText(TextType textType, ProductionType productionType) {
		assert (textType != null) : "You can't create a Text without a TextType!";
		Text newText = new Text(textType, productionType);
		textType.addInstance(newText);
		return newText;
	}

	public TextType createTextType(String name, String description, String copyrightNotice) {
		if (!textTypes.containsKey(name)) {
			TextType tmp = new TextType(name, description, copyrightNotice);
			textTypes.put(name, tmp);
		}
		return textTypes.get(name);
	}

}
