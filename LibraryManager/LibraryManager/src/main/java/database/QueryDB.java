package database;

import models.QueryModel;
import models.QueryRequestModel;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class QueryDB {
    private final static String CONNECTION_STRING = "jdbc:mariadb://localhost:3306";
    private final static String USERNAME = "root";

    private Connection connection;
    private static QueryDB instance = null;

    private QueryDB() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, null);
            Statement statement = connection.createStatement();
            statement.executeQuery("use library");
        } catch (SQLException e) {
            System.err.println("Failed connection to Database");
            exit(-1);
        }
    }

    public static QueryDB getInstance() {
        if (null == instance) {
            instance = new QueryDB();
        }
        return instance;
    }

    public QueryModel executeQuery(@NotNull QueryRequestModel requestModel) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(requestModel.getQueryString());
        for(int i = 0 ; i < requestModel.getNumberOfParameters() ; ++i) {
            callableStatement.setString(i + 1,
                    requestModel.getParameterValues().get(i));
        }
        ResultSet resultSet = callableStatement.executeQuery();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int count = resultSetMetaData.getColumnCount();

        List<String> columns = new ArrayList<>();
        List<List<String>> rows = new ArrayList<>();

        for (int i = 1; i <= count; ++i) {
            columns.add(resultSetMetaData.getColumnLabel(i));
        }

        while (resultSet.next()) {
            List<String> rowData = new ArrayList<>();

            for (String column : columns) {
                rowData.add(resultSet.getString(column));
            }

            rows.add(rowData);
        }

        return new QueryModel(columns, rows);
    }

}
