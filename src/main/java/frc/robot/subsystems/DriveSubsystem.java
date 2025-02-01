// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  
  private final SparkMax leftFrontMotor = new SparkMax(Constants.OperatorConstants.LEFT_FRONT_MOTOR_ID,MotorType.kBrushed);
  private final SparkMax rightFrontMotor = new SparkMax(Constants.OperatorConstants.RIGHT_FRONT_MOTOR_ID,MotorType.kBrushed);
  private final SparkMax leftBackMotor = new SparkMax(Constants.OperatorConstants.LEFT_BACK_MOTOR_ID,MotorType.kBrushed);
  private final SparkMax rightBackMotor = new SparkMax(Constants.OperatorConstants.RIGHT_BACK_MOTOR_ID,MotorType.kBrushed);
  private final DifferentialDrive differentialDrive;
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    SparkBaseConfig config = new SparkMaxConfig();
        leftBackMotor.configure(config.follow(leftFrontMotor), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightBackMotor.configure(config.follow(rightFrontMotor), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
       

    differentialDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);
  }

  
  public Command driveCommand (DoubleSupplier speed, DoubleSupplier rotation){
    return runEnd(()->{
      differentialDrive.arcadeDrive(speed.getAsDouble(), rotation.getAsDouble());
    },() -> {
      differentialDrive.stopMotor();
    });
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
//    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'exampleMethodCommand'");
 }
}
