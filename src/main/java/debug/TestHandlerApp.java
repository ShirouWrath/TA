package debug;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class TestHandlerApp extends Application {

    Rectangle rect = new Rectangle(100,100);
    Text textBase = new Text();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Random r = new Random();
        rect.setFill(Color.BLUE);
        rect.setOnMouseClicked(t -> rect.setFill(new Color(r.nextDouble(),r.nextDouble(),r.nextDouble(), 1.0)));

        textBase = new Text();
        textBase.setText("Bloom!");
        textBase.setFill(Color.BLACK);
        textBase.setFont(Font.font(null, FontWeight.BOLD, 40));
        textBase.setX(100);
        textBase.setY(100);
        textBase.setOnMouseClicked(event -> System.out.println("TEXTCLICKED"));

        StackPane root = new StackPane();
        root.getChildren().add(rect);
        root.getChildren().add(textBase);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
