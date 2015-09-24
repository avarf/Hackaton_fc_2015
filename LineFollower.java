import lejos.nxt.*;

public class LineFollower {

	/**
	 * 
	 * @author  Octavio Arriaga and Ali Varfan
     * 
     * The LineFollower class solve the second Exercise
	 * 
	 */
	public static void main(String[] args) {
		
		lineFollower();

	}
	
	
	/* this method use PID controller for following a black line*/
	public static void lineFollower() {
		

		float kp=15;
		float ki=0;
		float kd=0;
		float offset=45;
		float tp=25;
		float integral=0;
		float lastError=0;
		float derivative=0;
		float error = 0;
		float turn = 0;
		
		/* defining the robot parts*/
		Motor.A.setSpeed(10);
		Motor.C.setSpeed(10);
	    LightSensor ls1 = new LightSensor(SensorPort.S1);
	    
	    Motor.A.forward();
	    Motor.B.forward();

	    /* PID controller */
	    while (true)
	    {
	      float lightValue = (float)ls1.readValue();
	      error = lightValue - offset;
	      integral = integral + error;
	      derivative = error - lastError;
	      turn = (kp*error)+(ki*integral)+(kd*derivative);
	      
	      Motor.A.setSpeed(tp + turn);
	      Motor.B.setSpeed(tp - turn);
	      
	      Motor.A.forward();
	      Motor.B.forward();
	      lastError = error;

	    }	


		
	}


}
