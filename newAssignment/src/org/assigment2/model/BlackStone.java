package org.assigment2.model;

public class BlackStone extends Stone {

	String type;
	
	public BlackStone(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.type = "x";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BlackStone [type=" + type + "]";
	}
	
	
}
