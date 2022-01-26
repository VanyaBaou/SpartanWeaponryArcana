package com.vanyabaou.spartanweaponryarcana.util;

import java.util.ArrayList;
import java.util.List;

import com.vanyabaou.spartanweaponryarcana.SpartanWeaponryArcana;
import com.vanyabaou.spartanweaponryarcana.init.ItemRegistrySWA;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import thaumcraft.api.ThaumcraftApi;

public class ModHelper
{
	// External Mods
	public static final String MOD_ID_BOTANIA = "botania";
	public static final String MOD_ID_THAUMCRAFT = "thaumcraft";
	public static final String MOD_ID_EMBERS = "embers";

	protected static boolean loadedBotania = false;
	protected static boolean loadedThaumcraft = false;
	protected static boolean loadedEmbers = false;
	
	public static void preInit()
	{
		final ResourceLocation thaumiumWeaponsRecipe = new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "thaumium_weaponry");
		final ResourceLocation voidWeaponsRecipe = new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "void_weaponry");
		List<ResourceLocation> thaumiumRecipes = new ArrayList<ResourceLocation>();
		List<ResourceLocation> voidRecipes = new ArrayList<ResourceLocation>();
		
		loadedBotania = Loader.isModLoaded(MOD_ID_BOTANIA);
		loadedThaumcraft = Loader.isModLoaded(MOD_ID_THAUMCRAFT);
		loadedEmbers = Loader.isModLoaded(MOD_ID_EMBERS);
		
		if(loadedThaumcraft)
		{
			ThaumcraftApi.registerResearchLocation(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "research/sw_arcana"));
			
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "dagger_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "longsword_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "katana_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "saber_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "rapier_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "greatsword_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "hammer_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "warhammer_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "spear_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "halberd_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "pike_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "lance_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "longbow_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "crossbow_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "throwing_knife_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "throwing_axe_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "javelin_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "boomerang_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "battleaxe_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "mace_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "glaive_thaumium"));
			thaumiumRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "quarterstaff_thaumium"));

			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "dagger_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "longsword_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "katana_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "saber_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "rapier_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "greatsword_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "hammer_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "warhammer_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "spear_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "halberd_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "pike_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "lance_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "longbow_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "crossbow_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "throwing_knife_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "throwing_axe_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "javelin_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "boomerang_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "battleaxe_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "mace_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "glaive_voidmetal"));
			voidRecipes.add(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "quarterstaff_voidmetal"));
			
			ThaumcraftApi.addFakeCraftingRecipe(thaumiumWeaponsRecipe, thaumiumRecipes);
			ThaumcraftApi.addFakeCraftingRecipe(voidWeaponsRecipe, voidRecipes);
		}
	}
	
	public static boolean isBotaniaLoaded()
	{
		return loadedBotania;
	}
	
	public static boolean isThaumcraftLoaded()
	{
		return loadedThaumcraft;
	}

	public static boolean isEmbersLoaded() { return loadedEmbers; }
	
	public static ItemStack getTerrasteelStack()
	{
		Item icon = ItemRegistrySWA.material;
		if(ItemRegistrySWA.longswordTerrasteel != null) 			icon = ItemRegistrySWA.longswordTerrasteel;
		else if(ItemRegistrySWA.greatswordTerrasteel != null)		icon = ItemRegistrySWA.greatswordTerrasteel;
		else if(ItemRegistrySWA.daggerTerrasteel != null)			icon = ItemRegistrySWA.daggerTerrasteel;
		else if(ItemRegistrySWA.katanaTerrasteel != null)			icon = ItemRegistrySWA.katanaTerrasteel;
		else if(ItemRegistrySWA.saberTerrasteel != null)			icon = ItemRegistrySWA.saberTerrasteel;
		else if(ItemRegistrySWA.rapierTerrasteel != null)			icon = ItemRegistrySWA.rapierTerrasteel;
		else if(ItemRegistrySWA.hammerTerrasteel != null)			icon = ItemRegistrySWA.hammerTerrasteel;
		else if(ItemRegistrySWA.warhammerTerrasteel != null)		icon = ItemRegistrySWA.warhammerTerrasteel;
		else if(ItemRegistrySWA.spearTerrasteel != null)			icon = ItemRegistrySWA.spearTerrasteel;
		else if(ItemRegistrySWA.halberdTerrasteel != null)			icon = ItemRegistrySWA.halberdTerrasteel;
		else if(ItemRegistrySWA.pikeTerrasteel != null)				icon = ItemRegistrySWA.pikeTerrasteel;
		else if(ItemRegistrySWA.lanceTerrasteel != null)			icon = ItemRegistrySWA.lanceTerrasteel;
		else if(ItemRegistrySWA.longbowTerrasteel != null)			icon = ItemRegistrySWA.longbowTerrasteel;
		else if(ItemRegistrySWA.crossbowTerrasteel != null)			icon = ItemRegistrySWA.crossbowTerrasteel;
		else if(ItemRegistrySWA.throwingKnifeTerrasteel != null)	icon = ItemRegistrySWA.throwingKnifeTerrasteel;
		else if(ItemRegistrySWA.throwingAxeTerrasteel != null)		icon = ItemRegistrySWA.throwingAxeTerrasteel;
		else if(ItemRegistrySWA.javelinTerrasteel != null)			icon = ItemRegistrySWA.javelinTerrasteel;
		else if(ItemRegistrySWA.boomerangTerrasteel != null)		icon = ItemRegistrySWA.boomerangTerrasteel;
		else if(ItemRegistrySWA.battleaxeTerrasteel != null)		icon = ItemRegistrySWA.battleaxeTerrasteel;
		else if(ItemRegistrySWA.maceTerrasteel != null)				icon = ItemRegistrySWA.maceTerrasteel;
		else if(ItemRegistrySWA.glaiveTerrasteel != null)			icon = ItemRegistrySWA.glaiveTerrasteel;
		else if(ItemRegistrySWA.staffTerrasteel != null)			icon = ItemRegistrySWA.staffTerrasteel;
		
		return new ItemStack(icon);
	}
	
	public static ItemStack getManasteelStack()
	{
		Item icon = ItemRegistrySWA.material;
		if(ItemRegistrySWA.longswordManasteel != null) 			icon = ItemRegistrySWA.longswordManasteel;
		else if(ItemRegistrySWA.greatswordManasteel != null)		icon = ItemRegistrySWA.greatswordManasteel;
		else if(ItemRegistrySWA.daggerManasteel != null)			icon = ItemRegistrySWA.daggerManasteel;
		else if(ItemRegistrySWA.katanaManasteel != null)			icon = ItemRegistrySWA.katanaManasteel;
		else if(ItemRegistrySWA.saberManasteel != null)			icon = ItemRegistrySWA.saberManasteel;
		else if(ItemRegistrySWA.rapierManasteel != null)			icon = ItemRegistrySWA.rapierManasteel;
		else if(ItemRegistrySWA.hammerManasteel != null)			icon = ItemRegistrySWA.hammerManasteel;
		else if(ItemRegistrySWA.warhammerManasteel != null)		icon = ItemRegistrySWA.warhammerManasteel;
		else if(ItemRegistrySWA.spearManasteel != null)			icon = ItemRegistrySWA.spearManasteel;
		else if(ItemRegistrySWA.halberdManasteel != null)			icon = ItemRegistrySWA.halberdManasteel;
		else if(ItemRegistrySWA.pikeManasteel != null)				icon = ItemRegistrySWA.pikeManasteel;
		else if(ItemRegistrySWA.lanceManasteel != null)			icon = ItemRegistrySWA.lanceManasteel;
		else if(ItemRegistrySWA.longbowManasteel != null)			icon = ItemRegistrySWA.longbowManasteel;
		else if(ItemRegistrySWA.crossbowManasteel != null)			icon = ItemRegistrySWA.crossbowManasteel;
		else if(ItemRegistrySWA.throwingKnifeManasteel != null)	icon = ItemRegistrySWA.throwingKnifeManasteel;
		else if(ItemRegistrySWA.throwingAxeManasteel != null)		icon = ItemRegistrySWA.throwingAxeManasteel;
		else if(ItemRegistrySWA.javelinManasteel != null)			icon = ItemRegistrySWA.javelinManasteel;
		else if(ItemRegistrySWA.boomerangManasteel != null)		icon = ItemRegistrySWA.boomerangManasteel;
		else if(ItemRegistrySWA.battleaxeManasteel != null)		icon = ItemRegistrySWA.battleaxeManasteel;
		else if(ItemRegistrySWA.maceManasteel != null)				icon = ItemRegistrySWA.maceManasteel;
		else if(ItemRegistrySWA.glaiveManasteel != null)			icon = ItemRegistrySWA.glaiveManasteel;
		else if(ItemRegistrySWA.staffManasteel != null)			icon = ItemRegistrySWA.staffManasteel;
		
		return new ItemStack(icon);
	}
	
	public static ItemStack getElementiumStack()
	{
		Item icon = ItemRegistrySWA.material;
		if(ItemRegistrySWA.longswordElementium != null) 			icon = ItemRegistrySWA.longswordElementium;
		else if(ItemRegistrySWA.greatswordElementium != null)		icon = ItemRegistrySWA.greatswordElementium;
		else if(ItemRegistrySWA.daggerElementium != null)			icon = ItemRegistrySWA.daggerElementium;
		else if(ItemRegistrySWA.katanaElementium != null)			icon = ItemRegistrySWA.katanaElementium;
		else if(ItemRegistrySWA.saberElementium != null)			icon = ItemRegistrySWA.saberElementium;
		else if(ItemRegistrySWA.rapierElementium != null)			icon = ItemRegistrySWA.rapierElementium;
		else if(ItemRegistrySWA.hammerElementium != null)			icon = ItemRegistrySWA.hammerElementium;
		else if(ItemRegistrySWA.warhammerElementium != null)		icon = ItemRegistrySWA.warhammerElementium;
		else if(ItemRegistrySWA.spearElementium != null)			icon = ItemRegistrySWA.spearElementium;
		else if(ItemRegistrySWA.halberdElementium != null)			icon = ItemRegistrySWA.halberdElementium;
		else if(ItemRegistrySWA.pikeElementium != null)				icon = ItemRegistrySWA.pikeElementium;
		else if(ItemRegistrySWA.lanceElementium != null)			icon = ItemRegistrySWA.lanceElementium;
		else if(ItemRegistrySWA.longbowElementium != null)			icon = ItemRegistrySWA.longbowElementium;
		else if(ItemRegistrySWA.crossbowElementium != null)			icon = ItemRegistrySWA.crossbowElementium;
		else if(ItemRegistrySWA.throwingKnifeElementium != null)	icon = ItemRegistrySWA.throwingKnifeElementium;
		else if(ItemRegistrySWA.throwingAxeElementium != null)		icon = ItemRegistrySWA.throwingAxeElementium;
		else if(ItemRegistrySWA.javelinElementium != null)			icon = ItemRegistrySWA.javelinElementium;
		else if(ItemRegistrySWA.boomerangElementium != null)		icon = ItemRegistrySWA.boomerangElementium;
		else if(ItemRegistrySWA.battleaxeElementium != null)		icon = ItemRegistrySWA.battleaxeElementium;
		else if(ItemRegistrySWA.maceElementium != null)				icon = ItemRegistrySWA.maceElementium;
		else if(ItemRegistrySWA.glaiveElementium != null)			icon = ItemRegistrySWA.glaiveElementium;
		else if(ItemRegistrySWA.staffElementium != null)			icon = ItemRegistrySWA.staffElementium;
		
		return new ItemStack(icon);
	}

}
