package DocMng.Xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class JAXBDataRender {

	public void readXMLData() throws Exception {
		JAXBFileDataSourceConnector dataSourceConnector = new JAXBFileDataSourceConnector();
		File xmlFile = dataSourceConnector.getXMLFile();
		//
		JAXBContext jaxbContext = JAXBContext.newInstance(UsersListView.class );
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		// JSON File
		// jaxbUnmarshaller.setProperty(MarshallerProperties.MEDIA_TYPE,"application/json");
		// jaxbUnmarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
		
		UsersListView reservations = (UsersListView) jaxbUnmarshaller.unmarshal(xmlFile);
		//
		System.out.println(reservations);
	}
}

class JAXBFileDataSourceConnector {
	private String XMLFilePath;
	
		public File getXMLFile() throws Exception {
		File inputFile = new File(XMLFilePath);
		return inputFile;
	}

	public JAXBFileDataSourceConnector(String xMLFilePath) {
		super();
		XMLFilePath = xMLFilePath;
	}

	public JAXBFileDataSourceConnector() {
		super();
		this.XMLFilePath = "src/main/resources/users.xml";
	}
	
	
}