package cat.uvic.teknos.m06.MangaApp.utilities;
import cat.uvic.teknos.m06.MangaApp.utilities.exceptions.SchemaLoaderException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.sql.DriverManager;

public class SingleLineCommandSchemaLoader implements SchemaLoader{
    private final String schemaPath;
    private final ConnectionProperties connectionProperties;

    public SingleLineCommandSchemaLoader(String schemaPath,ConnectionProperties connectionProperties){
        this.schemaPath=schemaPath;
        this.connectionProperties=connectionProperties;
    }

    @Override
    public void load(){
        //open db connection
        //read file

        try(var connection = DriverManager.getConnection(
                connectionProperties.getUrl(), connectionProperties.getUser(), connectionProperties.getPassword());
            var inputStream=new BufferedReader(new FileReader(schemaPath, Charset.forName("utf-8")));
            var statement=connection.createStatement();
            )
        {
            String sql=null;
            while((sql=inputStream.readLine())!=null){
                if(!sql.isEmpty()){
                    statement.executeUpdate(sql);
                }
            }
        }catch(SQLException e){
            throw new SchemaLoaderException(e);
        }catch(FileNotFoundException e){
            throw new SchemaLoaderException("This file"+schemaPath+"doesn't exist");
        }catch(IOException e){
            throw new SchemaLoaderException("IO Exception",e);
        }
    }
}
