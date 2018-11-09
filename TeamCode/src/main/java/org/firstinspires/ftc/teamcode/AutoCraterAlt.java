package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Autonomous Test")
public class AutoCraterAlt extends LinearOpMode
{
    private GoldPositionDetector detector;

    @Override
    public void runOpMode() throws InterruptedException {

        Hardware robot = new Hardware(hardwareMap);
        robot.init();

        detector = new GoldPositionDetector("Test Detector");
        detector.init(hardwareMap.appContext, CameraViewDisplay.getInstance());
        detector.useDefaults();

        detector.downscale = 0.4; // How much to downscale the input frames

        // Optional Tuning
        detector.areaScoringMethod = DogeCV.AreaScoringMethod.MAX_AREA; // Can also be PERFECT_AREA
        //detector.perfectAreaScorer.perfectArea = 10000; // if using PERFECT_AREA scoring
        detector.maxAreaScorer.weight = 0.001;

        detector.ratioScorer.weight = 15;
        detector.ratioScorer.perfectRatio = 1.0;

        //FIXME make these appropriate to mounting position
        detector.leftX   = (detector.getAdjustedSize().width / 3);
        detector.rightX  = (detector.getAdjustedSize().width / 1.5);
        detector.threshY = (detector.getAdjustedSize().height / 2);

        detector.enable();

        while(!isStarted()) {
            telemetry.addData("Current Order" , detector.getPosition().name());
        }

        detector.disable();

        telemetry.addData("Final Order Choice" , detector.getLastPosition().name());

        ArmMethods.deHook();

        //FIXME add proper timings
        switch(detector.getLastPosition()) {
            case LEFT:
                DriveMethods.turnLeft(1); //turn to mineral
                Thread.sleep(500);

                DriveMethods.drive(1); //drive to mineral
                Thread.sleep(500);

                DriveMethods.drive(-1); //back out
                Thread.sleep(500);

                DriveMethods.turnRight(1); //turn to wall backwards
                Thread.sleep(500);

                DriveMethods.drive(1); //drive to wall
                Thread.sleep(500);

                DriveMethods.turnLeft(1); //turn to depot
                Thread.sleep(500);

                DriveMethods.drive(1); //drive to depot
                Thread.sleep(500);
                break;
            case RIGHT:
                DriveMethods.turnRight(1); //turn to mineral
                Thread.sleep(500);

                DriveMethods.drive(1); //drive to mineral
                Thread.sleep(500);

                DriveMethods.drive(-1); //back out
                Thread.sleep(500);

                DriveMethods.turnRight(1); //turn to wall backwards
                Thread.sleep(500);

                DriveMethods.drive(1); //drive to wall
                Thread.sleep(500);

                DriveMethods.turnLeft(1); //turn to depot
                Thread.sleep(500);

                DriveMethods.drive(1); //drive to depot
                Thread.sleep(500);
                break;
            case MIDDLE:
                DriveMethods.drive(1); //drive to mineral
                Thread.sleep(500);

                DriveMethods.drive(-1); //back out
                Thread.sleep(500);

                DriveMethods.turnRight(1); //turn to wall backwards
                Thread.sleep(500);

                DriveMethods.drive(-1); //drive to wall
                Thread.sleep(500);

                DriveMethods.turnLeft(1); //turn to depot
                Thread.sleep(500);

                DriveMethods.drive(-1); //drive to depot
                Thread.sleep(500);
                break;
        }

        ArmMethods.marker(); //depot marker

        DriveMethods.turnRight(1); //turn to other team's crater
        Thread.sleep(0);

        DriveMethods.drive(1); //drive to other teams's crater
        Thread.sleep(500);

        DriveMethods.drive(0);
    }
}