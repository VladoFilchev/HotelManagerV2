package data;

import object.Client;

public class ClientDAO {
    public void saveClientToDb(Client client) {
        // save client to db
        System.out.println("Client saved to db: " + client.getFirstName()+"\n"+client.getLastName()+"\n"+client.getPhoneNumber()+"\n"+client.getDOB());
    }
}
