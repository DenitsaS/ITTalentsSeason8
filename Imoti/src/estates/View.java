package estates;


import java.util.Date;

import agency.Agent;
import clients.Buyer;

public class View {
	private Estate estate;
	private Agent agent;
	private Buyer buyer;
	private Date date;
	
	public View(Estate estate, Agent agent, Buyer buyer) {
		super();
		this.estate = estate;
		this.agent = agent;
		this.buyer = buyer;
		this.date = new Date();
	}

	public Estate getEstate() {
		return estate;
	}
	
	
}
