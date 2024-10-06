package iyteyazilim.projects.haydos.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.ConnectionProperties;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseConfigurer;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig implements EmbeddedDatabaseConfigurer {
    @Override
    public void configureConnectionProperties(ConnectionProperties properties, String databaseName) {
        databaseName = "haydosAppDB";
        properties.setUsername("root");
        properties.setPassword("yusuf.129");
        properties.setUrl("jdbc:mysql://localhost:3306/haydosAppDB");

    }

    @Override

    public void shutdown(DataSource dataSource, String databaseName) {
        try {
            dataSource.getConnection("root","yusuf.129");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
