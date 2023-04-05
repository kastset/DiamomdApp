package ua.kastset.diamomdapp.cardlist;

public class StoneTrap extends Card {

	public StoneTrap(Integer iconId,String cards) {
		super(iconId,cards);
	}
	@Override
	public String playCard() {
		return "Use Stone trap";
	}

}
