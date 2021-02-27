package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
This is Entry point to Database. Don't modify this code block!!!
*/
public class AuthorisationMain extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        primaryStage.setTitle("Store DataBase");
        primaryStage.setScene(new Scene(root, 432, 361));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}