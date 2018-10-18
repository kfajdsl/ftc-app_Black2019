package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vuforia.ar.pl.DrawOverlayView;

@Autonomous
public class AutoDepot extends LinearOpMode {
    Hardware robot = new Hardware();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //Wait for game to start

        waitForStart();

        //FIXME add values here
        //need to add distances and degrees, which I don't have. This is the basic skeleton of the path.
        DriveMethods.driveDist(); //Drive to right most sample
        DriveMethods.turn(); //turn left so right side (color sensor) is facing samples

        boolean foundGold = false;

        if (Hardware.colorSensor.red() < Hardware.colorSensor.blue() + 150) { //FIXME calibrate color
            foundGold = true;
            DriveMethods.turn(); //turn into 1st sample
            DriveMethods.driveDist(); //run into 1st sample
            DriveMethods.turn(); //turn towards depot
            DriveMethods.driveDist(); //drive to depot


        }

        DriveMethods.driveDist(); //drive to next sample


    }
}
