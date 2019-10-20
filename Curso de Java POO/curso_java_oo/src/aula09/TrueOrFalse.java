package aula09;

public enum TrueOrFalse {
	FALSE(0, "False"), TRUE(1, "True");
	
	
	private int index;
	private String desc;
	
	private TrueOrFalse(int index, String desc) {
		this.index = index;
		this.desc = desc;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	
}
