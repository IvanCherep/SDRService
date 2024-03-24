package cdrservice;

public class CallStats {
    private long totalTime = 0;

    public void addDuration(long duration) {
        totalTime += duration;
    }

    public long getTotalTime() {
        return totalTime;
    }
}

