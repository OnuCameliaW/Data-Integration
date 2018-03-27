package DocMng.Postgres.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DocMng.Postgres.EmployeeView;
import DocMng.Postgres.EmployeeViewBuilder;
import DocMng.Postgres.PostgresDataSource;
import DocMng.Postgres.PostgresTupleViewBuilder;

public class TestEmployeeView {

	private PostgresDataSource postgresConnector;
	private PostgresTupleViewBuilder postgresPreViewBuilder;
	private EmployeeViewBuilder viewBuilder;
	
	@Before
	public void setUp() throws Exception {
		postgresConnector = new PostgresDataSource();
		postgresPreViewBuilder = new PostgresTupleViewBuilder(postgresConnector);
		viewBuilder = new EmployeeViewBuilder(postgresPreViewBuilder);
	}
	
	
	@Test
	public void testGetEmployee() {
		List<EmployeeView> viewList = viewBuilder.build().getViewList();
		assertTrue("Failures!", viewList.size() > 0);
		
		for(EmployeeView employee: viewList)
			System.out.println(employee);
	}
}
