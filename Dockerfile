FROM jboss/keycloak:6.0.1
COPY ./theme /opt/jboss/keycloak/themes/
RUN ls -la /opt/jboss/keycloak/themes/  
ENTRYPOINT [ "/opt/jboss/tools/docker-entrypoint.sh" ]
CMD ["-b", "0.0.0.0"]S