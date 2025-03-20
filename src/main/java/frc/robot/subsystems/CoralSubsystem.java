// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CoralSubsystem extends SubsystemBase {
   private final SparkMax coralMotor = new SparkMax(Constants.IdConstants.CORAL_MOTOR_ID,MotorType.kBrushed);
  /** Creates a new CoralSubsystem. */
  public CoralSubsystem() {
  }
       public Command coralForwardCommand(){
    return runEnd(()->{
      coralMotor.set(Constants.SpeedConstants.CORAL_FORWARD_SPEED);
    },() -> {
      coralMotor.stopMotor();
    });
  }

  public Command coralBackwardCommand(){
    return runEnd(()->{
      coralMotor.set(Constants.SpeedConstants.CORAL_BACKWARD_SPEED);
    },() -> {
      coralMotor.stopMotor();
    });
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
