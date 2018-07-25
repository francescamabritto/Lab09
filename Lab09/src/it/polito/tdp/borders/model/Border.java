package it.polito.tdp.borders.model;

public class Border {
	private int state1no;
	private String state1ab; 
	private int state2no;
	private String state2ab;
	
	public Border(int state1no, String state1ab, int state2no, String state2ab) {
		this.state1no = state1no;
		this.state1ab = state1ab;
		this.state2no = state2no;
		this.state2ab = state2ab;
	}

	public int getState1no() {
		return state1no;
	}

	public void setState1no(int state1no) {
		this.state1no = state1no;
	}

	public String getState1ab() {
		return state1ab;
	}

	public void setState1ab(String state1ab) {
		this.state1ab = state1ab;
	}

	public int getState2no() {
		return state2no;
	}

	public void setState2no(int state2no) {
		this.state2no = state2no;
	}

	public String getState2ab() {
		return state2ab;
	}

	public void setState2ab(String state2ab) {
		this.state2ab = state2ab;
	}

	@Override
	public String toString() {
		return "\n"+state1no + " " + state1ab + " <--> " + state2no + " " + state2ab;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + state1no;
		result = prime * result + state2no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Border other = (Border) obj;
		if(this.state1no == other.state1no)
			if(this.state2no==other.state2no)
				return true;
		if(this.state1no == other.state2no)
			if(this.state2no == other.state1no)
				return true;
		
		return false;
	}

	
	
	
}
