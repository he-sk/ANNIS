package annis.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import annis.model.AnnisNode.TextMatching;

public class Annotation implements Comparable<Annotation>, Serializable {
	
	// this class is sent to the front end
	private static final long serialVersionUID = -7594536903324312228L;
	
	private String namespace;
	private String name;
	private String value;
	private TextMatching textMatching;
	
	public Annotation(String namespace, String name) {
		this(namespace, name, null, null);
	}
	
	public Annotation(String namespace, String name, String value) {
		this(namespace, name, value, TextMatching.EXACT);
	}
	
	public Annotation(String namespace, String name, String value, TextMatching textMatching) {
		this.namespace = namespace;
		this.name = name;
		this.value = value;
		this.textMatching = textMatching;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(AnnisNode.qName(namespace, name));
		if (value != null) {
			sb.append(" ");
			sb.append(textMatching);
			sb.append(" ");
			sb.append(value);
		}
		return sb.toString();
	}

	public int compareTo(Annotation o) {
		String name1 = getQualifiedName();
		String name2 = o.getQualifiedName();
		return name1.compareTo(name2);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Annotation))
			return false;

		Annotation other = (Annotation) obj;
		
		return new EqualsBuilder()
			.append(this.namespace, other.namespace)
			.append(this.name, other.name)
			.append(this.value, other.value)
			.append(this.textMatching, other.textMatching)
			.isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(namespace).append(name).append(value).append(textMatching).toHashCode();
	}
	
	///// Getter / Setter
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public TextMatching getTextMatching() {
		return textMatching;
	}

	public void setTextMatching(TextMatching textMatching) {
		this.textMatching = textMatching;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getQualifiedName() {
		return AnnisNode.qName(namespace, name);
	}
	
}