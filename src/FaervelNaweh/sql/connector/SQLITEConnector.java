/*
 * @author Andreas Schreiner
 */
package FaervelNaweh.sql.connector;
import javafx.collections.ObservableList;
import java.sql.*;
/**
 * Connector Class for SQLLite
 */
public class SQLITEConnector extends SQLConnector {

    /**
     * Opens and or Creates SQLite DB
     * @param fileLocation Pfad zur SQLite Datei
     */
    public SQLITEConnector(String fileLocation)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName("org.sqlite.JDBC").newInstance();
        connect = DriverManager.getConnection("jdbc:sqlite:" + fileLocation);
    }
    @Override
    public ObservableList<ObservableList> getTableNames() throws SQLException {
        String sqlCommandString  =".tables;";
        return getRows(sqlCommandString);
    }
}