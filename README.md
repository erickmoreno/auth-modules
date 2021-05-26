# Authentication and authorization cloud solution

This is a reference project that packages my go to solutions to secure web/cloud projects

## Related projects

[Keycloak](https://www.keycloak.org)

## Usage

docker-compose up -d

Go to: localhost:8080/auth

## Realm ADMIN

### Get access token

```
  export ACCESS_TOKEN=`curl \
  -d "client_id=admin-cli" \
  -d "username=admin" \
  -d "password=password" \
  -d "grant_type=password" \
  "http://localhost:8080/auth/realms/master/protocol/openid-connect/token" | jq -r '.access_token'`
```

### Find out if realm _test_ exists

```
  curl -H "Authorization: Bearer $ACCESS_TOKEN" \
  -H "Content-Type: application/json" \
  "http://localhost:8080/auth/admin/realms/test"
```

### Create realm

```bash
  curl -v -X POST \
  -H "Authorization: Bearer $ACCESS_TOKEN" \
  -H "Content-Type: application/json" \
  -d @realm.json \
  "http://localhost:8080/auth/admin/realms"
```

### Find out if Realm _test_ was created

```bash
  curl -H "Authorization: Bearer $ACCESS_TOKEN" \
  -H "Content-Type: application/json" \
  "http://localhost:8080/auth/admin/realms/test"
```

### Delete realm

```bash
  curl -v -X DELETE \
  -H "Authorization: Bearer $ACCESS_TOKEN" \
  -H "Content-Type: application/json" \
  "http://localhost:8080/auth/admin/realms/test"
```
