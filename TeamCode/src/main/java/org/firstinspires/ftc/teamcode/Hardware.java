package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by shrey on 2018-09-12.
 * Modified by Sahan Reddy on 2018-11-02
*/
public class Hardware {

    public static DcMotor leftBackDrive;
    public static DcMotor leftMidDrive;
    public static DcMotor rightBackDrive;
    public static DcMotor rightMidDrive;
    public static DcMotor arm;
    public static DcMotor lift;

    public static CRServo intake;
    //public static DcMotor intake;

    HardwareMap hwMap;

    public Hardware(HardwareMap hwmap){
        this.hwMap = hwMap;
    }

    public void init() {

        leftBackDrive = hwMap.get(DcMotor.class, "left_back_drive");
        leftMidDrive = hwMap.get(DcMotor.class, "left_mid_drive");
        rightBackDrive = hwMap.get(DcMotor.class, "right_back_drive");
        rightMidDrive = hwMap.get(DcMotor.class, "right_mid_drive");

        arm = hwMap.get(DcMotor.class, "arm");
        lift = hwMap.get(DcMotor.class, "lift");

        intake = hwMap.get(CRServo.class, "intake");
        //intake = hwMap.get(DcMotor.class, "intake");


        // no idea if I got my directions right, this will probably change.
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        leftMidDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightMidDrive.setDirection(DcMotor.Direction.FORWARD);

        arm.setDirection(DcMotor.Direction.FORWARD);
        lift.setDirection(DcMotor.Direction.FORWARD);
        intake.setDirection(CRServo.Direction.REVERSE);


        leftBackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftMidDrive. setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMidDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftBackDrive.setPower(0);
        leftMidDrive.setPower(0);
        rightBackDrive.setPower(0);
        rightMidDrive.setPower(0);

        arm.setPower(0);
        lift.setPower(0);
        intake.setPower(0);

    }
}
