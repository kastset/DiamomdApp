package ua.kastset.diamomdapp.cardlist;

public class TreasureCard extends Card{

	public TreasureCard(Integer iconId,String cards) {
		super(iconId,cards);
	}

	@Override
	public String playCard() {
		return "Use Treasure card";
	}

}
