// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import frc.robot.subsystems.CoralSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public final class Autos {
  public static Command simpleCenterL1Auto(DriveSubsystem driveSubsystem,CoralSubsystem coral) {
    // this is like a joystick. But, the speed is always 1 (100% forward
    // and the rotation is always 0 (forward)
    return driveSubsystem.driveCommand(()->-0.6, ()->-0)
    // stop after 7 seconds, should be at the station by then
    .withTimeout(5)
    .andThen(
      // outtake for 5 seconds 
      coral.coralForwardCommand().withTimeout(5)
    ); 
  } 

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}