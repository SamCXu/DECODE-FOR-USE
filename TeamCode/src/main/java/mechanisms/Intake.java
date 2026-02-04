package mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    private DcMotorEx intakeMotor;
    private Telemetry telemetry;

    public Intake(HardwareMap hardwareMap, Telemetry telemetry) {
        intakeMotor = (DcMotorEx) hardwareMap.dcMotor.get("intakeMotor");

        intakeMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        intakeMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        //intakeMotor.setDirection(DcMotorSimple.Direction.REVERSE); // later

        this.telemetry = telemetry;
    }

    public void intake() {
        intakeMotor.setPower(-1);
    }
    public void outtake() {
        intakeMotor.setPower(1);
    }
    public void rest() {
        intakeMotor.setPower(0);
    }
}
