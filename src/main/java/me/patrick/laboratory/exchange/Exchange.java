package me.patrick.laboratory.exchange;

public interface Exchange {

    float rate(String target, String origin);

    default float rate(String target) {
        return target.length();
    }
}
