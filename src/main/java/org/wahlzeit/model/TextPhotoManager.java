package org.wahlzeit.model;

public class TextPhotoManager extends PhotoManager {

	protected static final TextPhotoManager instance = new TextPhotoManager();

	public TextPhotoManager() {
		photoTagCollector = TextPhotoFactory.getInstance().createPhotoTagCollector();
	}

}
