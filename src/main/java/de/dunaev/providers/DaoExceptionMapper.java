package de.dunaev.providers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import de.dunaev.dao.DaoException;

@Provider
public class DaoExceptionMapper implements ExceptionMapper<DaoException>{

	@Override
	public Response toResponse(DaoException exception) {
		Map<String, String> error = new HashMap<>();
		
		error.put("messege", exception.getMessage());
		error.put("time", new Date().toString());
		return Response.status(500).entity(error).build();
	}

}
