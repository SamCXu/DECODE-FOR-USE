package Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "leave")
public class Leave extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        ElapsedTime timer = new ElapsedTime();
        DcMotorEx motorFrontLeft, motorBackLeft, motorFrontRight, motorBackRight;
        motorFrontLeft = (DcMotorEx) hardwareMap.dcMotor.get("FL");
        motorBackLeft = (DcMotorEx) hardwareMap.dcMotor.get("BL");
        motorFrontRight = (DcMotorEx) hardwareMap.dcMotor.get("FR");
        motorBackRight = (DcMotorEx) hardwareMap.dcMotor.get("BR");

        motorFrontLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        motorBackLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        motorFrontRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        motorBackRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        motorBackLeft.setDirection(DcMotorEx.Direction.REVERSE);
        motorFrontLeft.setDirection(DcMotorEx.Direction.REVERSE);



        motorFrontLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorBackLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorFrontRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorBackRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        waitForStart();
        timer.reset();
        while (timer.seconds() < 1) {
            motorFrontLeft.setPower(0.5);
            motorFrontRight.setPower(0.5);
            motorBackLeft.setPower(0.5);
            motorBackRight.setPower(0.5);
        }
        motorFrontLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorBackLeft.setPower(0);
        motorBackRight.setPower(0);

    }
}
