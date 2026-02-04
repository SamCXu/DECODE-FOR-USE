package mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Transfer {
    private DcMotorEx transferMotor;
    private Telemetry telemetry;

    public Transfer(HardwareMap hardwareMap, Telemetry telemetry) {
        transferMotor = (DcMotorEx) hardwareMap.dcMotor.get("transferMotor");

        transferMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        transferMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        transferMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        //intakeMotor.setDirection(DcMotorSimple.Direction.REVERSE); // later

        this.telemetry = telemetry;
    }

    public void intake() {
        transferMotor.setPower(1);
    }
    public void outtake() {
        transferMotor.setPower(-1);
    }
    public void rest() {
        transferMotor.setPower(0);
    }
}
