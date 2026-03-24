package com.hotelcalifornia.hotelcalifornia.utils.messeg;

public enum Messege404 {
    NOT_FOUND ("was not found");

    private final String text;

    private Messege404(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    
}
