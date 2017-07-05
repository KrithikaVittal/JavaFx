package com.kvs.javafx.sample.shape;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class ColorfulCircles extends Application {
	
	Group root;
	
	public static void main(String[] args){
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		root=new Group();
		Scene scene=new Scene(root, 500, 500,Color.BURLYWOOD);
		createCircles();
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	private void createCircles(){
		Group circles=new Group();
		
		for(int i=0;i<5;i++){
			Circle circle=new Circle(100,Color.BLUEVIOLET);
			circles.getChildren().add(circle);
		}
		
		root.getChildren().add(circles);
		
		Timeline timeline = new Timeline();
		for (Node circle: circles.getChildren()) {
		    timeline.getKeyFrames().addAll(
		        new KeyFrame(Duration.ZERO, // set start position at 0
		            new KeyValue(circle.translateXProperty(), 0),
		            new KeyValue(circle.translateYProperty(), 0)
		        ),
		        new KeyFrame(new Duration(5000), // set end position at 40s
		            new KeyValue(circle.translateXProperty(), Math.random() * 800),
		            new KeyValue(circle.translateYProperty(), Math.random() * 600)
		        )
		    );
		}
		// play 40s of animation
		timeline.play();
	}

	
}
