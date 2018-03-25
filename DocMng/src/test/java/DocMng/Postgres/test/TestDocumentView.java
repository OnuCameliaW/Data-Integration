package DocMng.Postgres.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DocMng.Postgres.DocumentView;
import DocMng.Postgres.DocumentViewBuilder;
import DocMng.Postgres.PostgresDataSource;
import DocMng.Postgres.PostgresTupleViewBuilder;

public class TestDocumentView {
	private PostgresDataSource postgresConnector;
	private PostgresTupleViewBuilder postgresPreViewBuilder;
	private DocumentViewBuilder viewBuilder;
	
	@Before
	public void setUp() throws Exception {
		postgresConnector = new PostgresDataSource();
		postgresPreViewBuilder = new PostgresTupleViewBuilder(postgresConnector);
		viewBuilder = new DocumentViewBuilder(postgresPreViewBuilder);
	}
	
	
	@Test
	public void testGetDocument() {
		List<DocumentView> viewList = viewBuilder.build().getViewList();
		assertTrue("Failures!", viewList.size() > 0);
		
		for(DocumentView document: viewList)
			System.out.println(document);
	}
}