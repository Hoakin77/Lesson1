package ru.geekbrains.java2.homeworks.hw1.hurdles;

import ru.geekbrains.java2.homeworks.hw1.participant.Participant;

public class Wall implements Hurdles{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public String check(Participant participant) {
        participant.jumpStr();
        participant.setSuccess(participant.getMaxHeight() >= height);
        if (participant.getSuccess()) {
            return "Игрок " + participant.getName() + " перепрыгнул стену высотой: " + height + " м";
        } else {
            return "Игрок " + participant.getName() + " не перепрыгнул стену высотой: " + height + " м";
        }
    }
}
