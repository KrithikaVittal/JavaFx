package com.kvs.javafx.sample.game;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TicTacToe extends Application {

	private static final Group board = new Group();
	private String[][] values = { { "", "", "" }, { "", "", "" },
			{ "", "", "" } };

	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primarystage) throws Exception {
		drawBoard();
		Scene scene = new Scene(board, 900, 900, Color.BURLYWOOD);
		primarystage.setScene(scene);
		primarystage.show();
	}

	private boolean isPlayerX = true;

	private void drawBoard() {
		StackPane stack = new StackPane();
		stack.setAlignment(Pos.CENTER);
		stack.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
		
		StackPane winnerStack = new StackPane();
		stack.setAlignment(Pos.CENTER);
		stack.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

		for (int j = 0; j <= 2; j++) {
			for (int i = 0; i <= 2; i++) {

				Rectangle rectangle = new Rectangle(300, 300);
				rectangle.setTranslateX(i * 300);
				rectangle.setTranslateY(j * 300);
				rectangle.setFill(Color.TRANSPARENT);
				rectangle.setStroke(Color.BLACK);

				Text text = new Text();
				text.setTranslateX(i * 300);
				text.setTranslateY(j * 300);
				text.setFont(Font.font(250));
				stack.getChildren().addAll(rectangle, text);

				final int row = i;
				final int column = j;

				rectangle.setOnMouseClicked(new EventHandler<Event>() {

					@Override
					public void handle(Event arg0) {

						if (!isGameOver()) {
							if (isPlayerX) {
								text.setText("X");
								isPlayerX = false;
							} else {
								text.setText("O");
								isPlayerX = true;
							}
						}

						values[row][column] = text.getText();

						if (isGameOver()) {
							
							Text label2 = new Text(
									"\t Game Over !! \n Winner is "
											+ (!isPlayerX ? "Player X"
													: "Player O"));
							label2.setFont(new Font("Cambria", 80));
							label2.setFill(Color.BLUEVIOLET);
							winnerStack.getChildren().add(label2);
							
							Timeline timeline = new Timeline();
							KeyFrame key1 = new KeyFrame(
									Duration.ZERO,
									new KeyValue(label2.translateXProperty(), 150),
									new KeyValue(label2.translateYProperty(), 0));
							KeyFrame key2 = new KeyFrame(new Duration(2000),
									new KeyValue(label2.translateXProperty(),
											150), new KeyValue(label2
											.translateYProperty(), 600));
							timeline.getKeyFrames().addAll(key1, key2);
							timeline.play();
							
							board.getChildren().add(winnerStack);
							stack.setDisable(true);
						
							
						}

					}
				});

			}
		}

		board.getChildren().addAll(stack);
	}

	private boolean isGameOver() {

		for (int j = 0; j < 3; j++) {

			if (!(values[0][j].isEmpty() && values[1][j].isEmpty() && values[2][j]
					.isEmpty()))
				if (values[0][j].equals(values[1][j])
						&& values[1][j].equals(values[2][j])) {
					return true;

				}
		}

		for (int i = 0; i < 3; i++) {

			if (!(values[i][0].isEmpty() && values[i][1].isEmpty() && values[i][2]
					.isEmpty()))
				if (values[i][0].equals(values[i][1])
						&& values[i][1].equals(values[i][2])) {
					return true;

				}

		}
		
		if (!(values[0][0].isEmpty() && values[1][1].isEmpty() && values[2][2]
				.isEmpty()))
			if (values[0][0].equals(values[1][1])
					&& values[1][1].equals(values[2][2])) {
				return true;

			}
		
		if (!(values[0][2].isEmpty() && values[1][1].isEmpty() && values[2][0]
				.isEmpty()))
			if (values[0][2].equals(values[1][1])
					&& values[1][1].equals(values[2][0])) {
				return true;

			}

		return false;
	}
}
