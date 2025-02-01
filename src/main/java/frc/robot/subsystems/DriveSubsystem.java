// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  
  public final CANSparkMax leftFrontMotor = new CANSparkMax(Constants.OperatorConstants.LEFT_FRONT_MOTOR_ID,MotorType.kBrushed);
  public final CANSparkMax rightFrontMotor = new CANSparkMax(Constants.OperatorConstants.RIGHT_FRONT_MOTOR_ID,MotorType.kBrushed);
  public final CANSparkMax leftBackMotor = new CANSparkMax(Constants.OperatorConstants.LEFT_BACK_MOTOR_ID,MotorType.kBrushed);
  public final CANSparkMax rightBackMotor = new CANSparkMax(Constants.OperatorConstants.RIGHT_BACK_MOTOR_ID,MotorType.kBrushed);
  public final CANSparkMax coralMotor = new CANSparkMax(Constants.OperatorConstants.CORAL_MOTOR_ID,MotorType.kBrushed);
  private final DifferentialDrive differentialDrive;
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    leftFrontMotor.restoreFactoryDefaults();
    rightFrontMotor.restoreFactoryDefaults();
    leftBackMotor.restoreFactoryDefaults();
    rightBackMotor.restoreFactoryDefaults();

    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);

    rightFrontMotor.setInverted(true);
    differentialDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);

  }

  
  public Command driveCommand (DoubleSupplier speed, DoubleSupplier rotation){
    return runEnd(()->{
      differentialDrive.arcadeDrive(speed.getAsDouble(), rotation.getAsDouble());
    },() -> {
      differentialDrive.stopMotor();
    });
  }

  public Command coralForwardCommand(){
    return new RunCommand (()->{
       coralMotor.set(Constants.OperatorConstants.CORAL_MOTOR_SPEED);
    }, this);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }


public Command exampleMethodCommand() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'exampleMethodCommand'");
}
}
