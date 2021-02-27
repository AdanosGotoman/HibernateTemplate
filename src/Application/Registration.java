package Application;

import Utils.ConnectionManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Registration
{
    @FXML Button signUpButton;
    @FXML TextField loginField;
    @FXML TextField passField;
    @FXML TextField nameField;
    @FXML TextField surnameField;

    public void Sign() throws IOException
    {
        ConnectionManager manager = new ConnectionManager();
        manager.GetDBConnect();
        Init();
    }

    public void Init() throws IOException
    {
        try
        {
            ResultSet result = ConnectionManager.statement.executeQuery("SELECT id FROM user WHERE login = \'" + loginField.getText() + "\' AND + password = \'" + passField.getText() + "\'");

            if (!result.next())
            {
                ConnectionManager.statement.execute("INSERT INTO user (login, password, name, surname) VALUES (\'" + loginField.getText() + "\', \'" + passField.getText() + "\', \'" + nameField.getText() + "\', \'" + surnameField.getText() + "\')");
                System.out.println("Your account is Director " + result.getInt("id"));
            }
            else
                System.out.println("User already exist. Try new User name");
        }
        catch (SQLException err) { err.printStackTrace(); }

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Store.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = (Stage) signUpButton.getScene().getWindow();
        stage.close();

        stage.setTitle("Store");
        stage.setScene(scene);
        stage.show();
    }
}
