package ua.kastset.diamomdapp.cardlist;

public class SnakeTrap extends Card {

	public SnakeTrap(Integer iconId,String cards) {
		super(iconId,cards);
	}
	@Override
	public String playCard() {
		return "Use Snake trap";
	}


}
