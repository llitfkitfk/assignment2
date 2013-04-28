package org.assigment2.model;

public class WhiteStone extends Stone {

	String type;
	
	public WhiteStone(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.type = "o";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "WhiteStone [type=" + type + "]";
	}

	
}
