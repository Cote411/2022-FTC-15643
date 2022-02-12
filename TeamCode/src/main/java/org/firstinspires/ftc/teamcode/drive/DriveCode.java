package org.firstinspires.ftc.teamcode.drive;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "drive stuffs")
public class DriveCode extends OpMode {

    SampleMecanumDrive drive;

    @Override
    public void init() {
        drive = new SampleMecanumDrive(hardwareMap);

        drive.spinner.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        drive.turntable.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        drive.lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        drive.spinner.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        drive.turntable.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        drive.lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



    }

    @Override
    public void loop() {
        setVelocity();
        if(gamepad1.a){
            drive.intake.setPower(1);
        }else if(gamepad1.b){
            drive.intake.setPower(-1);
        }else{
            drive.intake.setPower(0);
        }

        if(gamepad2.dpad_left){
            drive.turntable.setTargetPosition(-268);
            drive.turntable.setPower(-0.3);
        }else if(gamepad2.dpad_right){
            drive.turntable.setPower(0.3);
        }else{
            drive.turntable.setPower(0);
        }
        if(gamepad2.x){
            drive.intake.setPower(1);
        }else {
            drive.intake.setPower(0);
        }

        if(gamepad2.right_trigger != 0){
            drive.lift.setPower(1);
        }else if(gamepad2.left_trigger != 0){
            drive.lift.setPower(-1);
        }else{
            drive.lift.setPower(0);
        }
        telemetry.addData("port for flipIntake:", drive.flipIntake.getPortNumber());
        telemetry.update();

        if(gamepad2.right_bumper){
            drive.flipIntake.setPosition(0);
        }else{
            drive.flipIntake.setPosition(1);
        }
        if(gamepad2.left_bumper){
            drive.angleChanger.setPosition(0.25);
        }else{
            drive.angleChanger.setPosition(1);
        }
    }

    public void setVelocity(){

        drive.rightFront.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x);
        drive.leftFront.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x);
        drive.leftRear.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x);
        drive.rightRear.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x);

    }
}

