package com.semanticsquare.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SimpleUnitTester {

	public static int execute(Class clazz) throws Exception {
		int failedCount = 0;
		
		 Constructor ReflectionCon = clazz.getDeclaredConstructor(); 
		 Reflection obj = (Reflection) ReflectionCon.newInstance();

		for (Method m : clazz.getDeclaredMethods()) {
			if ((m.getReturnType() == boolean.class) && (m.getName().startsWith("test"))) {
				Object returnedValue = m.invoke(obj,null);
				if ((boolean)returnedValue == false) {
					failedCount++;
				}
			}
		}
		System.out.println(failedCount);
		return failedCount;
	}

	public static void main(String[] args) throws Exception {
		execute(Reflection.class);
	}
}
