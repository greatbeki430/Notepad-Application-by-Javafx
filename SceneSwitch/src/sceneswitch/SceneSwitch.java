
package sceneswitch;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class SceneSwitch extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        //Stage stage = new Stage();
        try{
        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        
        Scene scene = new Scene(root,600,400);
       //Image image = new Image("Great.jpg");
        
        stage.setTitle("Scene!");
        //stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        }catch(IOException e){
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
