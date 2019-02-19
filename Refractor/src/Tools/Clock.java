package Tools;

public class Clock {
    private int hour;
    private int min;
    private int sec;

    public Clock(int hour, int min, int sec){
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    public Clock(Clock clock){
        this.hour = clock.hour;
        this.min = clock.min;
        this.sec = clock.sec;
    }

    public Clock(){
        this.hour = 0;
        this.min = 0;
        this.sec = 0;
    }

    public void Tick(){
        sec += 1;
        if (sec > 59){
            sec = 0;
            min += 1;
        }
        if (min > 59){
            min = 0;
            hour += 1;
        }
        if (hour > 23){
            hour = 0;
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    @Override
    public String toString() {
        return hour + ":" + min + ":" + sec;
    }
}
