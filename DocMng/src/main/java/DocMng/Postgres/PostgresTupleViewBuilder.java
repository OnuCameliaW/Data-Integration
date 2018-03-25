package DocMng.Postgres;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostgresTupleViewBuilder {

	private PostgresDataSource postgresConnector;
	public PostgresTupleViewBuilder(PostgresDataSource postgresConnector) {
		this.postgresConnector = postgresConnector;
	}

	public List<Map<String, Object>> build(String sql) {
		try (Connection postgresConnection = postgresConnector.getConnection()) {
			Statement selectStmt = postgresConnection.createStatement();
			ResultSet rs = selectStmt.executeQuery(sql);
			
			return new RSListMapAdapter().map(rs);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}	
	}
	
}

class RSListMapAdapter{
	public List<Map<String, Object>> map(ResultSet rs) throws Exception{
		List<Map<String, Object>> viewRows = new ArrayList<>();
		Map<String, Object> viewRow;
		ResultSetMetaData rsmd = rs.getMetaData();
		while (rs.next()) {				
			viewRow = new HashMap<>();

			for(int i=1; i <= rsmd.getColumnCount(); i++){
				viewRow.put(rsmd.getColumnName(i), rs.getObject(rsmd.getColumnName(i)));
			}
			viewRows.add(viewRow);
		}
		return viewRows;
	}
}
