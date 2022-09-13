package eevee.powers;

import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.OnReceivePowerPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static eevee.EeveeMod.makeID;
import static eevee.util.Wiz.*;

public class PerfectEVsPower extends AbstractEasyPower implements OnReceivePowerPower {
    public static String ID = makeID(PerfectEVsPower.class.getSimpleName());

    private static PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(ID);

    public PerfectEVsPower(AbstractCreature owner, int amount) {
        super(ID, powerStrings.NAME, PowerType.BUFF, false, owner, amount);
        isTwoAmount = false;
        canGoNegative2 = true;
        updateDescription();
    }

    // THIS IS IMPORTANT!
    // You need to have this for it to stack the second amount properly
    @Override
    public boolean onReceivePower(AbstractPower pow, AbstractCreature target, AbstractCreature source) {
        applyToSelf(new StrengthPower(adp(), amount));
        applyToSelf(new DexterityPower(adp(), amount));
        return true;
    }
}