// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.



//TANK DRIVE

package frc.robot.Subsystems;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;


public class DriveSubsystem extends SubsystemBase {
    private final CANSparkMax leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor;
    private final DifferentialDrive drive;
    public static final CANSparkLowLevel.MotorType kBrushed = MotorType.kBrushed;
    public static final CANSparkLowLevel.MotorType kBrushless = MotorType.kBrushless;
  

    public DriveSubsystem(int leftFrontID, int leftBackID, int rightFrontID, int rightBackID) {

        leftFrontID = 8;
        leftBackID = 7;
        rightFrontID = 4;
        rightBackID = 3;
      //Left Drive Motors
        leftFrontMotor = new CANSparkMax(8, MotorType.kBrushless);
        leftBackMotor = new CANSparkMax(7, MotorType.kBrushless);
        
      //rigth Drive Motors  
        rightFrontMotor = new CANSparkMax(4, MotorType.kBrushless);
        rightBackMotor = new CANSparkMax(3, MotorType.kBrushless);

        // Invertion
        leftFrontMotor.setInverted(true);
        leftBackMotor.setInverted(false);
        rightFrontMotor.setInverted(true);
        rightBackMotor.setInverted(false);
        

        drive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);
        
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }
  
    

    

}
