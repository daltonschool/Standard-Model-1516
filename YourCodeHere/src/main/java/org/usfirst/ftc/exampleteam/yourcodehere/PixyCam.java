/**
 * (c) FTC Team 9372 - Standard Model
 * Friday, March 4th, 2016
 *
 */
package org.usfirst.ftc.exampleteam.yourcodehere;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.I2cController;

import org.swerverobotics.library.internal.I2cDeviceClient;
import org.swerverobotics.library.internal.II2cDevice;

import java.util.HashMap;

public class PixyCam {


    I2cDeviceClient deviceClient;

    HashMap<Integer, PixyObject> objects = new HashMap<Integer, PixyObject>(); // Using a hashmap means
                                                                                //we only keep one of each signature object
                                                                            //which I think is what we want for now.
                                                                            //this might change in which case I will use an ArrayList


    public PixyCam(OpMode context, II2cDevice ii2cDevice) {
        int i2cAddr8Bit = 0x54;
        boolean closeOnOpModeStop = true;

        deviceClient = new I2cDeviceClient(context, ii2cDevice, i2cAddr8Bit, closeOnOpModeStop);

    }


    private byte readByte() {
        int ireg = 0;
        return deviceClient.read8(ireg);
    }

    private void getStart() {

        int startSignature = 0xaa55;

        int ireg = 0;

        while(readByte() != startSignature);

        byte b2 = readByte(); //get the second part of the start

        if(b2 != startSignature) { //synchronize w/ start of packet
            getStart();
        }
    }

    private int readTwoBytes() {
        int twobytes = readByte() + (readByte() << 8);
        return twobytes;
    }

    //for now only keep one of each type of object in our data banks
    public void getObject() {
        getStart();

        int checksum = readTwoBytes(); //need to check to make sure checksum is proper

        int signature = readTwoBytes();


        int x = readTwoBytes();
        int y = readTwoBytes();

        int width = readTwoBytes();
        int height = readTwoBytes();


        PixyObject pixyObject = new PixyObject(x, y, width, height, signature);

        objects.put(signature, pixyObject);
    }

    public PixyObject getObjectForSignature(int sig) {
        return objects.get(sig);
    }

}