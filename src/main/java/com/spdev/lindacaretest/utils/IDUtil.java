package com.spdev.lindacaretest.utils;

import org.lable.oss.uniqueid.GeneratorException;
import org.lable.oss.uniqueid.IDGenerator;
import org.lable.oss.uniqueid.LocalUniqueIDGeneratorFactory;

/**
 * 
 * @author marco
 *
 */
public class IDUtil {

	// Util method to generate long unique id from local unique id generator
	// factory.
	public static long getUniqueId() {
		long id = 0;
		IDGenerator generator = LocalUniqueIDGeneratorFactory.generatorFor(0, 0);
		byte[] byteArr;
		try {
			byteArr = generator.generate();
			for (int i = 0; i < byteArr.length; i++) {
				id += ((long) byteArr[i] & 0xffL) << (8 * i);
			}
		} catch (GeneratorException e) {
			// TODO Backup option
			e.printStackTrace();
		}
		return id;
	}
}
