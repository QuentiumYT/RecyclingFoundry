package fr.frakass.recyclingfoundry;

import fr.frakass.recyclingfoundry.commands.MainCommand;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class RecyclingFoundry extends JavaPlugin implements Listener {
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getCommand("recyclingfoundry").setExecutor(new MainCommand(this));
        getCommand("recyclingfoundry").setTabCompleter(new Utils());
        saveDefaultConfig();
        loadRecipes();
    }

    public void registerRecipe(String key, Material input, Material output, Integer outputCount) {
        Server server = this.getServer();
        server.removeRecipe(new NamespacedKey(this, key));
        if (getConfig().getBoolean(key) == true) {
            FurnaceRecipe newRecipe = new FurnaceRecipe(
                    new NamespacedKey(this, key),
                    new ItemStack(output, outputCount),
                    input,
                    2,
                    100);
            newRecipe.setInput(input);
            server.addRecipe(newRecipe);
        }
    }

    public void loadRecipes() {
        // Netherite
        registerRecipe("NetheriteSword", Material.NETHERITE_SWORD, Material.NETHERITE_INGOT, 1);
        registerRecipe("NetheritePickaxe", Material.NETHERITE_PICKAXE, Material.NETHERITE_INGOT, 1);
        registerRecipe("NetheriteAxe", Material.NETHERITE_AXE, Material.NETHERITE_INGOT, 1);
        registerRecipe("NetheriteShovel", Material.NETHERITE_SHOVEL, Material.NETHERITE_INGOT, 1);
        registerRecipe("NetheriteHoe", Material.NETHERITE_HOE, Material.NETHERITE_INGOT, 1);
        registerRecipe("NetheriteHelmet", Material.NETHERITE_HELMET, Material.NETHERITE_INGOT, 1);
        registerRecipe("NetheriteChestplate", Material.NETHERITE_CHESTPLATE, Material.NETHERITE_INGOT, 1);
        registerRecipe("NetheriteLeggings", Material.NETHERITE_LEGGINGS, Material.NETHERITE_INGOT, 1);
        registerRecipe("NetheriteBoots", Material.NETHERITE_BOOTS, Material.NETHERITE_INGOT, 1);

        // Diamond
        registerRecipe("DiamondSword", Material.DIAMOND_SWORD, Material.DIAMOND, 2);
        registerRecipe("DiamondPickaxe", Material.DIAMOND_PICKAXE, Material.DIAMOND, 3);
        registerRecipe("DiamondAxe", Material.DIAMOND_AXE, Material.DIAMOND, 3);
        registerRecipe("DiamondShovel", Material.DIAMOND_SHOVEL, Material.DIAMOND, 1);
        registerRecipe("DiamondHoe", Material.DIAMOND_HOE, Material.DIAMOND, 2);
        registerRecipe("DiamondHelmet", Material.DIAMOND_HELMET, Material.DIAMOND, 5);
        registerRecipe("DiamondChestplate", Material.DIAMOND_CHESTPLATE, Material.DIAMOND, 8);
        registerRecipe("DiamondLeggings", Material.DIAMOND_LEGGINGS, Material.DIAMOND, 7);
        registerRecipe("DiamondBoots", Material.DIAMOND_BOOTS, Material.DIAMOND, 4);

        // Gold
        registerRecipe("GoldSword", Material.GOLDEN_SWORD, Material.GOLD_INGOT, 2);
        registerRecipe("GoldPickaxe", Material.GOLDEN_PICKAXE, Material.GOLD_INGOT, 3);
        registerRecipe("GoldAxe", Material.GOLDEN_AXE, Material.GOLD_INGOT, 3);
        registerRecipe("GoldShovel", Material.GOLDEN_SHOVEL, Material.GOLD_INGOT, 1);
        registerRecipe("GoldHoe", Material.GOLDEN_HOE, Material.GOLD_INGOT, 2);
        registerRecipe("GoldHelmet", Material.GOLDEN_HELMET, Material.GOLD_INGOT, 5);
        registerRecipe("GoldChestplate", Material.GOLDEN_CHESTPLATE, Material.GOLD_INGOT, 8);
        registerRecipe("GoldLeggings", Material.GOLDEN_LEGGINGS, Material.GOLD_INGOT, 7);
        registerRecipe("GoldBoots", Material.GOLDEN_BOOTS, Material.GOLD_INGOT, 4);

        // Iron
        registerRecipe("IronSword", Material.IRON_SWORD, Material.IRON_INGOT, 2);
        registerRecipe("IronPickaxe", Material.IRON_PICKAXE, Material.IRON_INGOT, 3);
        registerRecipe("IronAxe", Material.IRON_AXE, Material.IRON_INGOT, 3);
        registerRecipe("IronShovel", Material.IRON_SHOVEL, Material.IRON_INGOT, 1);
        registerRecipe("IronHoe", Material.IRON_HOE, Material.IRON_INGOT, 2);
        registerRecipe("IronHelmet", Material.IRON_HELMET, Material.IRON_INGOT, 5);
        registerRecipe("IronChestplate", Material.IRON_CHESTPLATE, Material.IRON_INGOT, 8);
        registerRecipe("IronLeggings", Material.IRON_LEGGINGS, Material.IRON_INGOT, 7);
        registerRecipe("IronBoots", Material.IRON_BOOTS, Material.IRON_INGOT, 4);

        // Stone
        registerRecipe("StoneSword", Material.STONE_SWORD, Material.STONE, 2);
        registerRecipe("StonePickaxe", Material.STONE_PICKAXE, Material.STONE, 3);
        registerRecipe("StoneAxe", Material.STONE_AXE, Material.STONE, 3);
        registerRecipe("StoneShovel", Material.STONE_SHOVEL, Material.STONE, 1);
        registerRecipe("StoneHoe", Material.STONE_HOE, Material.STONE, 2);

        // Wood
        registerRecipe("WoodSword", Material.WOODEN_SWORD, Material.OAK_PLANKS, 2);
        registerRecipe("WoodPickaxe", Material.WOODEN_PICKAXE, Material.OAK_PLANKS, 3);
        registerRecipe("WoodAxe", Material.WOODEN_AXE, Material.OAK_PLANKS, 3);
        registerRecipe("WoodShovel", Material.WOODEN_SHOVEL, Material.OAK_PLANKS, 1);
        registerRecipe("WoodHoe", Material.WOODEN_HOE, Material.OAK_PLANKS, 2);

        registerRecipe("DiamondHorseArmor", Material.DIAMOND_HORSE_ARMOR, Material.DIAMOND, 3);

        registerRecipe("GoldHorseArmor", Material.GOLDEN_HORSE_ARMOR, Material.GOLD_INGOT, 3);
        registerRecipe("Clock", Material.CLOCK, Material.GOLD_INGOT, 4);

        registerRecipe("IronHorseArmor", Material.IRON_HORSE_ARMOR, Material.IRON_INGOT, 3);
        registerRecipe("IronBars", Material.IRON_BARS, Material.IRON_NUGGET, 3);
        registerRecipe("IronDoor", Material.IRON_DOOR, Material.IRON_INGOT, 2);
        registerRecipe("IronTrapDoor", Material.IRON_TRAPDOOR, Material.IRON_INGOT, 4);
        registerRecipe("Shears", Material.SHEARS, Material.IRON_INGOT, 2);
        registerRecipe("Bucket", Material.BUCKET, Material.IRON_INGOT, 3);
        registerRecipe("Chain", Material.CHAIN, Material.IRON_NUGGET, 11);
        registerRecipe("Minecart", Material.MINECART, Material.IRON_INGOT, 5);
        registerRecipe("Cauldron", Material.CAULDRON, Material.IRON_INGOT, 7);

        // Rotten flesh to leather
        registerRecipe("RottenFlesh", Material.LEATHER, Material.ROTTEN_FLESH, 1);

        // Poisonous potato to potato
        registerRecipe("PoisonousPotato", Material.POISONOUS_POTATO, Material.POTATO, 2);
    }

    @EventHandler
    public void onFurnaceSmeltEvent(FurnaceSmeltEvent e) {
        @SuppressWarnings("deprecation")
        double durabilityPercent = ((double) e.getSource().getType().getMaxDurability()
                - (double) e.getSource().getDurability()) / (double) e.getSource().getType().getMaxDurability();

        switch (e.getSource().getType()) {
            case NETHERITE_SWORD:
                e.setResult(new ItemStack(Material.NETHERITE_INGOT, (int) (1 * durabilityPercent)));
                break;
            case NETHERITE_PICKAXE:
                e.setResult(new ItemStack(Material.NETHERITE_INGOT, (int) (1 * durabilityPercent)));
                break;
            case NETHERITE_AXE:
                e.setResult(new ItemStack(Material.NETHERITE_INGOT, (int) (1 * durabilityPercent)));
                break;
            case NETHERITE_SHOVEL:
                e.setResult(new ItemStack(Material.NETHERITE_INGOT, (int) (1 * durabilityPercent)));
                break;
            case NETHERITE_HOE:
                e.setResult(new ItemStack(Material.NETHERITE_INGOT, (int) (1 * durabilityPercent)));
                break;
            case NETHERITE_HELMET:
                e.setResult(new ItemStack(Material.NETHERITE_INGOT, (int) (1 * durabilityPercent)));
                break;
            case NETHERITE_CHESTPLATE:
                e.setResult(new ItemStack(Material.NETHERITE_INGOT, (int) (1 * durabilityPercent)));
                break;
            case NETHERITE_LEGGINGS:
                e.setResult(new ItemStack(Material.NETHERITE_INGOT, (int) (1 * durabilityPercent)));
                break;
            case NETHERITE_BOOTS:
                e.setResult(new ItemStack(Material.NETHERITE_INGOT, (int) (1 * durabilityPercent)));
                break;

            case DIAMOND_SWORD:
                e.setResult(new ItemStack(Material.DIAMOND, (int) (2 * durabilityPercent)));
                break;
            case DIAMOND_PICKAXE:
                e.setResult(new ItemStack(Material.DIAMOND, (int) (3 * durabilityPercent)));
                break;
            case DIAMOND_AXE:
                e.setResult(new ItemStack(Material.DIAMOND, (int) (3 * durabilityPercent)));
                break;
            case DIAMOND_SHOVEL:
                e.setResult(new ItemStack(Material.DIAMOND, (int) (1 * durabilityPercent)));
                break;
            case DIAMOND_HOE:
                e.setResult(new ItemStack(Material.DIAMOND, (int) (2 * durabilityPercent)));
                break;
            case DIAMOND_HELMET:
                e.setResult(new ItemStack(Material.DIAMOND, (int) (5 * durabilityPercent)));
                break;
            case DIAMOND_CHESTPLATE:
                e.setResult(new ItemStack(Material.DIAMOND, (int) (8 * durabilityPercent)));
                break;
            case DIAMOND_LEGGINGS:
                e.setResult(new ItemStack(Material.DIAMOND, (int) (7 * durabilityPercent)));
                break;
            case DIAMOND_BOOTS:
                e.setResult(new ItemStack(Material.DIAMOND, (int) (4 * durabilityPercent)));
                break;

            case IRON_SWORD:
                e.setResult(new ItemStack(Material.IRON_INGOT, (int) (2 * durabilityPercent)));
                break;
            case IRON_PICKAXE:
                e.setResult(new ItemStack(Material.IRON_INGOT, (int) (3 * durabilityPercent)));
                break;
            case IRON_AXE:
                e.setResult(new ItemStack(Material.IRON_INGOT, (int) (3 * durabilityPercent)));
                break;
            case IRON_SHOVEL:
                e.setResult(new ItemStack(Material.IRON_INGOT, (int) (1 * durabilityPercent)));
                break;
            case IRON_HOE:
                e.setResult(new ItemStack(Material.IRON_INGOT, (int) (2 * durabilityPercent)));
                break;
            case IRON_HELMET:
                e.setResult(new ItemStack(Material.IRON_INGOT, (int) (5 * durabilityPercent)));
                break;
            case IRON_CHESTPLATE:
                e.setResult(new ItemStack(Material.IRON_INGOT, (int) (8 * durabilityPercent)));
                break;
            case IRON_LEGGINGS:
                e.setResult(new ItemStack(Material.IRON_INGOT, (int) (7 * durabilityPercent)));
                break;
            case IRON_BOOTS:
                e.setResult(new ItemStack(Material.IRON_INGOT, (int) (4 * durabilityPercent)));
                break;

            case GOLDEN_SWORD:
                e.setResult(new ItemStack(Material.GOLD_INGOT, (int) (2 * durabilityPercent)));
                break;
            case GOLDEN_PICKAXE:
                e.setResult(new ItemStack(Material.GOLD_INGOT, (int) (3 * durabilityPercent)));
                break;
            case GOLDEN_AXE:
                e.setResult(new ItemStack(Material.GOLD_INGOT, (int) (3 * durabilityPercent)));
                break;
            case GOLDEN_SHOVEL:
                e.setResult(new ItemStack(Material.GOLD_INGOT, (int) (1 * durabilityPercent)));
                break;
            case GOLDEN_HOE:
                e.setResult(new ItemStack(Material.GOLD_INGOT, (int) (2 * durabilityPercent)));
                break;
            case GOLDEN_HELMET:
                e.setResult(new ItemStack(Material.GOLD_INGOT, (int) (5 * durabilityPercent)));
                break;
            case GOLDEN_CHESTPLATE:
                e.setResult(new ItemStack(Material.GOLD_INGOT, (int) (8 * durabilityPercent)));
                break;
            case GOLDEN_LEGGINGS:
                e.setResult(new ItemStack(Material.GOLD_INGOT, (int) (7 * durabilityPercent)));
                break;
            case GOLDEN_BOOTS:
                e.setResult(new ItemStack(Material.GOLD_INGOT, (int) (4 * durabilityPercent)));
                break;

            case SHEARS:
                e.setResult(new ItemStack(Material.IRON_INGOT, (int) (2 * durabilityPercent)));
                break;

            default:
                break;
        }
    }
}