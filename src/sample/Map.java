package sample;

import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private AnchorPane mapIns;

    private List<Table> tables = new ArrayList<>();
    private List<Bomb> bombs = new ArrayList<>();
    private final double xMax = 1024;
    private final double yMax = 768;

    public void Init() {

    };

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public void setBombs(List<Bomb> bombs) {
        this.bombs = bombs;
    }

    public double getxMax() {
        return xMax;
    }

    public double getyMax() {
        return yMax;
    }
}
