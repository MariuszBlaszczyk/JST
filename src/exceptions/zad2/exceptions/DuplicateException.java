package exceptions.zad2.exceptions;

import exceptions.zad2.model.Participant;

public class DuplicateException extends RuntimeException{

    private Participant participant;



    public DuplicateException(Participant participant) {
        this.participant = participant;
    }

    public Participant getParticipant() {
        return participant;
    }

}
