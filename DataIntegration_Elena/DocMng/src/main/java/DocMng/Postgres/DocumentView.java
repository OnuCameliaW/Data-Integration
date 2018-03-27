package DocMng.Postgres;

import java.util.Arrays;
import java.util.Date;

public class DocumentView {

	private Integer id;
	private String name;
	private String description;
	private Integer currentVersion;
	private Date createDate;
	private Date modifyDate;
	private Date deleteDate;
	private Byte[] file;
	@Override
	public String toString() {
		return "DocumentView [id=" + id + ", name=" + name + ", description=" + description + ", currentVersion="
				+ currentVersion + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", deleteDate="
				+ deleteDate + ", file=" + Arrays.toString(file) + ", authorId=" + authorId + "]";
	}

	private Integer authorId;
	
	public DocumentView() {
		super();
	}
	
	public DocumentView(Integer id, String name, String description, Integer currentVersion, Date createDate,
			Date modifyDate, Date deleteDate, Byte[] file, Integer authorId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.currentVersion = currentVersion;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.deleteDate = deleteDate;
		this.file = file;
		this.authorId = authorId;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
	
	public Integer getCurrentVersion() {
		return currentVersion;
	}
	
	public void setCurrentVersion(Integer currentVersion) {
		this.currentVersion = currentVersion;
	}
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Date getModifyDate() {
		return modifyDate;
	}
	
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public Date getDeleteDate() {
		return deleteDate;
	}
	
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	
	public Byte[] getFile() {
		return file;
	}
	
	public void setFile(Byte[] file) {
		this.file = file;
	}
	
	public Integer getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
}
