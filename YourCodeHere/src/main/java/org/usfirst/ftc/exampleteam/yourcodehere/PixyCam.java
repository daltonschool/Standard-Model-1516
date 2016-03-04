/**
 * (c) FTC Team 9372 - Standard Model
 * Friday, March 4th, 2016
 *
 */
package org.usfirst.ftc.exampleteam.yourcodehere;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.swerverobotics.library.internal.I2cDeviceClient;
import org.swerverobotics.library.internal.II2cDevice;

public class PixyCam {


    I2cDeviceClient deviceClient;


    public PixyCam(OpMode context, II2cDevice ii2cDevice) {
        int i2cAddr8Bit = 127; // Just a guess, I think we set this from pixymon
        boolean closeOnOpModeStop = true;

        deviceClient = new I2cDeviceClient(context, ii2cDevice, i2cAddr8Bit, closeOnOpModeStop);

    }


    private byte readByte() {
        int ireg = 0;
        return deviceClient.read8(ireg);
    }

    private void getStart() {
        int ireg = 0;

        while(readByte() != 0xaa55);
        readByte(); //get the second part of the start
    }

    private int readTwoBytes() {
        int twobytes = readByte() + (readByte() << 8);
        return twobytes;
    }

    public void getObject() {
        getStart();

        int checksum = readTwoBytes(); //need to check to make sure checksum is proper

        int signature = readTwoBytes();


        int x = readTwoBytes();
        int y = readTwoBytes();

        int width = read

    }




}