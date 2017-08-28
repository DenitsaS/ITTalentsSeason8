
public interface IBank {
	
	Deposit openDeposit(double money);
	Credit lendCredit(IClient client, int money, int period);

}