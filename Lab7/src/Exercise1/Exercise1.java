package Exercise1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Exercise1 extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {

        BallPane ballPane = new BallPane(250,250, 50);


        Button up = new Button("Up");
        up.setOnAction(e ->
        {
            ballPane.moveUp();
        });


        Button down = new Button("Down");
        down.setOnAction(e ->
        {
            ballPane.moveDown();
        });

        Button left = new Button("Left");
        left.setOnAction(e ->
        {
            ballPane.moveLeft();
        });

        Button right = new Button("Right");
        right.setOnAction(e ->
        {
            ballPane.moveRight();
        });

        HBox buttons = new HBox(up, down, left, right);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setSpacing(10);
        buttons.setPadding(new Insets(10, 10, 10, 10));


        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setBottom(buttons);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Exercise 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class BallPane extends Pane {

        private Circle mCircle;

        public BallPane(double centerX, double centerY, double radius) {
            mCircle = new Circle(centerX, centerY, radius);
            getChildren().add(mCircle);
        }

        public void moveUp() {
            if (mCircle.getCenterY() - mCircle.getRadius()  - 10 < 0) return;
            mCircle.setCenterY(mCircle.getCenterY() - 10);
        }
        public void moveDown() {
            if (mCircle.getCenterY() + mCircle.getRadius() + 10 > getHeight()) return;

            mCircle.setCenterY(mCircle.getCenterY() + 10);
        }
        public void moveRight() {
            if (mCircle.getCenterX() + mCircle.getRadius() + 10 > getWidth()) return;
            mCircle.setCenterX(mCircle.getCenterX() + 10);
        }
        public void moveLeft() {
            if (mCircle.getCenterX() - mCircle.getRadius()  - 10 < 0) return;
            mCircle.setCenterX(mCircle.getCenterX() - 10);

        }

    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}