package ru.geekbrains.java2.homeworks.hw1.hurdles;

import ru.geekbrains.java2.homeworks.hw1.participant.Participant;

public class Treadmill implements Hurdles{
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public String check(Participant participant) {
        participant.runStr();
        participant.setSuccess(participant.getMaxLength() >= length);
        if (participant.getSuccess()) {
            return "Игрок " + participant.getName() + " проходит дистанцию длиной: " + length + " км";
        } else {
            return "Игрок " + participant.getName() + " не проходит дистанцию длиной: " + length + " км";
        }
    }
}
