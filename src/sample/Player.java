package sample;

import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.awt.font.ImageGraphicAttribute;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Player extends GameObject  {
    private final String walkLeftPath = "file:game_sprite/walkleft/walkleft";
    private final String walkRightPath = "file:game_sprite/walkright/walkright";
    private final String walkUpPath = "file:game_sprite/walkup/walkup";
    private final String walkDownPath = "file:game_sprite/walkdown/walkdown";
    private final String deathPath = "file:game_sprite/death/death";

    private int speed = 400;
    private long delay = 0;
    private double realSpeed = 0.1;

    public Player() {

    }

    public Player(ImageView img_) {
        this.axisX = img_.getX();
        this.axisY = img_.getY();
        this.width = 30;
        this.height = 48;
        this.avatar = img_;
    }
    public boolean checkLegitMove(double x, double y, Map map) {
        boolean state = true;
        if (x + avatar.getFitWidth() > 1024 - 30|| y + avatar.getFitHeight() > 768 - 48|| x < 0 || y < 200) {
            state = false;
        }
        for (Table table : map.getTables()) {
            if (table.CheckCollision(x, y, this)) {
                state = false;
            }
        }
        return state;
    }

    public double getRealSpeed() {
        return realSpeed;
    }

    public void setRealSpeed(double realSpeed) {
        this.realSpeed = realSpeed;
    }

    public void Walk(int direction, Map map) {
        switch (direction) {
            case 1: {
                if (checkLegitMove(axisX + 1, axisY, map)) {

                    List<Image> images = new ArrayList<>();
                    for (int i = 1; i <= 9; i++) {
                        images.add(new Image(walkRightPath + i + ".png"));
                    }

                    Transition transition = new Transition() {
                        {
                            setCycleDuration(Duration.millis(speed));
                        }
                        @Override
                        protected void interpolate(double v) {
                            if (checkLegitMove(axisX + realSpeed, axisY, map)) {
                                axisX = axisX + realSpeed;
                                avatar.setX(axisX);
                            }
                            int index = (int) (v * (images.size() - 1));
                            avatar.setImage(images.get(index));
                        }
                    };

                    transition.play();
                    try {
                        Thread.sleep(delay);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                };
                break;
            }

            case 2: {
                if (checkLegitMove(axisX - 1, axisY, map)) {
                    List<Image> images = new ArrayList<>();
                    for (int i = 1; i <= 9; i++) {
                        images.add(new Image(walkLeftPath + i + ".png"));
                    }

                    Transition transition = new Transition() {
                        {
                            setCycleDuration(Duration.millis(speed));
                        }
                        @Override
                        protected void interpolate(double v) {
                            if (checkLegitMove(axisX - realSpeed, axisY, map)) {
                                axisX = axisX - realSpeed;
                                avatar.setX(axisX);
                            }
                            int index = (int) (v * (images.size() - 1));
                            avatar.setImage(images.get(index));
                        }
                    };

                    transition.play();
                    try {
                        Thread.sleep(delay);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                break;
            }

            case 3: {
                if (checkLegitMove(axisX, axisY - 1, map)) {
                    List<Image> images = new ArrayList<>();
                    for (int i = 1; i <= 9; i++) {
                        images.add(new Image(walkUpPath + i + ".png"));
                    }

                    Transition transition = new Transition() {
                        {
                            setCycleDuration(Duration.millis(speed));
                        }
                        @Override
                        protected void interpolate(double v) {
                            if (checkLegitMove(axisX, axisY - realSpeed, map)) {
                                axisY = axisY - realSpeed;
                                avatar.setY(axisY);
                            }
                            int index = (int) (v * (images.size() - 1));
                            avatar.setImage(images.get(index));
                        }
                    };

                    transition.play();
                    try {
                        Thread.sleep(delay);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                break;
            }

            case 4: {
                if (checkLegitMove(axisX, axisY + 1, map)) {
                    List<Image> images = new ArrayList<>();
                    for (int i = 1; i <= 9; i++) {
                        images.add(new Image(walkDownPath + i + ".png"));
                    }

                    Transition transition = new Transition() {
                        {
                            setCycleDuration(Duration.millis(speed));
                        }
                        @Override
                        protected void interpolate(double v) {
                            if (checkLegitMove(axisX, axisY + realSpeed, map)) {
                                axisY = axisY + realSpeed;
                                avatar.setY(axisY);
                            }
                            int index = (int) (v * (images.size() - 1));
                            avatar.setImage(images.get(index));
                        }
                    };

                    transition.play();
                    try {
                        Thread.sleep(delay);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                break;
            }
        }
    }

    public void Death() {
        List<Image> images = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            images.add(new Image(deathPath + i + ".png"));
        }

        Transition transition = new Transition() {
            {
                setCycleDuration(Duration.millis(2000));
            }
            @Override
            protected void interpolate(double v) {
                int index = (int) (v * (images.size() - 1));
                avatar.setImage(images.get(index));
            }
        };
        transition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                avatar.setVisible(false);
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        transition.play();
    }
}
