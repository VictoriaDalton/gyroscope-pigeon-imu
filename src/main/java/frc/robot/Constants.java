// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

 //in case of need. Those are the calculation for the yaw,pitch and roll I found online
/** 
 float alpha=(float) 0.5;
    double fXg=0.0,fYg=0.0,fZg=0.0;
    fXg = xx * alpha + (fXg * (1.0 - alpha));
    fYg = yy * alpha + (fYg * (1.0 - alpha));
    fZg = zz * alpha + (fZg * (1.0 - alpha));

    //Roll,Pitch & Yaw Equations
   double roll  = (Math.atan2(-fYg, fZg)*180.0)/3.14;
   double pitch =( Math.atan2(fXg, Math.sqrt(fYg*fYg + fZg*fZg))*180.0)/3.14;
   double yaw = 180 * Math.atan (fZg/Math.sqrt(fXg*fXg + fZg*fZg))/3.14;
*/

public final class Constants {
  // gyro port will change
  public static final int gyroPort = 0;
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
