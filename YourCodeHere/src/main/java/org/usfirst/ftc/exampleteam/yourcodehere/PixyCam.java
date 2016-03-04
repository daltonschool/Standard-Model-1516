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



    public PixyCam(OpMode context, II2cDevice ii2cDevice) {
        int i2cAddr8Bit = 127; // Just a guess, I think we set this from pixymon
        boolean closeOnOpModeStop = true;

        I2cDeviceClient deviceClient = new I2cDeviceClient(context, ii2cDevice, i2cAddr8Bit, closeOnOpModeStop);

    }





}