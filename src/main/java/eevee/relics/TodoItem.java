package eevee.relics;

import eevee.Eevee;

import static eevee.EeveeMod.makeID;

public class TodoItem extends AbstractEasyRelic {
    public static final String ID = makeID("TodoItem");

    public TodoItem() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT, Eevee.Enums.EEVEE_COLOR);
    }
}
