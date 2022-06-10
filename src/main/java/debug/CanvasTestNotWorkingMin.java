package debug;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class CanvasTestNotWorkingMin extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();

        drawShapes(root);

        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

    private void drawShapes(Group root) {
        //DRAW SHAPES
        Rectangle rect = new Rectangle();
        rect.setX(10);
        rect.setY(10);
        rect.setWidth(160);
        rect.setHeight(80);
        rect.setFill(Color.DARKSLATEBLUE);
        rect.setOnMouseClicked(t -> rect.setFill(Color.RED));
        root.getChildren().add(rect);
        //END DRAW SHAPES
    }
}