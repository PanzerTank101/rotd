package com.TheRPGAdventurer.server.handler;

import com.TheRPGAdventurer.client.init.ModArmour;
import com.TheRPGAdventurer.client.init.ModBlocks;
import com.TheRPGAdventurer.client.init.ModItems;
import com.TheRPGAdventurer.client.init.ModTools;
import com.TheRPGAdventurer.client.items.ItemDiamondShears;
import com.TheRPGAdventurer.client.items.ItemModAxe;
import com.TheRPGAdventurer.server.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {
	
	public static void registerCraftingRecipes(Item DragonScales, ItemModAxe DragonAxe, ItemPickaxe DragonPickaxe, ItemSword DragonSword, ItemSpade DragonShovel)  {
        Utils.getLogger().info("Registered Crafting Recipes!");
		registerToolRecipe(ModItems.JadeDragonScales, ModTools.jadeDragonPickaxe, ModTools.jadeDragonAxe, ModTools.jadeDragonShovel, ModTools.jadeDragonSword);
		registerArmourRecipe(ModArmour.jadeDragonScaleCap, ModArmour.jadeDragonScaleChestplate, ModArmour.jadeDragonScaleLeggings, ModArmour.jadeDragonScaleBoots, ModItems.JadeDragonScales);
		
		registerToolRecipe(ModItems.RubyDragonScales, ModTools.rubyDragonPickaxe, ModTools.rubyDragonAxe, ModTools.rubyDragonShovel, ModTools.rubyDragonSword);
		registerArmourRecipe(ModArmour.rubyDragonScaleCap, ModArmour.rubyDragonScaleChestplate, ModArmour.rubyDragonScaleLeggings, ModArmour.rubyDragonScaleBoots, ModItems.RubyDragonScales);
		
		registerToolRecipe(ModItems.AmethystDragonScales , ModTools.amethystDragonPickaxe, ModTools.amethystDragonAxe, ModTools.amethystDragonSword, ModTools.amethystDragonSword);
		registerArmourRecipe(ModArmour.amethystDragonScaleCap, ModArmour.amethystDragonscaleChesplate, ModArmour.amethystDragonScaleLeggings, ModArmour.amethystDragonScaleBoots, ModItems.AmethystDragonScales);
		
		registerToolRecipe(ModItems.GarnetDragonScales, ModTools.garnetDragonPickaxe, ModTools.garnetDragonAxe, ModTools.garnetDragonShovel, ModTools.garnetDragonSword);
		registerArmourRecipe(ModArmour.garnetDragonScaleCap, ModArmour.garnetDragonScaleChestplate, ModArmour.garnetDragonScaleLeggings, ModArmour.garnetDragonScaleBoots, ModItems.GarnetDragonScales);
		
		registerToolRecipe(ModItems.SapphireDragonScales, ModTools.sapphireDragonPickaxe, ModTools.sapphireDragonAxe, ModTools.sapphireDragonShovel, ModTools.sapphireDragonSword);
		registerArmourRecipe(ModArmour.sapphireDragonScaleCap, ModArmour.sapphireDragonScaleChestplate, ModArmour.sapphireDragonScaleLeggings, ModArmour.sapphireDragonScaleBoots, ModItems.SapphireDragonScales);
	}
		public static void registerFurnaceRecipes() {
        Utils.getLogger().info("Registered Furnace Recipes!");
	}
	
	private static void registerToolRecipe(Item scales, Item pickaxe, Item axe, Item shovel, Item sword) {
		GameRegistry.addRecipe(new ItemStack(pickaxe), new Object[] {"III"," S "," S ", 'I', scales, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(axe), new Object[] {" II"," SI"," S ", 'I', scales, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(axe), new Object[] {"II "," SI"," S ", 'I', scales, 'S', Items.STICK });
	    GameRegistry.addRecipe(new ItemStack(shovel), new Object[] {" I "," S "," S ", 'I', scales, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(shovel), new Object[] {"I  ","S  ","S  ", 'I', scales, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(shovel), new Object[] {"  I","  S","  S", 'I', scales, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(sword), new Object[] {" I "," I "," S ", 'I', scales, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(sword), new Object[] {"I  ","I  ","S  ", 'I', scales, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(sword), new Object[] {"  I","  I","  S", 'I', scales, 'S', Items.STICK });
	}
	
	public static void registerArmourRecipe(Item helmet, Item chestplate, Item leggings, Item boots, Item scales) {
		GameRegistry.addRecipe(new ItemStack(helmet), new Object[] { "III","I I","   ",'I',scales});
		GameRegistry.addRecipe(new ItemStack(helmet), new Object[] { "   ","III","I I",'I',scales});
		GameRegistry.addRecipe(new ItemStack(chestplate), new Object[] { "I I","III","III",'I',scales});
		GameRegistry.addRecipe(new ItemStack(leggings), new Object[] { "III","I I","I I",'I',scales});
		GameRegistry.addRecipe(new ItemStack(boots), new Object[] { "I I","I I","   ",'I',scales});
		GameRegistry.addRecipe(new ItemStack(boots), new Object[] { "   ","I I","I I",'I',scales});
	}
	
	
	private static void registerOtherRecipes() {
		GameRegistry.addRecipe(new ItemStack(ModBlocks.pileofsticks), new Object[] {"SSS","SSS","SSS", 'S', Items.STICK});
		GameRegistry.addRecipe(new ItemStack(ModTools.diamond_shears), new Object[] {" D","D ", 'D', Items.DIAMOND});
		
	}
}
		
	

	
