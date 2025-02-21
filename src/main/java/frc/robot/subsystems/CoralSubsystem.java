// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CoralSubsystem extends SubsystemBase {
   private final SparkMax coralMotor = new SparkMax(Constants.IdConstants.CORAL_MOTOR_ID,MotorType.kBrushed);
  /** Creates a new CoralSubsystem. */
  public CoralSubsystem() {

     SparkBaseConfig config = new SparkMaxConfig();
        coralMotor.configure(config.inverted(true), ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }
  
  public Command coralForwardCommand (){
    return new RunCommand(()->{
         coralMotor.set(Constants.SpeedConstants.CORAL_FORWARD_SPEED);
       },this);
     }

     public Command coralStopCommand (){
      return new RunCommand(()->{
           coralMotor.set(0);
         },this);
       }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
