package DocMng.Xml;

import java.io.File;

public class XMLFileDataSourceConnector {
	private String XMLFilePath;

	public XMLFileDataSourceConnector() {
		super();
		this.XMLFilePath  = "src/main/resources/users.xml";
	}

	public XMLFileDataSourceConnector(String xMLFilePath) {
		super();
		XMLFilePath = xMLFilePath;
	}

	public File getXMLFile() throws Exception {
		File inputFile = new File(XMLFilePath);
		return inputFile;
	}

}
