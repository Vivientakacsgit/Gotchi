package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Gotchi.fxml"));
        primaryStage.setTitle("Gotchi");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
}













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
