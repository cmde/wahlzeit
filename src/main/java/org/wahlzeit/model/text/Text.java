package org.wahlzeit.model.text;

import com.google.api.client.util.DateTime;
import java.util.ArrayList;
import java.util.List;
import org.wahlzeit.model.types.ProductionType;
import org.wahlzeit.model.types.TextType;

public class Text {

	private ProductionType productionType;
	private TextType textType;
	private DateTime createdAt;
	private List<String> languageCodes;

	protected Text(TextType textType, ProductionType productionType) {
		languageCodes = new ArrayList<>();
		this.textType = textType;
		this.productionType = productionType;
	}

	public TextType getTextType() {
		return textType;
	}

	public void setTextType(TextType textType) {
		this.textType = textType;
	}

	public ProductionType getProductionType() {
		return productionType;
	}

	public void setProductionType(ProductionType productionType) {
		this.productionType = productionType;
	}

	public List<String> getLanguageCodes() {
		return languageCodes;
	}

	public void setLanguageCodes(List<String> langugaeCodes) {
		this.languageCodes = langugaeCodes;
	}

	public void addLanguageCode(String languageCode) {
		languageCodes.add(languageCode);
	}
	
	public DateTime getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	

}
