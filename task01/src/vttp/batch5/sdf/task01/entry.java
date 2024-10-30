package vttp.batch5.sdf.task01;

public class entry {

	public String position;
    private String season;
    private String day;
    private String month;
    private String total;
    private String weather;
    private String holiday;
    public static final String[] MONTH = { "January", "Febuary", "March", "April", "May",
		"June", "July", "August", "September", "October", "November", "December"
	};

    public entry(int position, int seasonInt, int dayInt, int monthInt, int totalInt, int weatherInt, int holidayInt) {

        this.position = toPosition(position);
		this.season = toSeason(seasonInt);
        this.day = toWeekday(dayInt);
        this.month = toMonth(monthInt);
        this.total = Integer.toString(totalInt);
        this.weather = toWeather(weatherInt);
        this.holiday = toHoliday(holidayInt);



    }

    public static String toSeason(int season) {
		//season (1:spring, 2:summer, 3:fall, 4:winter)
		switch (season) {
			case 1: return "spring";
			case 2: return "summer";
			case 3: return "fall";
			case 4: return "winter";
			default:
				return "funny season";
		}
    }

    public static String toWeekday(int weekday) {
		switch (weekday) {
			case 0: return "Monday";
			case 1: return "Tuesday";
			case 2: return "Wednesday";
			case 3: return "Thursday";
			case 4: return "Friday";
			case 5: return "Saturday";
			case 6: return "Sunday";
			default:
				return "incorrect day";
		}
	}

    public static String toMonth(int month) {
		switch (month) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
				return MONTH[month - 1];
			default:
				return "unknown month";
		}
	}

    public static String toWeather(int weather) {
		switch (weather) {
			case 1: return "Clear, Few clouds, Partly cloudy, Partly cloudy";
			case 2: return "Mist + Cloudy, Mist + Broken clouds, Mist + Few clouds, Mist";
			case 3: return "Light Snow, Light Rain + Thunderstorm + Scattered clouds, Light Rain + Scattered clouds";
			case 4: return "Heavy Rain + Ice Pallets + Thunderstorm + Mist, Snow + Fog";
			default:
				return "funny weather";
		}
    }

    public static String toHoliday(int holiday) {
		switch (holiday) {
			case 0: return "a holiday";
			case 1: return "not a holiday";
			default:
				return "could be or not be a holiday";
		}
    }

	public static String toPosition(int position) {
		switch (position) {
			case 0: return "highest";
			case 1: return "second highest";
			case 2: return "third highest";
			case 3: return "fourth highest";
			case 4: return "fifth highest";
			default:
				return "not top 5";
		}
	}
	

	@Override
	public String toString() {
		return "The " + position + " (position) recorded number of cyclists was in " + season + " (season), on a " + day + " (day) in the month of " + month + " (month). There were a total of "
				+ total + " (total) cyclists. The weather was " + weather + " (weather). " + day + " (day) was " + holiday + ".";
	}


    
}
