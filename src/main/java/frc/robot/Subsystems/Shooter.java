// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Shooter extends SubsystemBase {
  private static final double CURRENT_LIMIT_AMPS = 30.0;
  private Timer timerS;
  private final CANSparkMax shooter1, shooter2;
  private final Servo exampleServo1;
  public static final CANSparkLowLevel.MotorType kBrushed = MotorType.kBrushed;
  public static final CANSparkLowLevel.MotorType kBrushless = MotorType.kBrushless;


 
  //Controller
  private final XboxController opController = new XboxController(1);


  /** Creates a new Shooter. */
  public Shooter( int shooterID1, int shooterID2, int ServoPWM) {

  shooterID1 = 2;
  shooterID2 = 1;
  ServoPWM = 1;

  shooter1 = new CANSparkMax(2, kBrushed);
  shooter2 = new CANSparkMax(1, kBrushed);
  exampleServo1 = new Servo(1);


  timerS = new Timer();


  }
  public void setIntakeSpeed(double speed) {
    shooter1.set(1);
    shooter2.set(1);
  }
  public boolean isCurrentLimitExceeded() {
    return shooter1.getOutputCurrent() > CURRENT_LIMIT_AMPS || shooter2.getOutputCurrent() > CURRENT_LIMIT_AMPS;
  }
  public void startTimer() {
    timerS.start();
  }

  @Override
  public void periodic() {    
  }
  public boolean isTimerExpired(double duration) {
    return timerS.hasElapsed(duration);
  }
  
}
