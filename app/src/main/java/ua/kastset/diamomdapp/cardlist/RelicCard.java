package ua.kastset.diamomdapp.cardlist;

public class RelicCard extends Card {

	public RelicCard(Integer iconId,String cards) {
		super(iconId,cards);
	}

	@Override
	public String playCard() {
		return "Use Relic";
	}

}
