package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class AutoCrater extends LinearOpMode {
    Hardware robot = new Hardware();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //Wait for game to start

        waitForStart();

        //FIXME add values in the driveDist() and turn() statements based on the exact path of bot.
        //need to add distances and degrees, which I don't have. This is the basic skeleton of the path.
        DriveMethods.driveDist(); //Drive to right most sample
        DriveMethods.turn(); //turn left so right side (color sensor) is facing samples

        boolean foundGold = false;

        if (SensorMethods.isGold()) {
            foundGold = true;
            telemetry.addData("Sampling", "Found gold at first position");
            telemetry.update();
            DriveMethods.turn(); //turn into 1st sample
            DriveMethods.driveDist(); //run into 1st sample
            DriveMethods.driveDist(); //back out
            DriveMethods.turn(); //turn towards in angle to wall near depot
            DriveMethods.driveDist(); //drive so as to not push other samples
            DriveMethods.turn(); //turn towards depot
            DriveMethods.driveDist(); //drive to depot
            DriveMethods.turn(); //turn to proper orientation
        }

        //this is pasghetti. TODO clean up this code
        if (!foundGold) {
            DriveMethods.driveDist(); //drive to 2nd sample
            if (SensorMethods.isGold()) {
                foundGold = true;
                telemetry.addData("Sampling", "Found gold at second position");
                telemetry.update();
                DriveMethods.turn(); //turn into 1st sample
                DriveMethods.driveDist(); //run into 1st sample
                DriveMethods.driveDist(); //back out
                DriveMethods.turn(); //turn towards in angle to wall near depot
                DriveMethods.driveDist(); //drive so as to not push other samples
                DriveMethods.turn(); //turn towards depot
                DriveMethods.driveDist(); //drive to depot
                DriveMethods.turn(); //turn to proper orientation
            }
            if (!foundGold) {
                DriveMethods.driveDist(); //drive to 3rd sample
                if (SensorMethods.isGold()) {
                    foundGold = true;
                    telemetry.addData("Sampling", "Found gold at third position");
                    telemetry.update();
                    DriveMethods.turn(); //turn into 1st sample
                    DriveMethods.driveDist(); //run into 1st sample
                    DriveMethods.turn(); //turn towards in angle to wall near depot
                    DriveMethods.driveDist(); //drive so as to not push other samples
                    DriveMethods.turn(); //turn towards depot
                    DriveMethods.driveDist(); //drive to depot
                    DriveMethods.turn(); //turn to proper orientation
                }
                if (!foundGold) { //color sensor sampling failed, go around minerals and hope alliance teammate does sample
                    telemetry.addData("Sampling", "Did not find gold. Continuing.");
                    telemetry.update();
                    DriveMethods.driveDist(); //drive ahead of 3rd sample
                    DriveMethods.turn(); //turn towards in angle to wall near depot
                    DriveMethods.driveDist(); //drive so as to not push other samples
                    DriveMethods.turn(); //turn to depot
                    DriveMethods.driveDist(); //drive to depot
                    DriveMethods.turn(); //turn to proper orentation
                }
            }
        }

        //Deposit marker
        LiftMethods.raiseLift();
        ArmMethods.raiseArm();
        sleep(300);
        ArmMethods.lowerArm();
        LiftMethods.lowerLift();
        telemetry.addData("Depot", "Dropped Marker");
        telemetry.update();
        //Drive to crater
        DriveMethods.driveDist();
        telemetry.addData("Parked", "Parked in crater");
        telemetry.addData("Status", "Finished");

    }


}

