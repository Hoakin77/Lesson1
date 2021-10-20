package ru.geekbrains.java2.homeworks.hw1.participant;

public interface Participant {
    String getName();

    int getMaxLength();

    int getMaxHeight();

    boolean getSuccess();

    void setSuccess(boolean success);

    String runStr();

    String jumpStr();
}
