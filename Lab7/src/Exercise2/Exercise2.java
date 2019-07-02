package Exercise2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise2 extends Application
{

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {

        Pane pane = new Pane();
        pane.setPadding(new Insets(15, 15, 15, 15));

        Line line = new Line(40, 40, 120,150);

        Circle circle1 = new Circle(40,40,10);
        circle1.setStroke(Color.BLACK);

        Circle circle2 = new Circle(120,150,10);
        circle2.setStroke(Color.BLACK);

        Text txtDistance = new Text((circle1.getCenterX() + circle2.getCenterX()) / 2, (circle1.getCenterY() + circle2.getCenterY()) / 2, distance(circle1, circle2));
        txtDistance.setFont(Font.font("Times New Roman", 20));

        pane.getChildren().addAll(circle1, circle2, line, txtDistance);

        circle1.setOnMouseDragged(event ->
        {
            circle1.setCenterX(event.getX());
            circle1.setCenterY(event.getY());
            line.setStartX(circle1.getCenterX());
            line.setStartY(circle1.getCenterY());
            txtDistance.setX((circle1.getCenterX() + circle2.getCenterX()) / 2);
            txtDistance.setY((circle1.getCenterY() + circle2.getCenterY()) / 2);
            txtDistance.setText(distance(circle1, circle2));
        });

        circle2.setOnMouseDragged(event ->
        {
            circle2.setCenterX(event.getX());
            circle2.setCenterY(event.getY());
            line.setEndX(circle2.getCenterX());
            line.setEndY(circle2.getCenterY());
            txtDistance.setX((circle1.getCenterX() + circle2.getCenterX()) / 2);
            txtDistance.setY((circle1.getCenterY() + circle2.getCenterY()) / 2);
            txtDistance.setText(distance(circle1, circle2));
        });


        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Exercise 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String distance(Circle c1, Circle c2)
    {
        double distance = Math.sqrt(Math.pow(c2.getCenterX() - c1.getCenterX(), 2)
                + Math.pow(c2.getCenterY() - c1.getCenterY(), 2)) - 20;
        return String.format("%.0f", distance);
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
