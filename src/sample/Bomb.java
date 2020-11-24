package sample;


import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Bomb {
    public void Setted(Player player) {
        Transition transition = new Transition() {
            {
                setCycleDuration(Duration.millis(2000));
            }
            @Override
            protected void interpolate(double v) {

            }
        };

        transition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Explode(player);
            }
        });

        transition.play();
    }

    public void Explode(Player player) {
        player.Death();
    }
}
