package com.mayab.calidad.doubles.tareaUnitTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public  class Zone
{

	  public static final Map<Integer, Double> zones = new HashMap<>();

	  static {
	      zones.put(1, .01);
	      zones.put(2, .02);
	      zones.put(3, .03);
	  }
	  
}
