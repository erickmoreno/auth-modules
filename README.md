# Authentication and authorization cloud solution

This is a reference project that packages my go to solutions to secure web/cloud projects

### Related projects

[Keycloak](https://www.keycloak.org)

[Keycloak Gatekeeper](https://www.keycloak.org/docs/latest/securing_apps/index.html#_keycloak_generic_adapter)

## Usage

docker-compose -p 8080:8080 up -d

Go to: localhost:8080/auth

## To publish a new image

docker tag <IMAGE ID> docker.pkg.github.com/erickmoreno/cavia-auth/cavia-auth:<IMAGE TAG>
docker push docker.pkg.github.com/erickmoreno/cavia-auth/cavia-auth:<IMAGE TAG>
