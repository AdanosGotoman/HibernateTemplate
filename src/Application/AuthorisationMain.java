package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AuthorisationMain extends Application
{
    private static final String URL = "jdbc:mysql://localhost:3306/adanosdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("Authorisation.fxml"));
        primaryStage.setTitle("Store DataBase");
        primaryStage.setScene(new Scene(root, 432, 259));
        primaryStage.show();
    }

    public static void main(String[] args) throws SQLException
    {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        if (!connection.isClosed())
            System.out.println("Connect to DB success.");

        launch(args);

        connection.close();
        if (connection.isClosed())
            System.out.println("Connection to DB is closed.");
    }
}
