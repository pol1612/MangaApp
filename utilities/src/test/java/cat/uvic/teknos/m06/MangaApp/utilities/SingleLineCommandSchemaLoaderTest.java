package cat.uvic.teknos.m06.MangaApp.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SingleLineCommandSchemaLoaderTest {

    @Test
    void load() {
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jbdc:mysql://localhost:3306/mysql");
        connectionProperties.setUser("root");
        var schemaLoader= new SingleLineCommandSchemaLoader("src/test/resources/singleLineSqlCommand.txt",connectionProperties);
        assertDoesNotThrow(() ->{
            schemaLoader.load();
        });
    }
}