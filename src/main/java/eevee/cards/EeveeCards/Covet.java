package eevee.cards.EeveeCards;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import static eevee.EeveeMod.makeID;
import eevee.cards.AbstractEasyCard;

import java.util.Random;

public class Covet extends AbstractEasyCard {
    public final static String ID = makeID("Covet");
    // intellij stuff skill, self, basic, , ,  5, 3, , 

    public Covet() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 7;
        baseMagicNumber = 10;
        magicNumber = baseMagicNumber;
        this.tags.add(CardTags.HEALING);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.NONE);
        if(MathUtils.random(100) < 10){
            addToBot((AbstractGameAction)new ObtainPotionAction(AbstractDungeon.returnRandomPotion(true)));
        }
    }

    public void upp() {
        upgradeBlock(3);
    }
}