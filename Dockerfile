FROM fabric8/java-jboss-openjdk8-jdk

# Prepare by downloading dependencies
COPY target/messageforward.jar /home/