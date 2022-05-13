package cat.uvic.teknos.m06.MangaApp.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import cat.uvic.teknos.m06.MangaApp.utilities.exceptions.SchemaLoaderException;

class MultipleLinesCommandSchemaLoaderWrongSchemaTest {

    @Test
    void load() {
        var connectionProperties = new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        var schemaLoader = new MultipleLinesCommandSchemaLoader("src/test/resources/multipleLinesSqlCommand.sql", connectionProperties);
        assertThrows(SchemaLoaderException.class,() -> {
            schemaLoader.load();
        });
    }
}