package de.dunaev.dao;

public class DaoFactory {

	private static final String IMPL_TYPE = "jdbc";
	
	private DaoFactory() {
	}
	
	public static WindelSchichtDao getWindelSchichtDao() throws DaoException {
		switch (IMPL_TYPE) {
		case "jdbc":
				return new JdbcWindelSchichtDao();
		default:
			throw new DaoException();
		}
	}
}
