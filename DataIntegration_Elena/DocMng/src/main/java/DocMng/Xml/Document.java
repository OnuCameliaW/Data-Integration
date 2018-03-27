package DocMng.Xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="document")
public class Document {
	
	public Document() {
		super();
	}
	
	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", documentName=" + documentName + "]";
	}

	public Document(Integer documentId, String documentName) {
		super();
		this.documentId = documentId;
		this.documentName = documentName;
	}
	
	private Integer documentId;
	private String documentName;
	
	@XmlElement(name="documentId")
	public Integer getDocumentId() {
		return documentId;
	}
	
	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}
	
	@XmlElement(name="documentName")
	public String getDocumentName() {
		return documentName;
	}
	
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
}
