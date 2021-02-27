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

public class Authorisation
{
    @FXML Button signButton;
    @FXML TextField loginField;
    @FXML TextField passField;

    public void Sign() throws IOException
    {
        ConnectionManager manager = new ConnectionManager();
        manager.GetDBConnect();
        Init();
    }

    public void Init()
    {
        signButton.setOnAction(actionEvent ->
        {
            try
            {
                ResultSet result = ConnectionManager.statement.executeQuery
                        ("SELECT id FROM user WHERE " +
                                "login = \'" + loginField.getText() + "\' AND" + " " +
                                "password = \'" + passField.getText() + "\'");

                if (result.next())
                    System.out.println("Your account is Director: " + result.getInt("id"));
                else
                    System.out.println("Not found account");
            }
            catch (SQLException err) { err.printStackTrace(); }
        });
    }
}
