package com.spdev.lindacaretest.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.springframework.util.StringUtils;

/**
 * 
 * @author marco
 *
 */
public class ReflectionUtils {

	private static final String GET = "get";
	private static final String SET = "set";

	public static void trimAllStringParameter(Object object) {
		Class<?> instanceClass = object.getClass();
		Field[] fields = instanceClass.getDeclaredFields();
		for (Field f : fields) {
			try {
				if (Modifier.isFinal(f.getModifiers()) || Modifier.isStatic(f.getModifiers())) {
					continue;
				}
				if (!f.getType().isAssignableFrom(String.class)) {
					continue;
				}

				try {
					Method getM = instanceClass.getMethod(GET + StringUtils.capitalize(f.getName()));
					Method setM = instanceClass.getMethod(SET + StringUtils.capitalize(f.getName()), String.class);
					if (getM == null || setM == null) {
						continue;
					}
					Object stringValue = getM.invoke(object);
					if (stringValue == null) {
						continue;
					}
					stringValue = ((String) stringValue).trim();
					setM.invoke(object, stringValue);
				} catch (NoSuchMethodException e) {
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static Object invokeGetMethod(Object object, String parameterName) {
		Class<?> instanceClass = object.getClass();
		try {
			Method getM = instanceClass.getMethod(GET + StringUtils.capitalize(parameterName));
			if (getM != null) {
				Object stringValue = getM.invoke(object);
				return stringValue;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String invokeGetStringMethod(Object object, String parameterName) {
		Class<?> instanceClass = object.getClass();
		try {
			Method getM = instanceClass.getMethod(GET + StringUtils.capitalize(parameterName));
			if (getM != null) {
				Object stringValue = getM.invoke(object);
				if (stringValue != null)
					return (String) stringValue;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean invokeSetStringMethod(Object object, String parameterValue, String parameterName) {
		Class<?> instanceClass = object.getClass();
		try {
			Method setM = instanceClass.getMethod(SET + StringUtils.capitalize(parameterName), String.class);
			if (setM != null) {
				setM.invoke(object, parameterValue);
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}