package de.dunaev.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import de.dunaev.dao.DaoException;
import de.dunaev.dao.DaoFactory;
import de.dunaev.dao.WindelSchichtDao;

@Path("/windel")
public class WindelSchichtResource {

		private WindelSchichtDao dao;
	
		public WindelSchichtResource() throws DaoException {
			dao = DaoFactory.getWindelSchichtDao();
		}
		@GET
		@Produces("application/json")
		public Response getAll() throws DaoException {
			return Response.ok(dao.findAll()).build();
		}
		
		@Path("/{parent_id}")
		@GET
		@Produces("application/json")
		public Response newEntry(@PathParam("parent_id") Integer id) throws DaoException{
			return Response.ok(dao.addWindelSchicht(id)).build();
		}
}
