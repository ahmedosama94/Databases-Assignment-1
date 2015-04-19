package exceptions;

@SuppressWarnings("serial")
public class DBAppException extends Exception {
	
	public DBAppException() {
		super();
	}
	
	public DBAppException(String msg) {
		super(msg);
	}

}
