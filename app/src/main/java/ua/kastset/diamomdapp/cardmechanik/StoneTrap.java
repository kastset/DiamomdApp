package ua.kastset.diamomdapp.cardmechanik;

public class StoneTrap extends Card {
	public boolean isDead = false;

	public void kill() {
		isDead = true;
	}
	public StoneTrap(Integer iconId,String cards) {
		super(iconId,cards);
	}

	@Override
	public String playCard() {
		return "Use Stone trap";
	}

}
