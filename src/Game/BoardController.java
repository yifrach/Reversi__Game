package Game;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class BoardController extends GridPane implements Print{

    private Board board;
    private Print cellPrint;

    /**
     * Constructor, get a Board
     * @param board- getting a Board
     */
    public BoardController(Board board) {
        this.board=board;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(" Board.fxml "));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

     /**
     * Printing the board at its current state
     */
    public void print() {
        String line = "----";
        System.out.print("\n");
        for (int i = 0; i < this.board.getSize() + 1; i++) {
            for (int j = 0; j < this.board.getSize() + 1; j++) {
                if ((i == 0) && (j == 0)) {
                    System.out.print("  ");
                } else if ((i == 0) && (j != 0)) {
                    System.out.print(j);
                } else if ((i != 0) && (j == 0)) {
                    System.out.print(" "+i);
                } else {
                    this.cellPrint=new CellPrint(this.board.cellMatrix[i][j].getColor());
                    this.cellPrint.print();
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
            for (int j = 0; j < this.board.getSize() + 1; j++) {
                System.out.print(line);
            }
            System.out.print("\n");
        }
    }

    public void draw() {
        this.getChildren().clear();
        int height = (int) this.getPrefHeight();
        int width = (int) this.getPrefWidth();
        int cellHeight = height / board.getSize();
        int cellWidth = width / board.getSize();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (this.board.cellMatrix[i][j].getColor() == CellColor.empty)
                    this.add(new Rectangle(cellWidth, cellHeight, Color.WHITE), j, i);
                else
                    this.add(new Rectangle(cellWidth, cellHeight, Color.BLACK), j, i);
            }
        }
    }
}