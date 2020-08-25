package de.dunaev.dao;

import java.util.List;

import de.dunaev.transfer.WindelSchichtTO;

public interface WindelSchichtDao {
	
	public WindelSchichtTO addWindelSchicht(Integer parentId) throws DaoException;
	
	public WindelSchichtTO findById(Integer id) throws DaoException;
	
	public WindelSchichtTO updateWindelSchicht(WindelSchichtTO windelSchicht) throws DaoException;
	
	public boolean deleteWindelSchicht(Integer id) throws DaoException;
	
	public List<WindelSchichtTO> findAll() throws DaoException;
}
