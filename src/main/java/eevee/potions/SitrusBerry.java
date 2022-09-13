 package eevee.potions;

 import com.badlogic.gdx.graphics.Color;
 import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
 import com.megacrit.cardcrawl.actions.AbstractGameAction;
 import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
 import com.megacrit.cardcrawl.cards.tempCards.Shiv;
 import com.megacrit.cardcrawl.core.AbstractCreature;
 import com.megacrit.cardcrawl.core.CardCrawlGame;
 import com.megacrit.cardcrawl.core.Settings;
 import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
 import com.megacrit.cardcrawl.helpers.PowerTip;
 import com.megacrit.cardcrawl.localization.PotionStrings;
 import com.megacrit.cardcrawl.potions.AbstractPotion;
 import com.megacrit.cardcrawl.rooms.AbstractRoom;


 import eevee.EeveeMod;

 public class SitrusBerry extends AbstractPotion {
       public static final String POTION_ID = EeveeMod.makeID("SitrusBerry");
       private static final PotionStrings potionStrings = CardCrawlGame.languagePack.getPotionString("SitrusBerry");
    
       public SitrusBerry() {
             super(potionStrings.NAME, "SitrusBerry", AbstractPotion.PotionRarity.COMMON, AbstractPotion.PotionSize.SPIKY, AbstractPotion.PotionEffect.NONE, Color.GRAY, Color.DARK_GRAY, null);

             this.labOutlineColor = Settings.GREEN_RELIC_COLOR;
             this.isThrown = false;
           }
    
    
       public void initializeData() {
             this.potency = getPotency();
             this.description = potionStrings.DESCRIPTIONS[0] + this.potency + potionStrings.DESCRIPTIONS[1];
             this.tips.clear();
             this.tips.add(new PowerTip(this.name, this.description));
           }
    
    
       public void use(AbstractCreature target) {
            int amount = Math.round(AbstractDungeon.player.maxHealth / 3);
            AbstractDungeon.player.heal(amount);
       }

       public int getPotency(int ascensionLevel) {
             return 3;
           }
    
    
       public AbstractPotion makeCopy() {
             return new SitrusBerry();
           }
     }