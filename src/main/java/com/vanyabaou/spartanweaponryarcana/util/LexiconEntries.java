package com.vanyabaou.spartanweaponryarcana.util;

import java.util.Arrays;
import java.util.List;

import com.vanyabaou.spartanweaponryarcana.SpartanWeaponryArcana;
import com.vanyabaou.spartanweaponryarcana.init.ItemRegistrySWA;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Optional;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.common.lexicon.CompatLexiconEntry;
import vazkii.botania.common.lexicon.page.PageCraftingRecipe;
import vazkii.botania.common.lexicon.page.PageText;

public class LexiconEntries 
{
	protected static LexiconEntry entryManasteelWeaponry;
	protected static LexiconEntry entryTerrasteelWeaponry;
	protected static LexiconEntry entryElementiumWeaponry;

	@Optional.Method(modid = ModHelper.MOD_ID_BOTANIA)
	public static void postInit()
	{
		final List<ResourceLocation> livingwoodHandles = Arrays.asList(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "handle_livingwood_string"),
																new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "handle_livingwood_leather"),
																new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "handle_livingwood_wool"));
		final List<ResourceLocation> livingwoodPoles = Arrays.asList(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "pole_livingwood_string"),
																new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "pole_livingwood_leather"),
																new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "pole_livingwood_wool"));

		final List<ResourceLocation> dreamwoodHandles = Arrays.asList(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "handle_dreamwood_string"),
																new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "handle_dreamwood_leather"),
																new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "handle_dreamwood_wool"));
		final List<ResourceLocation> dreamwoodPoles = Arrays.asList(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "pole_dreamwood_string"),
																new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "pole_dreamwood_leather"),
																new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "pole_dreamwood_wool"));
		final List<ResourceLocation> dreamwoodCrossbowLimb = Arrays.asList(new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "crossbow_limb_dreamwood"));
		
		entryManasteelWeaponry = new CompatLexiconEntry("manaWeaponry", BotaniaAPI.categoryTools, SpartanWeaponryArcana.MOD_NAME);
		entryManasteelWeaponry.setPriority().setLexiconPages(new PageText("0"),
				new PageCraftingRecipe("1", livingwoodHandles),
				new PageCraftingRecipe("2", livingwoodPoles),
				new PageCraftingRecipe("3", ItemRegistrySWA.daggerManasteel.getRegistryName()),
				new PageCraftingRecipe("4", ItemRegistrySWA.longswordManasteel.getRegistryName()),
				new PageCraftingRecipe("5", ItemRegistrySWA.katanaManasteel.getRegistryName()),
				new PageCraftingRecipe("6", ItemRegistrySWA.saberManasteel.getRegistryName()),
				new PageCraftingRecipe("7", ItemRegistrySWA.rapierManasteel.getRegistryName()),
				new PageCraftingRecipe("8", ItemRegistrySWA.greatswordManasteel.getRegistryName()),
				new PageCraftingRecipe("9", ItemRegistrySWA.hammerManasteel.getRegistryName()),
				new PageCraftingRecipe("10", ItemRegistrySWA.warhammerManasteel.getRegistryName()),
				new PageCraftingRecipe("11", ItemRegistrySWA.spearManasteel.getRegistryName()),
				new PageCraftingRecipe("12", ItemRegistrySWA.halberdManasteel.getRegistryName()),
				new PageCraftingRecipe("13", ItemRegistrySWA.pikeManasteel.getRegistryName()),
				new PageCraftingRecipe("14", ItemRegistrySWA.lanceManasteel.getRegistryName()),
				new PageCraftingRecipe("15", ItemRegistrySWA.longbowManasteel.getRegistryName()),
				new PageCraftingRecipe("16", ItemRegistrySWA.crossbowManasteel.getRegistryName()),
				new PageCraftingRecipe("17", ItemRegistrySWA.throwingKnifeManasteel.getRegistryName()),
				new PageCraftingRecipe("18", ItemRegistrySWA.throwingAxeManasteel.getRegistryName()),
				new PageCraftingRecipe("19", ItemRegistrySWA.javelinManasteel.getRegistryName()),
				new PageCraftingRecipe("20", ItemRegistrySWA.boomerangManasteel.getRegistryName()),
				new PageCraftingRecipe("21", ItemRegistrySWA.battleaxeManasteel.getRegistryName()),
				new PageCraftingRecipe("22", ItemRegistrySWA.maceManasteel.getRegistryName()),
				new PageCraftingRecipe("23", ItemRegistrySWA.glaiveManasteel.getRegistryName()),
				new PageCraftingRecipe("24", new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "quarterstaff_manasteel")));
		entryManasteelWeaponry.setIcon(ModHelper.getManasteelStack());
		
		entryTerrasteelWeaponry = new CompatLexiconEntry("terraWeaponry", BotaniaAPI.categoryTools, SpartanWeaponryArcana.MOD_NAME);
		entryTerrasteelWeaponry.setLexiconPages(new PageText("0"),
				new PageCraftingRecipe("1", ItemRegistrySWA.daggerTerrasteel.getRegistryName()),
				new PageCraftingRecipe("2", ItemRegistrySWA.longswordTerrasteel.getRegistryName()),
				new PageCraftingRecipe("3", ItemRegistrySWA.katanaTerrasteel.getRegistryName()),
				new PageCraftingRecipe("4", ItemRegistrySWA.saberTerrasteel.getRegistryName()),
				new PageCraftingRecipe("5", ItemRegistrySWA.rapierTerrasteel.getRegistryName()),
				new PageCraftingRecipe("6", ItemRegistrySWA.greatswordTerrasteel.getRegistryName()),
				new PageCraftingRecipe("7", ItemRegistrySWA.hammerTerrasteel.getRegistryName()),
				new PageCraftingRecipe("8", ItemRegistrySWA.warhammerTerrasteel.getRegistryName()),
				new PageCraftingRecipe("9", ItemRegistrySWA.spearTerrasteel.getRegistryName()),
				new PageCraftingRecipe("10", ItemRegistrySWA.halberdTerrasteel.getRegistryName()),
				new PageCraftingRecipe("11", ItemRegistrySWA.pikeTerrasteel.getRegistryName()),
				new PageCraftingRecipe("12", ItemRegistrySWA.lanceTerrasteel.getRegistryName()),
				new PageCraftingRecipe("13", ItemRegistrySWA.longbowTerrasteel.getRegistryName()),
				new PageCraftingRecipe("14", ItemRegistrySWA.crossbowTerrasteel.getRegistryName()),
				new PageCraftingRecipe("15", ItemRegistrySWA.throwingKnifeTerrasteel.getRegistryName()),
				new PageCraftingRecipe("16", ItemRegistrySWA.throwingAxeTerrasteel.getRegistryName()),
				new PageCraftingRecipe("17", ItemRegistrySWA.javelinTerrasteel.getRegistryName()),
				new PageCraftingRecipe("18", ItemRegistrySWA.boomerangTerrasteel.getRegistryName()),
				new PageCraftingRecipe("19", ItemRegistrySWA.battleaxeTerrasteel.getRegistryName()),
				new PageCraftingRecipe("20", ItemRegistrySWA.maceTerrasteel.getRegistryName()),
				new PageCraftingRecipe("21", ItemRegistrySWA.glaiveTerrasteel.getRegistryName()),
				new PageCraftingRecipe("22", new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "quarterstaff_terrasteel")));
		entryTerrasteelWeaponry.setIcon(ModHelper.getTerrasteelStack());
		
		entryElementiumWeaponry = new CompatLexiconEntry("elementiumWeaponry", BotaniaAPI.categoryTools, SpartanWeaponryArcana.MOD_NAME);
		entryElementiumWeaponry.setKnowledgeType(BotaniaAPI.elvenKnowledge).setLexiconPages(new PageText("0"),
				new PageCraftingRecipe("1", dreamwoodHandles),
				new PageCraftingRecipe("2", dreamwoodPoles),
				new PageCraftingRecipe("3", dreamwoodCrossbowLimb),
				new PageCraftingRecipe("4", ItemRegistrySWA.daggerElementium.getRegistryName()),
				new PageCraftingRecipe("5", ItemRegistrySWA.longswordElementium.getRegistryName()),
				new PageCraftingRecipe("6", ItemRegistrySWA.katanaElementium.getRegistryName()),
				new PageCraftingRecipe("7", ItemRegistrySWA.saberElementium.getRegistryName()),
				new PageCraftingRecipe("8", ItemRegistrySWA.rapierElementium.getRegistryName()),
				new PageCraftingRecipe("9", ItemRegistrySWA.greatswordElementium.getRegistryName()),
				new PageCraftingRecipe("10", ItemRegistrySWA.hammerElementium.getRegistryName()),
				new PageCraftingRecipe("11", ItemRegistrySWA.warhammerElementium.getRegistryName()),
				new PageCraftingRecipe("12", ItemRegistrySWA.spearElementium.getRegistryName()),
				new PageCraftingRecipe("13", ItemRegistrySWA.halberdElementium.getRegistryName()),
				new PageCraftingRecipe("14", ItemRegistrySWA.pikeElementium.getRegistryName()),
				new PageCraftingRecipe("15", ItemRegistrySWA.lanceElementium.getRegistryName()),
				new PageCraftingRecipe("16", ItemRegistrySWA.longbowElementium.getRegistryName()),
				new PageCraftingRecipe("17", ItemRegistrySWA.crossbowElementium.getRegistryName()),
				new PageCraftingRecipe("18", ItemRegistrySWA.throwingKnifeElementium.getRegistryName()),
				new PageCraftingRecipe("19", ItemRegistrySWA.throwingAxeElementium.getRegistryName()),
				new PageCraftingRecipe("20", ItemRegistrySWA.javelinElementium.getRegistryName()),
				new PageCraftingRecipe("21", ItemRegistrySWA.boomerangElementium.getRegistryName()),
				new PageCraftingRecipe("22", ItemRegistrySWA.battleaxeElementium.getRegistryName()),
				new PageCraftingRecipe("23", ItemRegistrySWA.maceElementium.getRegistryName()),
				new PageCraftingRecipe("24", ItemRegistrySWA.glaiveElementium.getRegistryName()),
				new PageCraftingRecipe("25", new ResourceLocation(SpartanWeaponryArcana.MOD_ID, "quarterstaff_elementium")));
		entryElementiumWeaponry.setIcon(ModHelper.getElementiumStack());
	}
}
