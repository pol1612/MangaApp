package cat.uvic.teknos.m06.MangaApp.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class



MultipleLinesCommandSchemaLoaderTest {

    @Test
    void load() {
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        var schemaLoader= new MultipleLinesCommandSchemaLoader("src/main/resources/schema.sql",connectionProperties);
        assertDoesNotThrow(() ->{
            schemaLoader.load();
        });
    }
}