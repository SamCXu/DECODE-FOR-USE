package TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;


@TeleOp(name = "TestTeleOp")
public class TestTeleOp extends LinearOpMode {



    //DO NOT MODIFY THIS CLASS WHATSOEVER UNLESS AUTHORIZED-> MAKE A COPY
    private DcMotorEx motorFrontLeft, motorBackLeft, motorFrontRight, motorBackRight;





    private void initialize() {

        motorFrontLeft = (DcMotorEx) hardwareMap.dcMotor.get("FL");
        motorBackLeft = (DcMotorEx) hardwareMap.dcMotor.get("BL");
        motorFrontRight = (DcMotorEx) hardwareMap.dcMotor.get("FR");
        motorBackRight = (DcMotorEx) hardwareMap.dcMotor.get("BR");

        motorFrontLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        motorBackLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        motorFrontRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        motorBackRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
    }




    @Override
    public void runOpMode() {

        initialize();
        while (opModeInInit()) {
        }
        while (opModeIsActive()) {
            if(gamepad1.dpad_up) {
                motorBackLeft.setPower(1);
            }
            else if(gamepad1.dpad_down) {
                motorBackRight.setPower(1);
            }
            else if(gamepad1.dpad_right) {
                motorFrontRight.setPower(1);
            }
            else if(gamepad1.dpad_left) {
                motorFrontLeft.setPower(1);
            }
            else {
                motorFrontLeft.setPower(0);
                motorFrontRight.setPower(0);
                motorBackRight.setPower(0);
                motorBackLeft.setPower(0);

            }
        }

    }

}