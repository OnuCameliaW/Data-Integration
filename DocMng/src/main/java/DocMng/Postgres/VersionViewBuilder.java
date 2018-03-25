package DocMng.Postgres;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class VersionViewBuilder {
	private String VERSION_QUERY = "SELECT id, version_number, description, current_version, create_date, file, document_id FROM versions";

	private List<VersionView> versionsViewList;
	private List<Map<String, Object>> versionRawList;

	public List<VersionView> getViewList() {
		return this.versionsViewList;
	}

	public VersionViewBuilder build(){
		return this.select().map();
	}
	
	private VersionViewBuilder select() {
		this.versionRawList = this.PostgresPreViewBuilder.build(VERSION_QUERY);
		return this;
	}

	private VersionViewBuilder map() {
		this.versionsViewList = new VersionViewListAdapter().map(this.versionRawList);
		return this;
	}

	/* ------------------------------------------------ */
	private PostgresTupleViewBuilder PostgresPreViewBuilder;

	public VersionViewBuilder(PostgresTupleViewBuilder PostgresPreViewBuilder) {
		super();
		this.PostgresPreViewBuilder = PostgresPreViewBuilder;
	}
}

class VersionViewListAdapter {
	
	public List<VersionView> map(List<Map<String, Object>> sourceDataList){
		List<VersionView> viewList = new ArrayList<>();
		VersionViewAdapter adapter = new VersionViewAdapter();
		for(Map<String, Object> sourceData: sourceDataList){
			viewList.add(adapter.map(sourceData));
		}		
		return viewList;
	}
}
class VersionViewAdapter {

	public VersionView map(Map<String, Object> rawData) {
		Integer id = ((BigDecimal) rawData.get("id")).intValue();
		Integer versionNumber = ((BigDecimal) rawData.get("version_number")).intValue();
		String description = (String) rawData.get("description");
		Boolean currentVersion = (Boolean) rawData.get("current_version");
		Date createDate = (Date) rawData.get("create_date");
		Byte[] file = ((Byte[]) rawData.get("file"));
		Integer documnetId = ((BigDecimal) rawData.get("document_id")).intValue();

		return new VersionView(id, versionNumber, description, currentVersion, createDate, file, documnetId);
	}

}
