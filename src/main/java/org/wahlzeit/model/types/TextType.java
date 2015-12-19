package org.wahlzeit.model.types;

import java.util.ArrayList;
import java.util.List;
import org.wahlzeit.model.text.Text;
import org.wahlzeit.services.DataObject;

public class TextType extends DataObject {

	private String name;
	private String description;
	private String copyrightNotice;
	private final List<Text> instances;

	private TextType superType;

	public TextType(String name, String description, String copyrightNotice) {
		this.name = name;
		this.description = description;
		this.copyrightNotice = copyrightNotice;
		this.superType = null;
		instances = new ArrayList<>();
	}

	public TextType(String name, String description, String copyrightNotice, TextType superType) {
		this.name = name;
		this.description = description;
		this.copyrightNotice = copyrightNotice;
		this.superType = superType;
		instances = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCopyrightNotice() {
		return copyrightNotice;
	}

	public void setCopyrightNotice(String copyrightNotice) {
		this.copyrightNotice = copyrightNotice;
	}

	public TextType getSuperType() {
		return superType;
	}

	public void setSuperType(TextType superType) {
		this.superType = superType;
	}

	public void addInstance(Text text) {
		instances.add(text);
	}

	public List<Text> getInstances() {
		return instances;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof TextType) ? this == obj : false;
	}

}
