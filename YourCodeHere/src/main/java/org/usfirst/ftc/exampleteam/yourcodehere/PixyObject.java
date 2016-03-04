package org.usfirst.ftc.exampleteam.yourcodehere;

/**
 * Created by nathaniel on 3/4/16.
 */
public class PixyObject {

    int x, y;
    int width, height;

    int signature;

    public PixyObject(int x, int y, int width, int height, int signature) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.signature = signature;
    }

    int getX() {
        return this.x;
    }
    int getY() {
        return this.y;
    }
    int getWidth() {
        return this.width;
    }
    int getHeight() {
        return this.height;
    }
    int getSignature() {
        return this.signature;
    }
    void setX(int x) {
        this.x = x;
    }
    void setY(int y) {
        this.y = y;
    }
    void setWidth(int width) {
        this.width = width;
    }
    void setHeight(int height) {
        this.height = height;
    }
    void setSignature(int signature) {
        this.signature = signature;
    }


}
