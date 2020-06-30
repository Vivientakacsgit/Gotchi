package sample;

import com.sun.webkit.dom.XPathResultImpl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.*;



public class Main extends Application {
    Button btn;
    Scene scene;
    StackPane root;


    @Override
    public void start(Stage primaryStage) throws Exception{
//        Button btn = new Button();
//        btn.setText("alma");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("alma");
//                delete(primaryStage);
//            }
//        });
//        root = new StackPane();
//        root.getChildren().add(btn);
//        scene = new Scene(root, 300, 200);
//        primaryStage.setTitle("Gotchi");
//        primaryStage.setScene(scene);
//
//        primaryStage.show();

        Parent root = FXMLLoader.load(getClass().getResource("Gotchi.fxml"));

        primaryStage.setTitle("Gotchi");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();

    }

    private void delete(Stage primaryStage){



    }

    public static void main(String[] args) {
        launch(args);
    }
}
