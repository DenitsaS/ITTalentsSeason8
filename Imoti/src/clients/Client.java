package clients;

import agency.Agency;
import agency.Agent;
import agency.ContactInfo;

public abstract class Client extends ContactInfo{
	Agent agent;
	Agency agency;
	public Client(String name) {
		super(name);
	}
	public Agency getAgency() {
		return agency;
	}
}
