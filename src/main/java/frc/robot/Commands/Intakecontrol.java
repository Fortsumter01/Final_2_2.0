// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Intake;

public class Intakecontrol extends Command {

  private Intake intakeSubsystem;
  //private XboxController opController;
  private static final double INTAKE_SPEED = .7;
  private static final double TIMER = 3.0;

  
  /** Creates a new Intakecontrol. */
  public Intakecontrol(Intake intakeSubsystem, XboxController opController) {
    addRequirements(intakeSubsystem);
    this.intakeSubsystem = intakeSubsystem;
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSubsystem.setIntakeSpeed(INTAKE_SPEED);
    intakeSubsystem.startTimer();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if ( intakeSubsystem.isCurrentLimitExceeded() || intakeSubsystem.isTimerExpired(TIMER)) {
      intakeSubsystem.setIntakeSpeed(0.0);
    
 
    }
  }

 
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.setIntakeSpeed(0.0);
    end(false);
  }

  // Returns true when the command should end.
   @Override
  public boolean isFinished() {
    return false;

  }
  
}
