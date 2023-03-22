package ua.kastset.diamomdapp.cardmechanik;

public class RelicCard extends Card {
	boolean isDead;

	public RelicCard(Integer iconId,String cards) {
		super(iconId,cards);
	}

	@Override
	public String playCard() {
		return "Use Relic";
	}

}
