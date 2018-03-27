package DocMng.MongoDb.test;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DocMng.MongoDb.*;

public class TestProjectView {
	private MongodbDataSource mongodbDataSource;
	private MongodbTupleViewBuilder mongodbTupleViewBuilder;
	private ProjectViewBuilder viewBuilder;
	
	@Before
	public void setUp() throws Exception {
		this.mongodbDataSource = new MongodbDataSource();
		this.mongodbTupleViewBuilder = new MongodbTupleViewBuilder(mongodbDataSource);
		this.viewBuilder = new ProjectViewBuilder(mongodbTupleViewBuilder);
	}
	
	@Test
	public void TestGetProjectName() throws Exception{
		
		List<Project> listOfProjects = this.viewBuilder.build().getViewList();

		for(Project p: listOfProjects)
			System.out.println(p.getName());
		}	
	
	@Test
	public void TestGetDocumentNameForEveryProject() throws Exception{
		
		List<Project> listOfProjects = this.viewBuilder.build().getViewList();

		for(Project p: listOfProjects) {
			System.out.println("-----" + p.getName() + "-----");
			for(Document d: p.getDocuments()) {
				System.out.println(d.getDocumentName());
			}
		}
			
			
		}	
	}	


