package fr.sithey.uhc.utils.register;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.scenarios.*;
import fr.sithey.uhc.scenarios.special.TaupeGun;
import fr.sithey.uhc.utils.api.Scenarios;
import org.bukkit.Material;

public enum GuiScenarioEnum {

    CUTCLEAN(11, 1, "Cutclean", "Les items sont déjà cuits.", Material.COOKED_CHICKEN , CutClean.class),
    GOLDENHEAD(12, 1, "GoldenHead", "Vous pouvez faire une tête en or qui vous redonnera 4 coeurs.", Material.GOLDEN_APPLE , GoldenHead.class),
    DIAMONDLESS(13, 1, "DiamondLess", "Impossible de miner du diamants. Vous en obtenez " + Main.getInstance().games.diamondkill + " lorsque vous tuez un joueur.", Material.DIAMOND , DiamondLess.class),
    BOOKCEPTION(14, 1, "BookCeption", "Vous obtenez un livre enchanté aléatoire lorsque vous tuez un joueur. Vous avez 10000 XP au début de la partie.", Material.BOOK , Bookception.class),
    GONEFISHING(15, 1, "GoneFishing", "Une canne à pêche lueur 3, 10000 XP ! Pêchez pour vous stuffer !", Material.FISHING_ROD , GoneFishing.class),
    SKYHIGH(19, 1, "SkyHigh", "Vous devez être au dessus de la couche 200 au bout de "+ Main.getInstance().games.skyhigh  / 60 + " ! Sinon vous perdrez "+ Main.getInstance().games.skydamage + "toutes les "+ Main.getInstance().games.skydtime / 20 + " !", Material.LADDER ,SkyHigh.class),
    SUPERHEROES(20, 1, "SuperHeroes", "Vous avez un ou plusieurs effet(s) aléatoire(s) au début de la partie.", Material.REDSTONE , SuperHeroes.class),
    TIMEBOMB(21, 1, "TimeBomb", "Lorsque vous tuez un joueur, le stuff est directement dans un grand coffre qui explosera au bout de " + TimeBomb.getCount() + ".", Material.CHEST , TimeBomb.class),
    NOCLEANUP(22, 1, "NoCleanUp", "Vous gagnez "+ Main.getInstance().games.healclean +" coeur lorsque vous tuez un joueur.", Material.SUGAR , NoCleanUP.class),
    BLOODDIAMOND(23, 1, "BloodDiamond", "Vous perdez "+ Main.getInstance().games.blooddamage + " lorsque vous minez un minerai de diamant.", Material.DIAMOND_ORE , BloodDiamond.class),
    RODLESS(24, 1, "RodLess", "Vous ne pouvez pas crafter de canne à pêche.", Material.FISHING_ROD , RodLess.class),
    NOSWORD(25, 1, "NoSword", "Vous ne pouvez pas crafter d’épée.", Material.WOOD_SWORD , NoSword.class),
    STUFFGIVE(28, 1, "StuffGive", "Un stuff BuildUHC vous a été donné, allez vous battre !", Material.LAVA_BUCKET , StuffGive.class),
    BOWSWAP(29, 1, "BowSwap", "Vous avez " + Main.getInstance().games.pourswap +" d’échanger votre position avec votre adversaire quand vous ou lui réussi sa flèche.", Material.BOW , BowSwap.class),
    CATEEYES(30, 1, "CatEyes", "Vous pouvez voir dans le noir !", Material.ENDER_PEARL , CateEyes.class),
    FINALHEAL(31, 1, "FinalHeal", "Tous les joueurs seront heal à " + Main.getInstance().games.healtime / 60 + " minutes de jeu.", Material.POTION , FinalHeal.class),
    DIAMONDLIMITE(32, 1, "DiamondLimite", "Vous pouvez miner seulement "+ Main.getInstance().games.diamondlimite +" durant la partie.", Material.DIAMOND_PICKAXE ,DiamondLimite.class),
    GOLDLIMITE(33, 1, "GoldLimite", "Vous pouvez miner seulement "+ Main.getInstance().games.goldlimite + " durant la partie.", Material.GOLD_PICKAXE , GoldLimite.class),
    NOENCHANT(34, 1, "NoEnchant", "La table d’enchantement est désactivée.", Material.ENCHANTMENT_TABLE , NoEnchant.class),
    NOBOOKSHELF(37, 1, "NoBookShelf", "Les bibliothèques sont désactivées.", Material.BOOKSHELF ,NoBookShelf.class),
    NETHERIBUS(38, 1, "Netheribus", "D’après la série “Netheribus” : Vous devez être dans le nether au bout de " + Main.getInstance().games.nethertime / 60 +" sous peine de perdre " + Main.getInstance().games.overdamage +" toutes les " + Main.getInstance().games.overdtime / 20+ "  !", Material.QUARTZ , NetheriBus.class),
    TIMBER(39, 1, "Timber", "Cassez un bloc d’un arbre et il se casse entièrement !", Material.WOOD , Timber.class),
    BAREBONES(41, 1, "BareBones", "Le Nether est désactivé. \nLe fer est le niveau le plus élevé que vous puissiez obtenir en vous préparant.\nLorsqu'un joueur meurt, il perd 1 diamant, 1 pomme d'or, 32 flèches et 2 cordes.\nL'extraction de tout minerai, à l'exception du charbon ou du fer, fera tomber un lingot de fer.", Material.IRON_INGOT , BareBones.class),
    BESTPVE(42, 1, "BestPVE", "Au début du jeu, les joueurs sont ajoutés à une liste appelée \"Meilleure liste PvE\". Si vous êtes sur cette liste, vous gagnerez 1 cœur supplémentaire toutes les 10 minutes et vous obtiendrez 1 cœur de régénération.\nUne fois qu'un joueur subit des dégâts, il est retiré de la 'meilleure liste PvE'.\nSi vous tuez un joueur, vous êtes ajouté à la liste.", Material.BREAD ,BestPVE.class),
    BESTBTC(43, 1, "BestBTC", "Toutes les 10 minutes où vous êtes sous Y = 50, vous gagnez un cœur. Aller au-dessus de Y = 50 vous fera sortir de la liste. Pour revenir, vous devez extraire un diamant.", Material.STONE , BestBTC.class),
    ENCHANTEDDEATH(47, 1, "EnchantedDeath", "Vous ne pouvez pas créer de tables d'enchantement, le seul moyen de les obtenir est de tuer des joueurs", Material.STONE_SWORD , EnchantedDeath.class),
    FLOWERPOWER(51, 1, "FlowerPower", "Lorsqu'un joueur casse une fleur au hasard, il y a une chance que la fleur laisse tomber un objet au hasard (à l'exception des pommes à échancrures).", Material.RED_ROSE ,FlowerPower.class),

