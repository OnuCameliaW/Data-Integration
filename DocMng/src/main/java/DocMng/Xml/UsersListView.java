package DocMng.Xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="users")
public class UsersListView {

	List<UserView> users = new ArrayList<>();

	@XmlElement(name="user")
	public List<UserView> getUsers() {
		return users;
	}

	public void setUsers(List<UserView> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UsersListView [users=" + users + "]";
	}
}
