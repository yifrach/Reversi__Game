package Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.List;

public class ReversiBoardController extends GridPane {
    private BoardScanner scanner;

    public ReversiBoardController(BoardScanner scanner) {
        this.scanner = scanner;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReversiBoard.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void draw() {
        this.getChildren().clear();
        int height = (int) this.getPrefHeight();
        int width = (int) this.getPrefWidth();

        int cellHeight = height / this.scanner.getBoardSize();
        int cellWidth = width / this.scanner.getBoardSize();

        for (int i = 1; i <= this.scanner.getBoardSize(); i++) {
            for (int j = 1; j <= this.scanner.getBoardSize(); j++) {
                StackPane cell = new StackPane();
                Rectangle rect = new Rectangle(cellWidth, cellHeight, Color.BEIGE);
                rect.setStroke(Color.DARKGRAY);
                cell.getChildren().add(rect);
                if (this.scanner.getBoardMatrix()[i][j].getColor() != PlayerNumber.empty) {
                    Color cellColor = this.scanner.getBoardMatrix()[i][j].getActualColor();
                    double radius = Math.min(cellWidth / 2, cellHeight / 2);
//                    Ellipse ellipse = new Ellipse(radius, radius, radius, radius);
//                    ellipse.setStroke(Color.BLACK);
//                    ellipse.setFill(Color.LIGHTGRAY);
//                    cell.getChildren().add(ellipse);
                    Circle disk = new Circle(radius, cellColor);
                    disk.setStroke(Color.BLACK);
                    cell.getChildren().add(disk);
                }
                for (int k = 0; k < this.scanner.getPointsVector().size(); k++) {
                    if ((this.scanner.getPointsVector().get(k).getX() == i) &&
                            (this.scanner.getPointsVector().get(k).getY() == j)) {
                        double radius = Math.min(cellWidth / 2, cellHeight / 2);
                        Circle possibleMove = new Circle(radius, Color.TRANSPARENT);
                        possibleMove.setStroke(Color.BLACK);
                        cell.getChildren().add(possibleMove);
                    }
                }
                this.add(cell, j, i);
            }
        }
    }

    public int getBoardSize() {
        return this.scanner.getBoardSize();
    }

}
