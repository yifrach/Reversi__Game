package Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class ReversiBoardController extends GridPane {
    private BoardScanner scanner;

    /**
     * Constructor for our GUI board.
     *
     * @param scanner - the boards scanner.
     */
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

    /**
     * Drawing our GUI board on screen.
     */
    public void draw() {
        this.getChildren().clear();
        int height = (int) this.getPrefHeight();
        int width = (int) this.getPrefWidth();
        // Setting each cells preferred height and width
        int cellHeight = height / this.scanner.getBoardSize();
        int cellWidth = width / this.scanner.getBoardSize();
        // Drawing our GUI board going over each cell
        for (int i = 1; i <= this.scanner.getBoardSize(); i++) {
            for (int j = 1; j <= this.scanner.getBoardSize(); j++) {
                StackPane cell = new StackPane();
                cell.getChildren().removeAll();
                Rectangle rect = new Rectangle(cellWidth, cellHeight, Color.BEIGE);
                rect.setStroke(Color.DARKGRAY);
                // Adding each rectangle to our stack pane
                cell.getChildren().add(rect);
                // If the this board cell has a disk
                if (this.scanner.getBoardMatrix()[i][j].getColor() != PlayerNumber.empty) {
                    // We'll draw the disk
                    Color cellColor = this.scanner.getBoardMatrix()[i][j].getActualColor();
                    // Adjusting the disks radius to be dynamic
                    double radius = Math.min(cellWidth / 2, cellHeight / 2);
                    radius -= radius / 4;
                    Circle disk = new Circle(radius, cellColor);
                    disk.setStroke(Color.BLACK);
                    disk.setStrokeWidth(2);
                    DropShadow dropShadow = new DropShadow();
                    dropShadow.setOffsetY(radius / 4);
                    dropShadow.setOffsetX(-(radius / 4));
                    disk.setEffect(dropShadow);
                    cell.getChildren().add(disk);
                }
                // Lastly drawing up the users possible moves
                for (int k = 0; k < this.scanner.getPointsVector().size(); k++) {
                    if ((this.scanner.getPointsVector().get(k).getX() == i) &&
                            (this.scanner.getPointsVector().get(k).getY() == j)) {
                        // Creating an empty disk and drawing it
                        double radius = Math.min(cellWidth / 2, cellHeight / 2);
                        radius -= radius / 4;
                        Circle possibleMove = new Circle(radius, Color.TRANSPARENT);
                        possibleMove.setStroke(Color.BLACK);
                        cell.getChildren().add(possibleMove);
                    }
                }
                // Adding the stack pane to the HBox
                this.add(cell, j, i);
            }
        }
    }

    /**
     * Getter for our boards size.
     *
     * @return - the boards size.
     */
    public int getBoardSize() {
        return this.scanner.getBoardSize();
    }
}
