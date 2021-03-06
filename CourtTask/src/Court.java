import java.util.List;

public class Court {
	private String name;
	private String adress;
	private List<Case> cases;
	private List<LegalEntity> legalEntities;
	
	public Court(String name, String adress, List<Case> cases, List<LegalEntity> legalEntities) {
		if(name != null && !name.equals("")){
			this.name = name;
		}
		if(adress != null && !adress.equals("")){
			this.adress = adress;
		}
		if(cases !=null){
			this.cases = cases;
		}
		if(legalEntities != null){
			this.legalEntities = legalEntities;
		}
		
	}
	

	@Override
	public String toString() {
		String string = "";
		for (int i = 0; i < legalEntities.size(); i++) {
			string.concat(legalEntities.toString()+ "/n");
		}
		return string;
	}
	
	void printInfo(){
		for (LegalEntity legalEntity : legalEntities) {
			System.out.println(legalEntity.toString());
		}
	}
	
}
