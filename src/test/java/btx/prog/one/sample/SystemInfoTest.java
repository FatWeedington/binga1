/*
 * (c) 2021 by Eric Dubuis - BFH BTX8041, Programming 1
 */
package btx.prog.one.sample;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SystemInfoTest {

	@Test
	public void testJavaVersion() {
		SystemInfo systemInfo = new SystemInfo();
		assertTrue("17".equals(systemInfo.javaVersion()));
	}
}
