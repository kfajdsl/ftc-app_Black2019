/*
 * Copyright (c) 2018 Titan Robotics Club (http://www.titanrobotics.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Mecanum {
    //Credit to FTC forums user mlwilliams for the following code.
    //https://ftcforum.usfirst.org/forum/ftc-technology/android-studio/7025-need-help-with-teleop-code-for-mecanum-wheels
    public static void mecanumDrive(double speed, double direction, double rotation) {
        Hardware.leftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Hardware.rightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Hardware.leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Hardware.rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        Hardware.leftFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Hardware.rightFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Hardware.leftBackDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Hardware.rightBackDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        final double v1 = speed * Math.cos(direction) + rotation;
        final double v2 = speed * Math.sin(direction) - rotation;
        final double v3 = speed * Math.sin(direction) + rotation;
        final double v4 = speed * Math.cos(direction) - rotation;

        Hardware.leftFrontDrive.setPower(v1);
        Hardware.rightFrontDrive.setPower(v2);
        Hardware.leftBackDrive.setPower(v3);
        Hardware.rightBackDrive.setPower(v4);
    }
}
