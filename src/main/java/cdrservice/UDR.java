package cdrservice;

public class UDR {
    private String msisdn;
    private CallStats incomingCall;
    private CallStats outgoingCall;

    public UDR(String msisdn) {
        this.msisdn = msisdn;
        this.incomingCall = new CallStats();
        this.outgoingCall = new CallStats();
    }

    public String getMsisdn() {
        return msisdn;
    }

    public CallStats getIncomingCall() {
        return incomingCall;
    }

    public CallStats getOutgoingCall() {
        return outgoingCall;
    }

    public void addIncomingCall(long duration) {
        incomingCall.addDuration(duration);
    }

    public void addOutgoingCall(long duration) {
        outgoingCall.addDuration(duration);
    }
}
