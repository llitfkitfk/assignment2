package org.assigment2.model;

public class Stone {
	int x;
	int y;
	String type;
	public Stone(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.type = "-";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Stone [x=" + x + ", y=" + y + ", type=" + type + "]";
	}
	
	
}
