package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.List;
import org.wahlzeit.enums.PhotoType;
import org.wahlzeit.enums.TextProductionType;

public class TextPhoto extends Photo {

	private TextProductionType textProductionType;
	private PhotoType photoType;
	private String title;
	private List<String> languageCodes;

	public TextPhoto() {
		super();
		languageCodes = new ArrayList<>();
	}
	public TextPhoto(PhotoId myId) {
		super(myId);
		languageCodes = new ArrayList<>();
	}

	public TextProductionType getTextProductionType() {
		return textProductionType;
	}

	public void setTextProductionType(TextProductionType textProductionType) {
		this.textProductionType = textProductionType;
	}

	public PhotoType getPhotoType() {
		return photoType;
	}

	public void setPhotoType(PhotoType photoType) {
		this.photoType = photoType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

}
