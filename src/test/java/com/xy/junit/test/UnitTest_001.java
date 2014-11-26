/** 
 * @Description:
 * @author: 俞根海
 * @date: 2014-11-25 下午3:05:46
 * @version: 1.0
 */
package com.xy.junit.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description:
 * @author: 俞根海
 * @date： 2014-11-25 下午3:05:46
 */
public class UnitTest_001 {

	/** 
	 * @Description:
	 * @author: 俞根海
	 * @date: 2014-11-25 下午3:05:46
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("---------start----------");
	}

	/**
	 * @Description:
	 * @author: 俞根海
	 * @date: 2014-11-25 下午3:05:46
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("---------end----------");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
