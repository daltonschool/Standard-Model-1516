package org.usfirst.ftc.exampleteam.yourcodehere;

import org.swerverobotics.library.SynchronousOpMode;
import org.swerverobotics.library.internal.AdaFruitTCS34725ColorSensor;

import com.qualcomm.hardware.adafruit.AdafruitI2cColorSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by nathaniel on 3/10/16.
 */
public class TestColorSensor extends SynchronousOpMode {


    public void main () throws InterruptedException {

        waitForStart();

        AdafruitI2cColorSensor colorSensor = new AdafruitI2cColorSensor(boooop);

        AdaFruitTCS34725ColorSensor.create(this, colorSensor);

    }

}
