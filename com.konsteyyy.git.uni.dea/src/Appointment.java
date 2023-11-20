
public class Appointment {
	int startTimeHour = 10;
	int startTimeMinute = 15;
	int duration = 90;
	String title = "OOP-auf den Kopf gestellt!";
	
	void setDuration(int newDuration) {
		duration = newDuration;
	}
	
	
	int getDuration() {
		return duration;
	}
	
	void setTitle(String newTitle) {
		title = newTitle;
	}
	
	String getTitle() {
		return title;
	}
	
	void setStartTime(int newstartTimeHour, int newstartTimeMinute) {
		startTimeHour = newstartTimeHour;
		startTimeMinute = newstartTimeMinute;
	}
	
	String getEndTime() {
		//11 Uhr + Stundenanzahl. Ganzzahlige Division 90/60 = 1
		int endTimeHour = startTimeHour + (duration / 60);
		
		//15 Minuten + Divisionsrest von duration. 90 Minuten % 60 Minuten = 30 Minuten
		int endTimeMinute = startTimeMinute + (duration % 60);

		
		return "" + endTimeHour + ":" + endTimeMinute + " Uhr";
	}
}
