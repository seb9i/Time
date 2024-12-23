public class Time {
    private int seconds;
    private int minutes;
    private int hours;

    public Time(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

    }

    private String formatNumber(int number) {
        return (number < 10) ? ("0" + String.valueOf(number)) : (String.valueOf(number));
    }

    private void changeMinute(){
        if (minutes == 59){
            minutes = 0;
            changeHour();
        }
        else {
            minutes += 1;
        }
    }
    private void changeHour(){
        if (hours == 23){
            hours = 0;
        }
        else {
            hours += 1;
        }
    }

    public void tick(){
        if (seconds == 59){
            seconds = 0;
            changeMinute();
        }
        else {
            seconds += 1;
        }
    }
    public void add(Time time){
        int totalSeconds = (time.getSeconds() + (60 * time.getMinutes()) + (3600 * time.getHours())) + (getSeconds() + (60 * getMinutes()) + (3600 * getHours()));
        int extraHours = (totalSeconds > 86400) ? ((totalSeconds - 86400) / 3600) : (totalSeconds / 3600);
        int extraMinutes;
        int extraSeconds;
        if (time.getMinutes() + getMinutes() > 60) {
            extraMinutes = (((time.getMinutes() * 60)  + (getMinutes() * 60) - 3600) / 60 );
        }
        else {
            extraMinutes = (((time.getMinutes() * 60)  + (getMinutes() * 60)) / 60 );

        }
        if (time.getSeconds() + getSeconds() > 60){
            extraSeconds = ((time.getSeconds() + getSeconds()) - 60);
            extraMinutes += 1;
        }
        else {
            extraSeconds = (time.getSeconds() + getSeconds());
        }
        hours = extraHours;
        minutes = extraMinutes;
        seconds = extraSeconds;
    }

    public int getSeconds(){return seconds;}
    public int getMinutes(){return minutes;}
    public int getHours(){return hours;}

    public String toString(){
        return String.format("%s:%s:%s", formatNumber(hours), formatNumber(minutes), formatNumber(seconds));
    }
}
