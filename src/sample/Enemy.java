package sample;

import javafx.scene.image.ImageView;

public class Enemy extends Player{
    public Enemy(ImageView img_) {
        this.avatar = img_;
        this.width = 30;
        this.height = 48;

        this.axisX = img_.getX();
        this.axisY = img_.getY();
    }

    public double Distance(double x, double y, Player player) {
        return Math.sqrt((x - player.axisX) * (x - player.axisX) + (y - player.axisY) * (y - player.axisY));
    }

    public int Tracking(Player player) {
        double listOfChoice[] = new double[5];
        listOfChoice[1] = Distance(axisX + this.getRealSpeed(), axisY, player);
        listOfChoice[2] = Distance(axisX - this.getRealSpeed(), axisY, player);
        listOfChoice[3] = Distance(axisX, axisY - this.getRealSpeed(), player);
        listOfChoice[4] = Distance(axisX, axisY + this.getRealSpeed(), player);
        int min = 1;
        for (int i = 2; i <= 4; i++) {
            if (listOfChoice[min] > listOfChoice[i]) {
                min = i;
            }
        }
        return min;
    }

}
