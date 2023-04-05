package ua.kastset.diamomdapp.cardlist;

public class SpiderTrap extends Card {

	public SpiderTrap(Integer iconId,String cards) {
		super(iconId,cards);
	}
	@Override
	public String playCard() {
		return "Use Spider trap";
	}


}
