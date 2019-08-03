package com.cavinae;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.keycloak.KeycloakSecurityContext;

public class UsersResource {

    @Inject
    KeycloakSecurityContext keycloakSecurityContext;

    @GET
    @Path("/me")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    @NoCache
    public User me() {
        return new User(keycloakSecurityContext);
    }

    public class User {

        private final String userName;

        User(KeycloakSecurityContext securityContext) {
            this.userName = securityContext.getToken().getPreferredUsername();
        }

        public String getUserName() {
            return userName;
        }
    }
}