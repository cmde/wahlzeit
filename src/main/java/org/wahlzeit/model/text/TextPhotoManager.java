package org.wahlzeit.model.text;

import org.wahlzeit.model.PhotoManager;

public class TextPhotoManager extends PhotoManager {

	protected static final TextPhotoManager instance = new TextPhotoManager();

	public TextPhotoManager() {
		photoTagCollector = TextPhotoFactory.getInstance().createPhotoTagCollector();
	}

}
