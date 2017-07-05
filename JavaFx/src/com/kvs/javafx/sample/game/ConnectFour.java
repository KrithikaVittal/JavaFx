package com.kvs.javafx.sample.game;
import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConnectFour extends Application {

	public static void main(String args[]) {
		launch(args);
	}

	Group root = new Group();

	@Override
	public void start(Stage primaryStage) throws Exception {
		drawBoard();
		Scene scene = new Scene(root, 700, 600, Color.DARKCYAN);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	boolean isPlayerOne = true;
	Circle[][] circleValues = new Circle[6][7];

	private void drawBoard() {
		StackPane stack = new StackPane();

		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < 6; i++) {
				Rectangle rect = new Rectangle(100, 100);
				rect.setTranslateX(j * 100);
				rect.setTranslateY(i * 100);
				rect.setFill(Color.DARKCYAN);
				rect.setStroke(Color.BLACK);
				stack.getChildren().add(rect);

				Circle circle = new Circle(50);
				circle.setTranslateX(j * 100);
				circle.setTranslateY(i * 100);
				stack.getChildren().add(circle);
				circle.setFill(Color.WHITE);
				circle.setStroke(Color.BLACK);
				this.circleValues[i][j] = circle;
				
				Text text=new Text(i+"-"+j);
				stack.getChildren().addAll(text);
				text.setTranslateX(j * 100);
				text.setTranslateY(i * 100);

				final int row = i;
				final int column = j;

				circle.setOnMouseClicked(new javafx.event.EventHandler<Event>() {
					@Override
					public void handle(Event arg0) {

						for (int i = 5; i >= row; i--) {
							if (circleValues[i][column].getFill().equals(
									Color.WHITE)) {
								if (isPlayerOne) {
									circleValues[i][column].setFill(Color.RED);
									isPlayerOne = false;
									checkWinner(Color.RED,i,column);
									break;
								} else {
									circleValues[i][column]
											.setFill(Color.YELLOW);
									isPlayerOne = true;
									checkWinner(Color.YELLOW,i,column);
									break;
								}
							}
						}
					}
				});

			}
		}

		root.getChildren().add(stack);

	}
	
	private boolean checkWinner(Color matchColor,int row,int column){
		
		int rowCount=0;
		int columnCount=0;
		
		System.out.println("int row,int column"+row+" "+column);
		
		if(row+4<6||row-4>0)
		for(int i=row;i<6;i++){
			Color testColour=(Color) circleValues[i][column].getFill();
			if(!testColour.equals(Color.WHITE)&&testColour.equals(matchColor)){
				rowCount++;
			}
		}		
		
		if(row+4<6||row-4>0)
		for(int i=row;i>-1;i--){
			Color testColour=(Color) circleValues[i][column].getFill();
			if(!testColour.equals(Color.WHITE)&&testColour.equals(matchColor)){
				rowCount++;
			}
		}
		
		
		if(column+4<7||column-4>0)
		for(int j=column;j<7;j++){
			Color testColour=(Color) circleValues[row][j].getFill();
			if(!testColour.equals(Color.WHITE)&&testColour.equals(matchColor)){
				columnCount++;
			}
		}
		
		
		if(column+4<7||column-4>0)
		for(int j=column-1;j>-1;j--){
			Color testColour=(Color) circleValues[row][j].getFill();
			if(!testColour.equals(Color.WHITE)&&testColour.equals(matchColor)){
				columnCount++;
			}
		}
		
		if(columnCount==4||rowCount==4){
			System.out.println("Four colours same.columnCount "+columnCount+"rowCount "+rowCount);
			return true;
		}
		
		return false;
		
	}

}
