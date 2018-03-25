package DocMng.Postgres;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DocumentViewBuilder {

	private String DOCUMENT_QUERY = "SELECT id, name, description, current_version, create_date, modify_date, delete_date, file, author_id FROM documents";

	private List<DocumentView> documentViewList;
	private List<Map<String, Object>> documentRawList;

	public List<DocumentView> getViewList() {
		return this.documentViewList;
	}

	public DocumentViewBuilder build(){
		return this.select().map();
	}
	
	private DocumentViewBuilder select() {
		this.documentRawList = this.PostgresPreViewBuilder.build(DOCUMENT_QUERY);
		return this;
	}

	private DocumentViewBuilder map() {
		this.documentViewList = new DocumentViewListAdapter().map(this.documentRawList);
		return this;
	}

	/* ------------------------------------------------ */
	private PostgresTupleViewBuilder PostgresPreViewBuilder;

	public DocumentViewBuilder(PostgresTupleViewBuilder PostgresPreViewBuilder) {
		super();
		this.PostgresPreViewBuilder = PostgresPreViewBuilder;
	}
}

class DocumentViewListAdapter {
	
	public List<DocumentView> map(List<Map<String, Object>> sourceDataList){
		List<DocumentView> viewList = new ArrayList<>();
		DocumentViewAdapter adapter = new DocumentViewAdapter();
		for(Map<String, Object> sourceData: sourceDataList){
			viewList.add(adapter.map(sourceData));
		}		
		return viewList;
	}
}
class DocumentViewAdapter {
	public DocumentView map(Map<String, Object> rawData) {
		Integer id = ((BigDecimal) rawData.get("id")).intValue();
		String name = (String) rawData.get("name");
		String description = (String) rawData.get("description");
		Integer currentVersion = ((BigDecimal) rawData.get("current_version")).intValue();
		Date createDate = (Date) rawData.get("create_date");
		Date modifyDate = (Date) rawData.get("modify_date");
		Date deleteDate = (Date) rawData.get("delete_date");
		Byte[] file = ((Byte[]) rawData.get("file"));
		Integer authorId = ((BigDecimal) rawData.get("author_id")).intValue();

		return new DocumentView(id, name, description, currentVersion, createDate, modifyDate, deleteDate, file, authorId);
	}

}