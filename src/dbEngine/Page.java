package dbEngine;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Page implements Serializable {
	
	private int n;
	
	public Page(int n) {
		this.n = n;
	}
	
	public int getN() {
		return n;
	}

}
