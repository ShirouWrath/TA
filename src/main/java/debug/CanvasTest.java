package debug;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class CanvasTest extends Application {

    double visibility;
    boolean visibilityPolarization;
    Box drawbox;
    Bloom bloom;
    BoxBlur boxBlur;
    Text textBase;
    Text textBloom;
    TextField textField;
    Point3D rotationPoint;
    Reflection reflection;
    boolean IS_UPDATE_ON = false;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        //  OnClickEvent
//        root.setOnMouseClicked(event ->
//                System.out.println(event.getX() + ":" + event.getY())
//        );
        Canvas canvas = new Canvas(1280, 720);
        rotationPoint = new Point3D(-30,-50, 200);

        //  REFLECTION TEST
        Reflection reflection = new Reflection();
        //  Setting the bottom opacity of the reflection
        reflection.setBottomOpacity(0.0);
        //  Setting the top opacity of the reflection
        reflection.setTopOpacity(0.5);
        //  Setting the top offset of the reflection
        reflection.setTopOffset(10);
        //  Setting the fraction of the reflection
        reflection.setFraction(0.7);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc, root);
        root.getChildren().add(canvas);

        if(IS_UPDATE_ON) {
            //  FPS/UPDATE counter
            AnimationTimer frameRateMeter = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if (visibilityPolarization) {
                        visibility -= 1;
                    } else {
                        visibility += 1;
                    }
                    if (visibility >= 100 | visibility <= 0) {
                        visibilityPolarization = !visibilityPolarization;
                        //Test of random rotation
                        Random random = new Random();
                        rotationPoint = new Point3D(random.nextDouble() * 100, random.nextDouble() * 100, 0.5d);
                        textBase.setRotationAxis(rotationPoint);
                        textBloom.setRotationAxis(rotationPoint);

                    }
                    textBloom.setOpacity(Math.sin(visibility / 100));
                    textBase.setScaleX(visibility / 100);
                    textBase.setScaleY(visibility / 100);
                    textBloom.setScaleX(visibility / 100);
                    textBloom.setScaleY(visibility / 100);
                    //TEST OF ROTATION
                    textBase.setRotate(20d);
                    textBloom.setRotate(20d);
                    textBase.setEffect(reflection);
                }
            };
            frameRateMeter.start();
        }

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc, Group root) {

//        gc.setFill(Color.GREEN);
//        gc.setStroke(Color.BLUE);
//        gc.setLineWidth(5);
//        gc.strokeLine(40, 10, 10, 40);
//        gc.fillOval(10, 60, 30, 30);
//        gc.strokeOval(60, 60, 30, 30);
//        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
//        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
//        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
//        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
//        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
//        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
//        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
//        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
//        gc.fillPolygon(new double[]{10, 40, 10, 40},
//                new double[]{210, 210, 240, 240}, 4);
//        gc.strokePolygon(new double[]{60, 90, 60, 90},
//                new double[]{210, 210, 240, 240}, 4);
//        gc.strokePolyline(new double[]{110, 140, 110, 140},
//                new double[]{210, 210, 240, 240}, 4);
//
//        drawbox = new Box();
//        drawbox.setWidth(200.0);
//        drawbox.setHeight(400.0);
//        drawbox.setDepth(200.0);
//        drawbox.setRotate(rotation);
//        drawbox.setRotationAxis(new Point3D(10, 10, 10));
//
//        bloom = new Bloom();
//        bloom.setThreshold(0);

        Bloom bloom = new Bloom();
        bloom.setThreshold(0);
        Bloom bloom2 = new Bloom();
        bloom2.setThreshold(0);

        Rectangle rect = new Rectangle();
        rect.setX(10);
        rect.setY(10);
        rect.setWidth(160);
        rect.setHeight(80);
        rect.setFill(Color.DARKSLATEBLUE);
        rect.setOnMouseClicked(t -> rect.setFill(Color.RED));

        textBase = new Text();
        textBase.setText("Bloom!");
        textBase.setFill(Color.ALICEBLUE);
        textBase.setFont(Font.font(null, FontWeight.BOLD, 40));
        textBase.setX(25);
        textBase.setY(65);
        textBase.setRotationAxis(rotationPoint);

        textBloom = new Text();
        textBloom.setText("Bloom!");
        textBloom.setFill(Color.ALICEBLUE);
        textBloom.setFont(Font.font(null, FontWeight.BOLD, 40));
        textBloom.setX(25);
        textBloom.setY(65);
        textBloom.setRotationAxis(rotationPoint);
        textBloom.setEffect(bloom);

        textField = new TextField();
        textField.setLayoutX(300);
        textField.setLayoutY(300);
        textField.setOnMouseClicked(event -> System.out.println("Text Field handler"));

//        BoxBlur bb = new BoxBlur();
//        bb.setWidth(5);
//        bb.setHeight(5);
//        bb.setIterations(3);

        root.getChildren().add(rect);
        root.getChildren().add(textBase);
        root.getChildren().add(textBloom);
        root.getChildren().add(textField);

    }
}