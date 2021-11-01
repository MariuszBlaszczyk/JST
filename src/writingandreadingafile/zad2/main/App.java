package writingandreadingafile.zad2.main;

import writingandreadingafile.zad2.logic.Client;
import writingandreadingafile.zad2.service.ClientDataReader;
import writingandreadingafile.zad2.service.ClientExplorer;

public class App {

    public static void main(String[] args) {

        final String filename = "src/writingandreadingafile/zad2/clients.csv";
        final ClientDataReader reader = new ClientDataReader();
        Client[] clients = reader.readFromFile(filename);
//        ClientExplorer explorer = new ClientExplorer();
        ClientExplorer.printMostValuableClient(clients);
        String country = ClientExplorer.readCountryFromUser();
        ClientExplorer.printClientsFromCountry(clients, country);
        ClientExplorer.printAvgValueFromCountry(clients, country);


    }
}
