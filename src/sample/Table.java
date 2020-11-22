package sample;

public class Table extends GameObject {
    private final double width = 82;
    private final double height = 63;

    public boolean CheckCollision(double x, double y, Player ava) {
        boolean state = false;
        if ((x + ava.getWidth() > this.axisX && x + ava.getWidth() < this.axisX + this.width) || (x > this.axisX && x < this.axisX + this.width)) {
            if ((y + ava.getHeight() > this.axisY && y + ava.getHeight() < this.axisY + this.height) || (y > this.axisY && y < this.axisY + this.height)) {
                state = true;
            }
        }

        return state;
    }
}
