package DocMng.Postgres.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import DocMng.Postgres.PostgresDataSource;
import DocMng.Postgres.PostgresTupleViewBuilder;
import DocMng.Postgres.VersionView;
import DocMng.Postgres.VersionViewBuilder;

public class TestVersionView {

	private PostgresDataSource postgresConnector;
	private PostgresTupleViewBuilder postgresPreViewBuilder;
	private VersionViewBuilder viewBuilder;
	
	@Before
	public void setUp() throws Exception {
		postgresConnector = new PostgresDataSource();
		postgresPreViewBuilder = new PostgresTupleViewBuilder(postgresConnector);
		viewBuilder = new VersionViewBuilder(postgresPreViewBuilder);
	}
	
	
	@Test
	public void testGetVersion() {
		List<VersionView> viewList = viewBuilder.build().getViewList();
		assertTrue("Failures!", viewList.size() > 0);
		
		for(VersionView version: viewList)
			System.out.println(version);
	}
}