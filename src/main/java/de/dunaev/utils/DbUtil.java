package de.dunaev.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import de.dunaev.dao.DaoException;

public final class DbUtil {

	private static String driver, url, user, password;
	private DbUtil() {
		
	}
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		driver = bundle.getString("jdbc.driver");
		url = bundle.getString("jdbc.url");
		user = bundle.getString("jdbc.user");
		password = bundle.getString("jdbc.password");
		
	}
	public static Connection getConnection() throws DaoException{
		
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new DaoException("URL not correct");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
