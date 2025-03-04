// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static Command exampleAuto(DriveSubsystem driveCommand) {
    return Commands.sequence(driveCommand.exampleMethodCommand(), new ExampleCommand(driveCommand));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}