package org.wink.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.wink.api.model.AccessTokenRequest;
import org.wink.api.model.AccessTokenResponse;

@Path("/oauth2")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface OAuth {

	@Path("/authorize")
	@GET
	public void authorize(@QueryParam("response_type") String response_type, @QueryParam("client_id") String client_id,
			@QueryParam("redirect_uri") String redirect_uri, @QueryParam("state") String state);
	
	@Path("/token")
	@POST
	public AccessTokenResponse getAccessToken(AccessTokenRequest accessTokenRequest);

	@Path("/token")
	@POST
	public AccessTokenResponse refreshAccessToken(AccessTokenRequest accessTokenRequest);

	@Path("/token")
	@POST
	public AccessTokenResponse signIn(AccessTokenRequest accessTokenRequest);
}
