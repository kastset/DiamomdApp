package ua.kastset.diamomdapp.cardmechanik;

public class SpiderTrap extends Card {
	public boolean isDead = false;

	public void kill() {
		isDead = true;
	}
	public SpiderTrap(Integer iconId,String cards) {
		super(iconId,cards);
	}

	@Override
	public String playCard() {
		return "Use Spider trap";
	}

}
