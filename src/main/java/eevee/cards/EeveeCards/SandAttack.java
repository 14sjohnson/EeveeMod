package eevee.cards.EeveeCards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import static eevee.EeveeMod.makeID;
import eevee.cards.AbstractEasyCard;

public class SandAttack extends AbstractEasyCard {
    public final static String ID = makeID("SandAttack");
    // intellij stuff skill, self, basic, , ,  5, 3, , 

    public SandAttack() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.ENEMY);
        baseBlock = 5;
        baseMagicNumber = 2;
        magicNumber = baseMagicNumber;
        tags.add(CardTags.STARTER_DEFEND);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new VulnerablePower((AbstractCreature)m, this.magicNumber, false), this.magicNumber));
    }

    public void upp() {
        upgradeBlock(3);
    }
}