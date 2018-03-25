package DocMng.Xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rights")
public class Rights {

	public Rights() {
		super();
	}
	@Override
	public String toString() {
		return "Rights [readRight=" + readRight + ", modifyRight=" + modifyRight + ", deleteRight=" + deleteRight + "]";
	}
	public Rights(Boolean readRight, Boolean modifyRight, Boolean deleteRight) {
		super();
		this.readRight = readRight;
		this.modifyRight = modifyRight;
		this.deleteRight = deleteRight;
	}
	
	private Boolean readRight;
	private Boolean modifyRight;
	private Boolean deleteRight;
	
	@XmlElement(name="readRight")
	public Boolean getReadRight() {
		return readRight;
	}
	
	public void setReadRight(Boolean readRight) {
		this.readRight = readRight;
	}
	
	@XmlElement(name="modifyRight")
	public Boolean getModifyRight() {
		return modifyRight;
	}
	
	public void setModifyRight(Boolean modifyRight) {
		this.modifyRight = modifyRight;
	}
	
	@XmlElement(name="deleteRight")
	public Boolean getDeleteRight() {
		return deleteRight;
	}
	
	public void setDeleteRight(Boolean deleteRight) {
		this.deleteRight = deleteRight;
	}

}
