package blade.kit.log;

public class JdkLoggerFactory implements LoggerFactory {
	
	public Logger getLogger(Class<?> clazz) {
		return new JdkLogger(clazz);
	}
	
	public Logger getLogger(String name) {
		return new JdkLogger(name);
	}
}
