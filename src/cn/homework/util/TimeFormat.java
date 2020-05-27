package cn.homework.util;

public class TimeFormat {
	int min;
	int sec;
	
	public TimeFormat(int min, int sec) {
		super();
		this.min = min;
		this.sec = sec;
	}

	public int getMin() {
		return min;
	}

	public int getSec() {
		return sec;
	}

	public void addSec(int plus) {
		if(sec + plus >= 60)
			min++;
		sec = (sec + plus)%60;
	}
	
	public String toString() {
		String minStr = min < 10?"0"+min : min+"";
		String secStr = sec < 10?"0"+sec : sec+"";
		
		return minStr + ":" + secStr;
	}
	
	
}
