package com.karepin.homework_005;

import java.util.Date;

public class Pressure {
    private int pressureUp;
    private int pressureDown;
    private int pulse;
    private Boolean tachycardia;
    private Date date;

    public Pressure(int pressureUp, int pressureDown, int pulse, Boolean tachycardia, Date date) {
        this.pressureUp = pressureUp;
        this.pressureDown = pressureDown;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Верхнее давление: " + pressureUp +
                ", нижнее давление: " + pressureDown +
                ", пульс: " + pulse +
                ", тахикардия: " + tachycardia +
                ", дата: " + date;
    }
}
