// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.io.Console;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class IntakeCommand extends CommandBase {
  /** Creates a new IntakeCommand. */
  public IntakeCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_robotContainer.intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.m_robotContainer.intakeSubsystem.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Robot.m_robotContainer.intakeSubsystem.intake();
    double distance = RobotMap.getDistFromBall();
    if (distance <= Constants.distFromObject)
      Robot.m_robotContainer.intakeSubsystem.intake();
    else 
      Robot.m_robotContainer.intakeSubsystem.stop();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_robotContainer.intakeSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
