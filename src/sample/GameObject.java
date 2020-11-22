package sample;


import javafx.scene.image.ImageView;

public abstract class GameObject {
    protected ImageView avatar;

    protected double axisX;
    protected double axisY;

    protected double width;
    protected double height;

    public GameObject() {

    }

    public GameObject(ImageView avatar_) {

    }

    public ImageView getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageView avatar) {
        this.avatar = avatar;
        axisX = avatar.getX();
        axisY = avatar.getY();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getAxisX() {
        return axisX;
    }

    public void setAxisX(double axisX) {
        this.axisX = axisX;
    }

    public double getAxisY() {
        return axisY;
    }

    public void setAxisY(double axisY) {
        this.axisY = axisY;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }


}
