package sample;

import javafx.animation.Transition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        final String imgPath = "file:walkcolor00";
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        AnchorPane field = (AnchorPane) root.lookup("#field");
        ImageView player = (ImageView) root.lookup("#player");
        ImageView enemy = new ImageView(new Image("file:game_sprite/walkdown/walkdown1.png"));
        enemy.setX(500);
        enemy.setY(500);
        field.getChildren().add(enemy);
        Map map = new Map();
        ImageView img1 = new ImageView();
        img1.setImage(new Image("file:game_sprite/table.png"));
        img1.setX(500);
        img1.setY(300);
        Table table1 = new Table();
        table1.setAvatar(img1);
        map.getTables().add(table1);
        for (Table table : map.getTables()) {
            field.getChildren().add(table.avatar);
        }
        Player player1 = new Player(player);
        Enemy ene = new Enemy(enemy);
        final int[] numOfBomb = {0};
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case E: {
                        ene.Walk(ene.Tracking(player1), map);
                        break;
                    }
                    case UP: {
                        player1.Walk(3, map);
                        break;
                    }

                    case DOWN: {
                        player1.Walk(4, map);
                        break;
                    }

                    case RIGHT: {
                        player1.Walk(1, map);
                        break;
                    }

                    case LEFT: {
                        player1.Walk(2, map);
                        break;
                    }

                    case D: {
                        player1.Death();
                        break;
                    }
                }
            }
        });
        Scene scene = new Scene(root, 1024, 768);
        primaryStage.setTitle("FREE BOMB");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
