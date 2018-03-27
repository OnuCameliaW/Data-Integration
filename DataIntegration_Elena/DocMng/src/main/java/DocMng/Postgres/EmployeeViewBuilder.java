package DocMng.Postgres;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeViewBuilder {
	private String EMPLOYEE_QUERY = "SELECT id, first_name, last_name, userName, position FROM employees";

	private List<EmployeeView> employeesViewList;
	private List<Map<String, Object>> employeeRawList;

	public List<EmployeeView> getViewList() {
		return this.employeesViewList;
	}

	public EmployeeViewBuilder build(){
		return this.select().map();
	}
	
	private EmployeeViewBuilder select() {
		this.employeeRawList = this.PostgresPreViewBuilder.build(EMPLOYEE_QUERY);
		return this;
	}

	private EmployeeViewBuilder map() {
		this.employeesViewList = new EmployeeViewListAdapter().map(this.employeeRawList);
		return this;
	}

	/* ------------------------------------------------ */
	private PostgresTupleViewBuilder PostgresPreViewBuilder;

	public EmployeeViewBuilder(PostgresTupleViewBuilder PostgresPreViewBuilder) {
		super();
		this.PostgresPreViewBuilder = PostgresPreViewBuilder;
	}
}

class EmployeeViewListAdapter {
	
	public List<EmployeeView> map(List<Map<String, Object>> sourceDataList){
		List<EmployeeView> viewList = new ArrayList<>();
		EmployeeViewAdapter adapter = new EmployeeViewAdapter();
		for(Map<String, Object> sourceData: sourceDataList){
			viewList.add(adapter.map(sourceData));
		}		
		return viewList;
	}
}
class EmployeeViewAdapter {

	public EmployeeView map(Map<String, Object> rawData) {
		Integer id = ((BigDecimal) rawData.get("id")).intValue();
		String firstName = (String) rawData.get("first_name");
		String lastName = (String) rawData.get("last_name");
		String userName = (String) rawData.get("userName");
		String position = (String) rawData.get("position");

		return new EmployeeView(id, firstName, lastName, userName, position);
	}

}
