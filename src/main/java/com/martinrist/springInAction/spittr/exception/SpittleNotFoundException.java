package com.martinrist.springInAction.spittr.exception;

public class SpittleNotFoundException extends RuntimeException {

    public long getSpittleId() {
        return spittleId;
    }

    private long spittleId;

    public SpittleNotFoundException(long spittleId) {
        this.spittleId = spittleId;
    }
}
