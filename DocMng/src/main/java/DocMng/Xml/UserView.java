package DocMng.Xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class UserView {

	public UserView() {
		super();
	}
	public UserView(Integer id, String userName, List<Claim> claims) {
		super();
		this.id = id;
		this.userName = userName;
		this.claims = claims;
	}
	private Integer id;
	private String userName;
	private List<Claim> claims;
	
	@XmlElement(name="id")
	public Integer getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "UserView [id=" + id + ", userName=" + userName + ", claims=" + claims + "]";
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@XmlElement(name="userName")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@XmlElement(name="claims")
	public List<Claim> getClaims() {
		return claims;
	}
	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}
}


