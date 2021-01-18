package ruan.nunes.api.contract;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import ruan.nunes.domain.RepositoryDTO;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
@Path("/githubinfo")
@Produces(MediaType.APPLICATION_JSON)
public interface GitHubApi {
    @GET
    @Path("/{url}")
    @APIResponse(responseCode = "200",
            description = "return info for repository",
            content = @Content(schema = @Schema(implementation = String.class)))
    @APIResponse(responseCode = "404", description = "repository not found")
    @Operation(summary = "Get info for repository")
    public RepositoryDTO getInfo(@PathParam("url") final String url);
}
