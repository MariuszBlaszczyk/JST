package exceptions.zad2.model;

import exceptions.zad2.exceptions.AgeViolationException;
import exceptions.zad2.exceptions.DuplicateException;
import exceptions.zad2.exceptions.MaxCompetitorsException;

import java.util.Arrays;
import java.util.Objects;

public class Competition {

    private String name;
    private Participant[] participants;
    private int ageLimit;
    private int size;

    public Competition(String name, int maxParticipants, int ageLimit) {
        this.name = name;
        if (ageLimit < 0)
            throw new IllegalArgumentException("ageLimit has to be positive number");
        this.ageLimit = ageLimit;
        this.participants = new Participant[maxParticipants];
    }


    public int getAgeLimit() {
        return ageLimit;
    }

    public void addParticipant(Participant participant) {
        checkAgeConstraint(participant);
        checkMaxParticipiantsConstraint();
        checkDuplicate(participant);
        participants[size] = participant;
        size++;
    }

    private void checkMaxParticipiantsConstraint() {
        if (participants.length == size)
            throw new MaxCompetitorsException(participants.length);
    }

    private void checkAgeConstraint(Participant participant) {
        if (participant.getAge() < getAgeLimit()) {
            throw new AgeViolationException(ageLimit);
        }
    }

    private void checkDuplicate(Participant participant) {
        for (int i = 0; i < size; i++) {
            if (participants[i].getDocumentId().equals(participant.getDocumentId()))
                throw new DuplicateException(participant);
        }
    }


    public boolean hasFreeSpots() {
        return size < participants.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competition that = (Competition) o;
        return ageLimit == that.ageLimit && size == that.size && Objects.equals(name, that.name) && Arrays.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, ageLimit, size);
        result = 31 * result + Arrays.hashCode(participants);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Zawody ")
                .append(name)
                .append("\n")
                .append("Liczba uczestników: ").append(size);
        for (int i = 0; i < size; i++) {
            builder.append("\n");
            builder.append(" > ");
            builder.append(participants[i].toString());
        }
        return builder.toString();
    }
}
