package cat.uvic.teknos.m06.MangaApp.utilities;
import cat.uvic.teknos.m06.MangaApp.utilities.exceptions.SchemaLoaderException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;

public class MultipleLinesCommandSchemaLoader implements SchemaLoader{
    private final String schemaPath;
    private final ConnectionProperties connectionProperties;

    public MultipleLinesCommandSchemaLoader(String schemaPath, ConnectionProperties connectionProperties) {
        this.schemaPath = schemaPath;
        this.connectionProperties = connectionProperties;
    }

    @Override
    public void load(){
        try(var connection = DriverManager.getConnection(
                connectionProperties.getUrl(), connectionProperties.getUser(), connectionProperties.getPassword());
            var inputStream=new Scanner(new FileReader(schemaPath, Charset.forName("utf-8")));
            var statement=connection.createStatement();
        ){
            String command;
            String[] lineParts;
            String line;

            while(inputStream.hasNextLine()){
                command="";
                while(command.indexOf(';')==-1) {
                    line="";
                    line=inputStream.nextLine();
                    if(line.contains("--")){
                        if(line.startsWith("--")){
                            line="";
                        }
                        else{
                            lineParts=line.split("--");
                            line=lineParts[0];
                        }
                    }
                    command+=line;
                }
                statement.executeUpdate(command);

            }
        }catch(SQLSyntaxErrorException e){
            try(var connection = DriverManager.getConnection(
                    connectionProperties.getUrl(), connectionProperties.getUser(), connectionProperties.getPassword());
                    var statement=connection.createStatement();
                    var preparedStatement=connection.prepareStatement("INSERT INTO syntax_exceptions(date,user,database_used,syntax_exceptions_messages) VALUES(CURRENT_TIMESTAMP,?,?,?);");
                        ){
                String message;
                String user1;
                String user;
                String db;
                String db1;
                user1=connectionProperties.getUser();
                user="'"+user1+"'";
                db1=connectionProperties.getUrl();
                db="'"+db1+"'";
                message="'"+e.getMessage()+"'";
                statement.executeUpdate("CREATE DATABASE IF NOT EXISTS exceptions;");
                statement.executeUpdate("USE exceptions;");
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS syntax_exceptions(date Date,user VARCHAR(15),database_used VARCHAR(100),syntax_exceptions_messages VARCHAR(255));");
                preparedStatement.setString(1,user);
                preparedStatement.setString(2,db);
                preparedStatement.setString(3,message);
                preparedStatement.executeUpdate();
            }catch(SQLException e2){
                throw new SchemaLoaderException(e2);
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
