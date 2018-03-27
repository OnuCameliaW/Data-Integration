package DocMng.Postgres;

import java.util.Arrays;
import java.util.Date;

public class VersionView {
	
	public VersionView() {
		super();
	}
	public VersionView(Integer id, Integer versionNumber, String description, Boolean currentVersion, Date createDate, Byte[] file,
			Integer documentId) {
		super();
		this.id = id;
		this.versionNumber = versionNumber;
		this.description = description;
		this.currentVersion = currentVersion;
		this.createDate = createDate;
		this.file = file;
		this.documentId = documentId;
	}
	private Integer id;
	private Integer versionNumber;
	private String description;
	private Boolean currentVersion;
	private Date createDate;
	private Byte[] file;
	private Integer documentId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(Integer versionNumber) {
		this.versionNumber = versionNumber;
	}
	public String getDescription() {
		return description;
	}
	@Override
	public String toString() {
		return "VersionView [id=" + id + ", versionNumber=" + versionNumber + ", description=" + description
				+ ", currentVersion=" + currentVersion + ", createDate=" + createDate + ", file="
				+ Arrays.toString(file) + ", documentId=" + documentId + "]";
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getCurrentVersion() {
		return currentVersion;
	}
	public void setCurrentVersion(Boolean currentVersion) {
		this.currentVersion = currentVersion;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Byte[] getFile() {
		return file;
	}
	public void setFile(Byte[] file) {
		this.file = file;
	}
	public Integer getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

}
