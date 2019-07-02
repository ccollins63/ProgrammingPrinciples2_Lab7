package Exercise3;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class Exercise3 extends Application
{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
        Pane pane = new Pane();
        pane.setPadding(new Insets(15, 15, 15, 15));

        Button btResume = new Button("Resume");
        Button btStop   = new Button("Stop");

        Ellipse ellipse = new Ellipse(250, 250, 200, 150);

        Image image     = new Image("http://carpng.com/wp-content/uploads/full/f1-racing-car-icon-top-view-2069-0.png");
        ImageView raceCar = new ImageView(image);
        raceCar.setFitWidth(50);
        raceCar.setFitHeight(50);

        Image image2     = new Image("https://thumbs.dreamstime.com/t/top-view-race-circuit-competition-board-69400899.jpg");
        ImageView track = new ImageView(image2);
        track.setFitHeight(500);
        track.setFitWidth(500);

        HBox buttons = new HBox(btResume, btStop);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setSpacing(10);
        buttons.setPadding(new Insets(10, 10, 10, 10));

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(buttons);

        pane.getChildren().addAll(track, raceCar);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(ellipse);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setNode(raceCar);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play(); // Start animation

        btResume.setOnAction(e ->
        {
            pt.play();
        });

        btStop.setOnAction(e ->
        {
            pt.pause();
        });

        Scene scene = new Scene(borderPane, 500, 500);
        primaryStage.setTitle("Exercise 3");
        primaryStage.setScene(scene);
        primaryStage.show();
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