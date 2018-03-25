package DocMng.Xml;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class UsersViewBuilderJAXB implements UsersViewBuilder{

	private UsersListView UsersListView;
	private List<UserView> UsersViewList;

	
	public List<UserView> getUsersViewList() {
		return UsersViewList;
	}
	
	private XMLFileDataSourceConnector dataSourceConnector;
	private File xmlFile;
	
	public UsersViewBuilderJAXB (XMLFileDataSourceConnector dataSourceConnector)  throws Exception {
		dataSourceConnector = new XMLFileDataSourceConnector();
		this.dataSourceConnector = dataSourceConnector;
		xmlFile = dataSourceConnector.getXMLFile();
	}

 	// Builder Workflow
	public UsersViewBuilderJAXB build() throws Exception{
		return this.select().map();
	}
		
		
	private UsersViewBuilderJAXB map() {
		this.UsersViewList = this.UsersListView.getUsers();	
		return this;
	}

	public UsersViewBuilderJAXB select() throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(UsersListView.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		this.UsersListView = (UsersListView) jaxbUnmarshaller.unmarshal(xmlFile);		
		return this;
	}
}
