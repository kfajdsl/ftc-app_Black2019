package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Turns are time based because calibration takes too long
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

@Autonomous(name="DepotTimed", group="HopeBot")
public class TimeDepotAuto extends LinearOpMode {
    Hardware robot = new Hardware();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        DriveMethods.driveDist(-42);
        DriveMethods.timeTurnLeft(3); //FIXME needs correct time, this is placeholder/guess
        DriveMethods.driveDist(-66);

        LiftMethods.raiseLift();
        ArmMethods.raiseArm();
        Thread.sleep(500);
        ArmMethods.lowerArm();
        LiftMethods.lowerLift();

        DriveMethods.driveDist(88);

    }
}
