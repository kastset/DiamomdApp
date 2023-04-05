package ua.kastset.diamomdapp.cardlist;

public class WoodTrap extends Card {

	public WoodTrap(Integer iconId,String cards) {
		super(iconId,cards);
	}
	@Override
	public String playCard() {
		return "Use Wood trap";
	}

}
