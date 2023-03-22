package ua.kastset.diamomdapp.cardmechanik;

public class TreasureCard extends Card{
	boolean isDead;

	public TreasureCard(Integer iconId,String cards) {
		super(iconId,cards);
	}

	@Override
	public String playCard() {
		return "Use Treasure card";
	}

}
