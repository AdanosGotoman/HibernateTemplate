package Application;

import Utils.ConnectionManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AuthorisationMain extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        primaryStage.setTitle("Store DataBase");
        primaryStage.setScene(new Scene(root, 432, 259));
        primaryStage.show();
    }

    public static void main(String[] args) throws SQLException
    {
        ConnectionManager.GetDBConnect();

        launch(args);

        if (ConnectionManager.GetDBConnect().isClosed())
            System.out.println("Connection to DB is closed.");
    }
}
