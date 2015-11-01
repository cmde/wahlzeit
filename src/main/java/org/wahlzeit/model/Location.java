package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Location extends DataObject {

	@Id
	private String name;

	public Coordinate coordinate;

	public Location(String name) {
		this.name = name;
	}

	public Location() {

	}

}
