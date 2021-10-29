package exceptions.zad2.service;

import exceptions.zad2.exceptions.AgeViolationException;
import exceptions.zad2.exceptions.DuplicateException;
import exceptions.zad2.exceptions.MaxCompetitorsException;
import exceptions.zad2.model.Participant;
import exceptions.zad2.model.Competition;

import java.util.Scanner;

public class CompetitionController {

    private Scanner scanner = new Scanner(System.in);

    public void run() {
        Competition competition = createCompetition();
        fillParticipantsInfo(competition);
        printCompetition(competition);
    }

    private Competition createCompetition() {
        System.out.println("Podaj nazwę zawodów:");
        String competitionName = scanner.nextLine();
        System.out.println("Podaj maksymalną liczbę uczestników:");
        int maxParticipants = getStringFromUser();
        System.out.println("Podaj ograniczenie wiekowe:");
        int ageLimit = getStringFromUser();
        return new Competition(competitionName, maxParticipants, ageLimit);
    }

    private void fillParticipantsInfo(Competition competition) {
        while (competition.hasFreeSpots()) {
            System.out.println("Dodaj nowego uczestnika");
            Participant participant = createParticipant();

            try {
                competition.addParticipant(participant);
            } catch (AgeViolationException e) {
                System.out.println("Nie dodano uczestnika, minimalny wiek: " + e.getAgeRequired());
            } catch (DuplicateException e) {
                System.out.println(
                        "Uczestnik o wskazanym identyfikatorze został już dodany do tych zawodów " + e.getParticipant()
                );
            } catch (MaxCompetitorsException e) {
                System.out.println("Nie dodano uczestnika. Maksymalna liczba uczestników to " + e.getMaxCompetitors());
            }
        }
    }

    private Participant createParticipant() {
        System.out.println("Podaj imię:");
        String firstName = scanner.nextLine();
        System.out.println("Podaj nazwisko:");
        String lastName = scanner.nextLine();
        System.out.println("Podaj id (np. pesel):");
        String id = scanner.nextLine();
        System.out.println("Podaj wiek:");
        int age = getStringFromUser();
        return new Participant(firstName, lastName, id, age);
    }

    private void printCompetition(Competition competition) {
        System.out.println(competition.toString());
    }

    private int getStringFromUser() {
        String userText = "";
        int userNumber = 0;
        String regex = "^[1-9]\\d{0,9}$";
        do {
            try {
                userNumber = Integer.parseInt(userText = scanner.next());
                if (userNumber <= 0) {
                    System.out.println("Number must be greater than zero");
                }
            } catch (NumberFormatException e) {
                System.out.println("The value must be a number");
            } finally {
                scanner.nextLine();
            }
        } while (!userText.matches(regex));
        return userNumber;
    }
}