    WEBCAGE(11, 2, "WebCage", "Une sphère de toiles d'araignées apparaît autour du lieu de la mort du joueur.", Material.WEB , WebCage.class),
    FASTSMELTING(12, 2, "FastSmelting", "Le temps de fusion est réduit.", Material.FURNACE ,FastSmelting.class),
    HASTEYBOYS(13, 2, "HasteyBoys", "Tout le monde mine plus vite (dès qu’on craft une pioche, hache, pelle ou un ehoue c’est directement enchanté en efficacité 3 unbreaking 3).", Material.DIAMOND_HOE , HasteyBoys.class),
    INFINITYENCHANTER(14, 2, "InfiniteEnchanteur", "Tous les joueurs commencent par 128 bibliothèques, niveaux Infinite XP, 64 enclumes et 64 tables d’enchantement.", Material.EXP_BOTTLE ,InfinityEnchanter.class),
    KILLSWITCH(15, 2, "KillSwitch", "Vous prenez l'inventaire de votre victime à la place du vôtre lorsque vous les tuez.", Material.WATER_LILY ,KillSwitch.class),
    LONGSHOTS(19, 2, "Longshots", "Toucher une flèche à +75 blocs donne 1 coeur et permet d’infliger 1.5 dmg supplémentaire.", Material.BOW , LongShot.class),
    NINESLOTS(20, 2, "NineSlots", "Vous ne pouvez utiliser votre barre de raccourcis que pour contenir des éléments.", Material.BARRIER , NineSlots.class),
    ONEHEAL(21, 2, "OneHeal", "Au début, vous obtenez une houe dorée, qui vous soigne complètement une fois. Après votre guérison, la houe disparaît. Vous pouvez toujours guérir des pommes d'or (et des têtes d'or si le scénario est activé).", Material.GOLD_HOE ,OneHeal.class),
    TRIPLE_ORES(22, 2, "TripleOres", "Les minerais sont multiplié par 3 lorsque vous les minés.", Material.GOLD_INGOT , TripleOres.class),
    COORDINATE(23, 2, "Coordinate", "Toutes les 1-10 minutes, les coordonées d'un joueur random seront écrites dans le chat.", Material.COMPASS ,Coordinate.class),
    ARMORVSHEALTH(24, 2, "ArmorVSHealth", "Pour chaque demi-point d'armure ajouté à votre barre d'armure, un demi-point de santé sera retiré de votre santé. Toute santé perdue pour une armure ne sera pas guérie.", Material.DIAMOND_CHESTPLATE , ArmorvsHealth.class),
    BETAZOMBIES(25, 2, "BetaZombies", "Les zombies drop des plumes.", Material.FEATHER ,BetaZombies.class),
    BLEEDINGSWEETS(28, 2, "BleedingSweets", "Drop de 1 diamond, 5 d'or, 1 fil et 16 fleches apres la mort.", Material.ARROW , BleedingSweets.class),
    CARROTCOMBO(29, 2, "CarrotCombo", "Au craft d'une épée, cela vous donne une carrot avec un enchantement égal a votre épée\n" + "\n" + "Epée en bois = Sharpness 2 Carrot\n" + "\n" + "Epée en or = Sharpness 2 Carrot\n" + "\n" + "Epée en pierre = Sharpness 3 Carrot\n" + "\n" + "Epée en fer = Sharpness 5 Carrot\n" +"\n" + "Epée en diamond = Sharpness 6 Carrot", Material.CARROT_ITEM , CarrotCombo.class),
    COMBO(30, 2, "Combo", "Un mode de jeu avec de vrais combo.", Material.POTION , Combo.class),
    FIRELESS(31, 2, "FireLess", "Pas de degat de Feu.", Material.BLAZE_POWDER , FireLess.class),
    FOODLESS(32, 2, "FoodLess", "Plus besoin de manger.", Material.COOKED_BEEF , FoodLess.class),
    NOFALL(33, 2, "NoFall", "Plus de degat de chut.", Material.GOLD_BOOTS ,NoFall.class),
    PERMAKILL(34, 2, "PermaKill", "Lorsqu'un joueur meurt, le temps bascule jour / nuit.", Material.WATCH , PermaKill.class),

    TAUPEGUN(0, 3, "TaupeGun", "Une taupe est choisie aléatoirement au sein d'une équipe et elle seule le sait. Son but est de déclencher la zizanie au bon moment pour faire gagner sa nouvelle team. Les taupes disposent d'un chat pour discuter entre elles et d'un kit random.", Material.TNT , TaupeGun.class);








    private int      slot;
    private int      page;
    private String   name;
    private String   desc;
    private Material material;
    private Class<? extends Scenarios> clazz;
    private boolean  enabled;

    GuiScenarioEnum(int slot, int page, String name, String desc,  Material material, Class<? extends Scenarios> clazz) {
        this.slot = slot;
        this.page = page;
        this.name = name;
        this.desc = desc;
        this.material = material;
        this.clazz = clazz;
    }

    public int getSlot() {
        return this.slot;
    }

    public int getPage() {
        return this.page;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }


    public Material getMaterial() {
        return this.material;
    }

    public Class<? extends Scenarios> getScenarioClass() {
        return this.clazz;
    }
    

    public boolean isEnabled() {
        return this.enabled;
    }

    public void toggleEnabled() {
        this.enabled = !this.enabled;
    }

}
