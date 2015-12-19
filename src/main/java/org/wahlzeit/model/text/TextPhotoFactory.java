package org.wahlzeit.model.text;

import java.util.logging.Logger;
import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.LogBuilder;

public class TextPhotoFactory extends PhotoFactory {

	private static final Logger log = Logger.getLogger(TextPhotoFactory.class.getName());
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static TextPhotoFactory instance = null;
	
	/**
	 * Public singleton access method.
	 */
	public static synchronized TextPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
			setInstance(new TextPhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of PhotoFactory.
	 * @param photoFactory the instance to set.
	 */
	protected static synchronized void setInstance(TextPhotoFactory photoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize PhotoFactory twice");
		}

		instance = photoFactory;
	}
	
	/**
	 * @return new Empty TextPhoto instance
	 * @methodtype factory
	 */
	@Override
	public TextPhoto createPhoto() {
		return new TextPhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 * @param id the PhotoId the Photo shall have
	 * @return new Empty TextPhoto instance with the provided id
	 */
	@Override
	public TextPhoto createPhoto(PhotoId id) {
		return new TextPhoto(id);
	}

}
