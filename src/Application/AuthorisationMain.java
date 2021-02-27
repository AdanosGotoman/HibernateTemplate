package Application;

import Utils.Const;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorisationMain extends Application
{
    // Const string for DataBase connection...
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

    // Connection manager
    public static Connection GetDBConnect() throws SQLException
    {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        if (!connection.isClosed())
            System.out.println("Connect to DB success.");

        connection.close();

        return connection;
    }

    public static void main(String[] args) throws SQLException
    {
        GetDBConnect();

        launch(args);

        if (GetDBConnect().isClosed())
            System.out.println("Connection to DB is closed.");
    }

    public void SignUp(String name, String surname, String login, String password) throws SQLException {
        String insert = "INSERT " +
                Const.USER_TABLE + "(" +
                Const.USER_NAME + "," +
                Const.USER_SURNAME + "," +
                Const.USER_LOGIN + "," +
                Const.USER_PASSWORD + ")" + "VALUES(?,?,?,?)";

        PreparedStatement pState = GetDBConnect().prepareStatement(insert);

        pState.setString(1, name); pState.setString(2, surname);
        pState.setString(3, login); pState.setString(4, password);
    }
}
