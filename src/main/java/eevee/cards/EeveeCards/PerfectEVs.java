package eevee.cards.EeveeCards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import eevee.cards.AbstractEasyCard;
import eevee.powers.PerfectEVsPower;

import static eevee.EeveeMod.makeID;
import static eevee.util.Wiz.adp;
import static eevee.util.Wiz.applyToSelf;

public class PerfectEVs extends AbstractEasyCard {
    public final static String ID = makeID(PerfectEVs.class.getSimpleName());

    public PerfectEVs() {
        super(ID, 2, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new StrengthPower(adp(), baseMagicNumber));
        applyToSelf(new DexterityPower(adp(), baseMagicNumber));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}