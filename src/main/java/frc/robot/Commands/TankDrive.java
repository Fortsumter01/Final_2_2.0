// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveSubsystem;

public class TankDrive extends Command {
  private final DriveSubsystem DriveSubsystem;
  private final XboxController Drivecontroller;
  private double driveLimit = .5;
    public TankDrive(DriveSubsystem DriveSubsystem, XboxController Drivecontroller) {
        this.DriveSubsystem = DriveSubsystem;
        this.Drivecontroller = Drivecontroller;
        addRequirements(DriveSubsystem);
    }
  
    // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftSpeed = Drivecontroller.getRawAxis(1)*driveLimit;
    double rightSpeed = Drivecontroller.getRawAxis(5)*driveLimit;
    if (Drivecontroller.getRightStickButton() ==true) {
      driveLimit = .5;
    } else if (Drivecontroller.getLeftStickButton()) {
      driveLimit = 1;
    }
    DriveSubsystem.tankDrive(leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}









