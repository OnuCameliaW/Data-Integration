package DocMng.Xml;

import java.util.List;

public interface UsersViewBuilder {

	UsersViewBuilder build() throws Exception;
	List<UserView> getUsersViewList();
}
