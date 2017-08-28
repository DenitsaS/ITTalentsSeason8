

public interface IClient {
	void openDeposit(IBank bank, double money);
	void askForCredit(IBank bank, int money, int period);
	void lenCredit(); 
}