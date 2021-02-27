package Application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class Authorisation
{
    @FXML Button signButton;

    public void Sign() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Store.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = (Stage) signButton.getScene().getWindow();
        stage.close();

        stage.setTitle("Store");
        stage.setScene(scene);
        stage.show();
    }
}
