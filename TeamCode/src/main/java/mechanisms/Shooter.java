package mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter {
    private DcMotorEx shooter;
    private DcMotorEx shooter2;
    private Telemetry telemetry;

    public Shooter(HardwareMap hardwareMap, Telemetry telemetry) {
        shooter = (DcMotorEx) hardwareMap.dcMotor.get("shooter");
        shooter2 = (DcMotorEx) hardwareMap.dcMotor.get("shoote2");


        shooter.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        shooter2.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        shooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        shooter2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        shooter.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        shooter2.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        shooter2.setDirection(DcMotorSimple.Direction.REVERSE);
        //intakeMotor.setDirection(DcMotorSimple.Direction.REVERSE); // later

        this.telemetry = telemetry;
    }

    public void intake() {
        shooter2.setPower(1);
        shooter.setPower(1);
    }
    public void outtake() {
        shooter2.setPower(-0.55);
        shooter.setPower(-0.55);
    }
    public void outtake2() {
        shooter2.setPower(-0.56);
        shooter.setPower(-0.56);
    }
    public void outtakeStronk() {
        shooter2.setPower(-0.9);
        shooter.setPower(-0.9);
    }
    public void outtakeAuto() {
        shooter2.setPower(-0.5);
        shooter.setPower(-0.5);
    }
    public void rest() {
        shooter.setPower(0);
        shooter2.setPower(0);
    }
}
