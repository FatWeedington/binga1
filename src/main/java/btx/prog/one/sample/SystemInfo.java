/*
 * (c) 2021 by Eric Dubuis - BFH BTX8041, Programming 1
 */
package btx.prog.one.sample;

/**
 * Helper class providing system info.
 */
public class SystemInfo {

	/**
	 * Returns the Java runtime version
	 * @return the Java runtime version
	 */
    public String javaVersion() {
        return System.getProperty("java.version");
    }

    /**
	 * Returns the JavaFX version
	 * @return the JavaFX version
     */
    public String javafxVersion() {
        return System.getProperty("javafx.version");
    }
}
