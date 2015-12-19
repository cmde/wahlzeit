package org.wahlzeit.model.text;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

public class TextPhoto extends Photo {

	private Text text;
	private String title;

	public TextPhoto() {
		super();
	}

	public TextPhoto(PhotoId myId) {
		super(myId);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Text getText() {
		return text;
	}
	
	public void setText(Text text) {
		this.text = text;
	}

}
