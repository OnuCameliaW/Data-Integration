package DocMng.Xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="claim")
public class Claim {

	public Claim() {
		super();
	}
	
	public Claim(Integer id, Document document, Rights rights) {
		super();
		this.id = id;
		this.document = document;
		this.rights = rights;
	}
	
	private Integer id;
	private Document document;
	private Rights rights;
	
	@XmlElement(name="id")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Claim [id=" + id + ", document=" + document + ", rights=" + rights + "]";
	}

	@XmlElement(name="document")
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	
	@XmlElement(name="rights")
	public Rights getRights() {
		return rights;
	}
	public void setRights(Rights rights) {
		this.rights = rights;
	}
}
