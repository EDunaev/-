package de.dunaev.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import de.dunaev.transfer.WindelSchichtTO;
import de.dunaev.utils.DbUtil;

public class JdbcWindelSchichtDao implements WindelSchichtDao {


	@Override
	public WindelSchichtTO addWindelSchicht(Integer parentId) throws DaoException {
		String sql = "INSERT INTO WindelSchicht (ParentId, Date) VALUES (?,?)";
		WindelSchichtTO schichtTO = new WindelSchichtTO();
		LocalDate curentDate = LocalDate.now();
	
		try (
				Connection conn = DbUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);	
		){
			statement.setInt(1, parentId);
			statement.setDate(2, Date.valueOf(curentDate));
			
			statement.executeUpdate();
			ResultSet resultSet = statement.getGeneratedKeys();
			resultSet.next();
			schichtTO.setId(resultSet.getInt("ID"));
			schichtTO.setParentName(resultSet.getInt("ParentId"));
			schichtTO.setDate(curentDate);
			
		}catch (Exception e) {
			throw new DaoException(e);
		}
		return schichtTO;
	}

	@Override
	public WindelSchichtTO findById(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WindelSchichtTO updateWindelSchicht(WindelSchichtTO windelSchicht) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteWindelSchicht(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WindelSchichtTO> findAll() throws DaoException {
		String sql = "SELECT * FROM WindelSchicht";
		
		List<WindelSchichtTO> list = new ArrayList<>();
		
		try(
				Connection conn = DbUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql);
		) {
			statement.execute();
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				WindelSchichtTO schichtTO = new WindelSchichtTO();
				schichtTO.setId(resultSet.getInt("ID"));
				schichtTO.setParentName(resultSet.getInt("ParentId"));
				schichtTO.setDate((resultSet.getDate("Date")).toLocalDate());
				list.add(schichtTO);
			}
			resultSet.close();
		}catch (Exception e) {
			throw new DaoException(e);
		}
		return list;
	}

}
