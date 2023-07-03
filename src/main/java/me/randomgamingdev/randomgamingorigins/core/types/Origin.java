package me.randomgamingdev.randomgamingorigins.core.types;

import me.randomgamingdev.randomgamingorigins.core.origins.*;
import me.randomgamingdev.randomgamingorigins.other.Pair;
import org.bukkit.Material;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Evoker;
import org.bukkit.entity.Phantom;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import static me.randomgamingdev.randomgamingorigins.core.OriginsGui.createGuiItem;

public enum Origin {
    Null(new NullOrigin()),
    Avian(new AvianOrigin()),
    Phantom(new PhantomOrigin()),
    Human(new HumanOrigin()),
    Elytrian(new ElytrianOrigin()),
    Blazeborn(new BlazebornOrigin()),
    Feline(new FelineOrigin()),
    Enderian(new EnderianOrigin()),
    Piglin(new PiglinOrigin()),
    Shulk(new ShulkOrigin()),
    Fox(new FoxOrigin()),
    Merling(new MerlingOrigin()),
    Frog(new FrogOrigin()),
    Evoker(new EvokerOrigin()),
    Lunar(new LunarOrigin());
    /*
    Elytrian("Elytrian",
            createGuiItem(Material.ELYTRA, true,
                    "§r§fElytrian",
                    "§7- Winged: You have a elytra",
                    "§7- Gift of Wings: You can launch yourself by clicking",
                    "§7your offhand swap key every 60 seconds",
                    "§7- Arial Combat: While flying you deal more damage",
                    "§7- Need for Mobility: You cant wear chestplates"),
            new Object[]{}, 10 * 2),
    Blazeborn("Blazeborn",
            createGuiItem(Material.BLAZE_POWDER, true,
                    "§r§fBlazeborn",
                    "§7- Fire Immunity: You don't take fire damage",
                    "§7- Burning Wrath: You deal more damage while on fire",
                    "§7- Hydrophobia: You take damage in water as if it were lava"),
            new Object[]{ new Pair(PotionEffectType.FIRE_RESISTANCE, 0) }, 10 * 2),
    Enderian("Enderian",
            createGuiItem(Material.ENDER_PEARL, true,
                    "§r§fEnderian",
                    "§7- Teleportation: Press you offhand swap key to throw a enderpearl",
                    "§7- Hydrophobia: You take damage in water as if it were lava"),
            new Object[]{}, 10 * 2),
    Piglin("Piglin",
            createGuiItem(Material.GOLDEN_SWORD, true,
                    "§r§fPiglin",
                    "§7- Gold Digger: Gold tools deal more damage",
                    "§7- Piglin Lineage: You have 8 hearts instead of 10",
                    "§7- Golden tools break WAY slower",
                    "§7- More features coming soon!"),
            new Object[]{}, 8 * 2),
    Shulk("Shulk",
            createGuiItem(Material.SHULKER_SHELL, true,
                    "§r§fShulk",
                    "§7- Heavy Shell: You loose hunger faster",
                    "§7- Shulker Inventory: By pressing your offhand swap key you",
                    "§7can open up a second inventory with 9 slots that's preserved",
                    "§7even through death",
                    "§7- Hard Shell: You have natural armor",
                    "§7- Unwieldy: You cannot use shields"),
            new Object[]{ new Pair(PotionEffectType.HUNGER, 0) }, 10 * 2),
    Fox("Fox",
            createGuiItem(Material.SWEET_BERRIES, true,
                    "§r§fFox",
                    "§7- Pounce: Press your offhand swap key to get launched in the air",
                    "§7while falling you deal a lot of damage",
                    "§7- Light Body: You have permanent jump boost 1 and speed 1",
                    "§7- Mighty Mouth: By pressing your offhand swap key and sneaking, thus",
                    "§7allowing you to open up a second inventory with 9 slots that's preserved",
                    "§7even through death",
                    "§7- Acrobatics: You never take fall damage",
                    "§7- Nocturnal: You have permanent night vision",
                    "§7- Berry Craver: You gain 1 extra hunger point from sweat berries",
                    "§7- Fast Metabolism: You loose hunger faster",
                    "§7- Unwieldy: You cannot use shields",
                    "§7- Smaller Heart: You have 6 max hearts"),
            new Object[]{ new Pair(PotionEffectType.HUNGER, 0), new Pair(PotionEffectType.NIGHT_VISION, 0), new Pair(PotionEffectType.JUMP, 0), new Pair(PotionEffectType.SPEED, 1) }, 6 * 2),
    Merling("Merling",
            createGuiItem(Material.COD, true,
                    "§r§fMerling",
                    "§7- Gills: You can breathe under water",
                    "§7- Adaptation: Water invigorates you, allowing you to mine faster",
                    "§7- Fins: You have permanent dolphins grace",
                    "§7- Gills: You cannot breath on land"),
            new Object[]{ new Pair(PotionEffectType.DOLPHINS_GRACE, 0) }, 10 * 2),
    Frog("Frog",
            createGuiItem(Material.SLIME_BALL, true,
                    "§r§fFrog",
                    "§7- Amphibious: You can breathe both in and out of water",
                    "§7- Webbed Feet: You have dolphins grace",
                    "§7- Hippity-Hoppity: You have jump boost 2",
                    "§7- Small Heart: You have 3 less hearts than a normal player",
                    "§7- Unwieldy: You cannot use shields",
                    "§7- Leap of Faith: Press your offhand swap key to get launched into the air",
                    "§7which allows you to deal more damage"),
            new Object[]{
                    new Pair(PotionEffectType.DOLPHINS_GRACE, 0),
                    new Pair(PotionEffectType.WATER_BREATHING, 0),
                    new Pair(PotionEffectType.JUMP, 1)
            }, 7 * 2),
    Evoker("Evoker",
         createGuiItem(Material.TOTEM_OF_UNDYING, true,
                 "§r§fEvoker",
                 "§7- Feared: You constantly have bad omen 5",
                 "§7- Fearsome: Villagers refuse to trade with you and",
                 "§7iron golems attack on sight",
                 "§7- Ally: You're allies with the rest of the illagers and",
                 "§7their spawn unless you provoke them",
                 "§7- Magician: You can summon vexes to fight for you at will",
                 "§7- Old Age: You have 1 less heart than a normal player and",
                 "§7 permanent slowness 1",
                 "§7- Unwieldy: You cannot use shields"),
            new Object[]{
                new Pair(PotionEffectType.BAD_OMEN, 4),
                new Pair(PotionEffectType.SLOW, 0),
    }, 9 * 2);
     */

    public NullOrigin origin;

    Origin(NullOrigin origin) {
         this.origin = origin;
    }
}