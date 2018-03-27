package DocMng.Xml.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DocMng.Xml.UserView;
import DocMng.Xml.UsersViewBuilder;
import DocMng.Xml.UsersViewBuilderJAXB;
import DocMng.Xml.XMLFileDataSourceConnector;

public class TestUsersView {

	private XMLFileDataSourceConnector fileDataSourceConnector;
	private UsersViewBuilderJAXB xmlViewBuilder;
	/*	private ReservationsTupleViewBuilder tupleViewBuilder;*/
	private UsersViewBuilder viewBuilder;
	
	
	@Before
	public void setUp() throws Exception {
		this.fileDataSourceConnector = new XMLFileDataSourceConnector();
		xmlViewBuilder = new UsersViewBuilderJAXB(fileDataSourceConnector);
	    this.viewBuilder = new UsersViewBuilderJAXB(fileDataSourceConnector);
	}
	@Test
	public void testUsersViewBuilderJAXB() throws Exception{
		
		List<UserView> viewList = this.viewBuilder.build().getUsersViewList();
		System.out.println("==================" + "UsersViewBuilderJAXB Users" + " ======================");
		assertTrue("Get ReservationView Data failed!", viewList.size() > 0);
		for(UserView user: viewList)
			System.out.println(user);
	
		
	}	

}

