// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Commands.Intakecontrol;
import frc.robot.Commands.TankDrive;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Subsystems.Intake;

/** Add your docs here. */
public class RobotContainer {

    //Controllers
    private final XboxController opController;
    private final XboxController drivecontroller;


    public final DriveSubsystem driveSubsystem;
    public final TankDrive tankDrivecommand;
    public final Intake intakeSubsystem;
    public final Intakecontrol intakecontrolcommand;
   

    public RobotContainer() {


        drivecontroller = new XboxController(0);
        opController = new XboxController(1);

        driveSubsystem = new DriveSubsystem(8, 7,4, 3); // CAN IDs, adjust as necessary
        tankDrivecommand = new TankDrive(driveSubsystem, drivecontroller);
        intakeSubsystem = new Intake(6, 5);
        intakecontrolcommand = new Intakecontrol(intakeSubsystem, opController);
        CommandScheduler.getInstance().setDefaultCommand(driveSubsystem, tankDrivecommand);
        CommandScheduler.getInstance().setDefaultCommand(intakeSubsystem, intakecontrolcommand);
        
        configureButtonBindings();


        
    }





    private void configureButtonBindings() {
        if (opController.getRightBumper()) {
            new Intakecontrol(intakeSubsystem, opController);
        }

    }

   
    

    public Command getAutonomousCommand() {
        return null; // Autonomous commands here
    }








}

