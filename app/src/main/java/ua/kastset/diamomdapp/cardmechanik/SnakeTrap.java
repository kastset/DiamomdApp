package ua.kastset.diamomdapp.cardmechanik;

public class SnakeTrap extends Card {
	public boolean isDead = false;

	public void kill() {
		isDead = true;
	}
	public SnakeTrap(Integer iconId,String cards) {
		super(iconId,cards);
	}

	@Override
	public String playCard() {
		return "Use Snake trap";
	}
	
}
