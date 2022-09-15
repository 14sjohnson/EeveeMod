package eevee.cards.EeveeCards;

import basemod.cardmods.EtherealMod;
import basemod.cardmods.ExhaustMod;
import basemod.helpers.CardModifierManager;
import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import eevee.actions.EasyModalChoiceAction;
import eevee.cards.AbstractEasyCard;
import eevee.cards.EasyModalChoiceCard;

import java.util.ArrayList;
import java.util.Collections;

import static eevee.EeveeMod.makeID;
import static eevee.util.Wiz.*;

public class EVTraining extends AbstractEasyCard {
    public final static String ID = makeID(EVTraining.class.getSimpleName());

    public EVTraining() {
        super(ID, 2, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        baseMagicNumber = magicNumber = 2;
        baseSecondMagic = secondMagic = 1;

    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        ArrayList<AbstractCard> easyCardList = new ArrayList<>();
        easyCardList.add(new EasyModalChoiceCard(cardStrings.EXTENDED_DESCRIPTION[0], cardStrings.EXTENDED_DESCRIPTION[1] + magicNumber + cardStrings.EXTENDED_DESCRIPTION[2], () -> applyToSelfTop(new StrengthPower(p, magicNumber))));
        easyCardList.add(new EasyModalChoiceCard(cardStrings.EXTENDED_DESCRIPTION[3], cardStrings.EXTENDED_DESCRIPTION[4]+ magicNumber + cardStrings.EXTENDED_DESCRIPTION[5], () -> applyToSelfTop(new DexterityPower(p, magicNumber))));
        easyCardList.add(new EasyModalChoiceCard(cardStrings.EXTENDED_DESCRIPTION[6], cardStrings.EXTENDED_DESCRIPTION[7]+ secondMagic + cardStrings.EXTENDED_DESCRIPTION[8], () -> applyToSelfTop(new StrengthPower(p, secondMagic))));
        atb(new EasyModalChoiceAction(easyCardList));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}