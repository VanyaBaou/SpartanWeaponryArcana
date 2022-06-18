package com.vanyabaou.spartanweaponryarcana.init;

import java.util.ArrayList;

import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.item.ItemLance;
import com.oblivioussp.spartanweaponry.util.ConfigHandler;
import com.vanyabaou.spartanweaponryarcana.SpartanWeaponryArcana;
import com.vanyabaou.spartanweaponryarcana.client.gui.CreativeTabsSWA;
import com.vanyabaou.spartanweaponryarcana.item.*;
import com.vanyabaou.spartanweaponryarcana.util.LogHelper;
import com.vanyabaou.spartanweaponryarcana.util.ModHelper;
import com.vanyabaou.spartanweaponryarcana.weaponproperty.*;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import teamroots.embers.RegistryManager;
import thaumcraft.api.ThaumcraftMaterials;
import vazkii.botania.api.BotaniaAPI;

@EventBusSubscriber(modid = SpartanWeaponryArcana.MOD_ID)
public class ItemRegistrySWA {
	public static ToolMaterialEx materialManasteel,
								materialTerrasteel,
								materialElementium,
								materialThaumium,
								materialVoidmetal,
								materialDawnstone;
	
	public static ItemMultiSWA material = (ItemMultiSWA) new ItemMultiSWA("material", "handle_livingwood", "pole_livingwood", "handle_dreamwood", "pole_dreamwood", "crossbow_limb_dreamwood").setCreativeTab(CreativeTabsSWA.TAB_SWA);
	
	public static Item 			daggerManasteel, daggerTerrasteel, daggerElementium, daggerThaumium, daggerVoidmetal, daggerDawnstone,
								longswordManasteel, longswordTerrasteel, longswordElementium, longswordThaumium, longswordVoidmetal, longswordDawnstone,
								katanaManasteel, katanaTerrasteel, katanaElementium, katanaThaumium, katanaVoidmetal, katanaDawnstone,
								saberManasteel, saberTerrasteel, saberElementium, saberThaumium, saberVoidmetal, saberDawnstone,
								rapierManasteel, rapierTerrasteel, rapierElementium, rapierThaumium, rapierVoidmetal, rapierDawnstone,
								greatswordManasteel, greatswordTerrasteel, greatswordElementium, greatswordThaumium, greatswordVoidmetal, greatswordDawnstone,
								hammerManasteel, hammerTerrasteel, hammerElementium, hammerThaumium, hammerVoidmetal, hammerDawnstone,
								warhammerManasteel, warhammerTerrasteel, warhammerElementium, warhammerThaumium, warhammerVoidmetal, warhammerDawnstone,
								spearManasteel, spearTerrasteel, spearElementium, spearThaumium, spearVoidmetal, spearDawnstone,
								halberdManasteel, halberdTerrasteel, halberdElementium, halberdThaumium, halberdVoidmetal, halberdDawnstone,
								pikeManasteel, pikeTerrasteel, pikeElementium, pikeThaumium, pikeVoidmetal, pikeDawnstone,
								lanceManasteel, lanceTerrasteel, lanceElementium, lanceThaumium, lanceVoidmetal, lanceDawnstone,
								longbowManasteel, longbowTerrasteel, longbowElementium, longbowThaumium, longbowVoidmetal, longbowDawnstone,
								crossbowManasteel, crossbowTerrasteel, crossbowElementium, crossbowThaumium, crossbowVoidmetal, crossbowDawnstone,
								throwingKnifeManasteel, throwingKnifeTerrasteel, throwingKnifeElementium, throwingKnifeThaumium, throwingKnifeVoidmetal, throwingKnifeDawnstone,
								throwingAxeManasteel, throwingAxeTerrasteel, throwingAxeElementium, throwingAxeThaumium, throwingAxeVoidmetal, throwingAxeDawnstone,
								javelinManasteel, javelinTerrasteel, javelinElementium, javelinThaumium, javelinVoidmetal, javelinDawnstone,
								boomerangManasteel, boomerangTerrasteel, boomerangElementium, boomerangThaumium, boomerangVoidmetal, boomerangDawnstone,
								battleaxeManasteel, battleaxeTerrasteel, battleaxeElementium, battleaxeThaumium, battleaxeVoidmetal, battleaxeDawnstone,
								maceManasteel, maceTerrasteel, maceElementium, maceThaumium, maceVoidmetal, maceDawnstone,
								glaiveManasteel, glaiveTerrasteel, glaiveElementium, glaiveThaumium, glaiveVoidmetal, glaiveDawnstone,
								staffManasteel, staffTerrasteel, staffElementium, staffThaumium, staffVoidmetal, staffDawnstone,
								parryManasteel, parryTerrasteel, parryElementium, parryThaumium, parryVoidmetal, parryDawnstone;
								
	public static ArrayList<Item> weapons = new ArrayList<>();
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> ev) {
		IForgeRegistry<Item> registry = ev.getRegistry();
		
		if(ModHelper.isBotaniaLoaded()) {
			materialManasteel = new ToolMaterialEx("manasteel", BotaniaAPI.manasteelToolMaterial, "ingotManasteel", SpartanWeaponryArcana.MOD_ID, BotaniaAPI.manasteelToolMaterial.getAttackDamage(), WeaponPropertySWA.ManaRegenerate);
			materialTerrasteel = new ToolMaterialEx("terrasteel", BotaniaAPI.terrasteelToolMaterial, "ingotTerrasteel", SpartanWeaponryArcana.MOD_ID, BotaniaAPI.terrasteelToolMaterial.getAttackDamage(), WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash);
			materialElementium = new ToolMaterialEx("elementium", BotaniaAPI.elementiumToolMaterial, "ingotElvenElementium", SpartanWeaponryArcana.MOD_ID, BotaniaAPI.elementiumToolMaterial.getAttackDamage(), WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P);
		} else {
			materialManasteel = new ToolMaterialEx("manasteel", "ingotManasteel", SpartanWeaponryArcana.MOD_ID, 0x0, 0x0, 3, 300, 6.2f, 2.0f, 20, WeaponPropertySWA.ManaRegenerate);
			materialTerrasteel = new ToolMaterialEx("terrasteel", "ingotTerrasteel", SpartanWeaponryArcana.MOD_ID, 0x0, 0x0, 4, 2300, 9.0f, 3.0f, 26, WeaponPropertySWA.ManaRegenerateTerra, WeaponPropertySWA.TerraSlash);
			materialElementium = new ToolMaterialEx("elementium", "ingotElvenElementium", SpartanWeaponryArcana.MOD_ID, 0x0, 0x0, 3, 720, 6.2f, 2.0f, 20, WeaponPropertySWA.ManaRegenerate, WeaponPropertySWA.Pixielated5P);
		}
		
		if(ModHelper.isThaumcraftLoaded()) {
			materialThaumium = new ToolMaterialEx("thaumium", ThaumcraftMaterials.TOOLMAT_THAUMIUM, "ingotThaumium", SpartanWeaponryArcana.MOD_ID);
			materialVoidmetal = new ToolMaterialEx("voidmetal", ThaumcraftMaterials.TOOLMAT_VOID, "ingotVoid", SpartanWeaponryArcana.MOD_ID, ThaumcraftMaterials.TOOLMAT_VOID.getAttackDamage(), WeaponPropertySWA.Warped);
		} else {
			materialThaumium = new ToolMaterialEx("thaumium", "ingotThaumium", SpartanWeaponryArcana.MOD_ID, 0x0, 0x0, 3, 500, 7.0f, 2.5f, 22);
			materialVoidmetal = new ToolMaterialEx("voidmetal", "ingotVoid", SpartanWeaponryArcana.MOD_ID, 0x0, 0x0, 4, 150, 8.0f, 3.0f, 10);
		}
		
		if(ModHelper.isEmbersLoaded()) {
			materialDawnstone = new ToolMaterialEx("dawnstone", RegistryManager.tool_mat_dawnstone, "ingotDawnstone", SpartanWeaponryArcana.MOD_ID, RegistryManager.tool_mat_dawnstone.getAttackDamage(), WeaponPropertySWA.Clockwork);
		} else {
			materialDawnstone = new ToolMaterialEx("dawnstone", "ingotDawnstone", SpartanWeaponryArcana.MOD_ID, 0x0, 0x0, 2, -1, 7.5f, 2.5f, 18);
		}
		
		registry.register(material);

		if (!ConfigHandler.disableDagger) {
			daggerManasteel = new ItemDaggerSWA("dagger_manasteel", materialManasteel);
			daggerTerrasteel = new ItemDaggerSWA("dagger_terrasteel", materialTerrasteel);
			daggerElementium = new ItemDaggerSWA("dagger_elementium", materialElementium);
			daggerThaumium = SpartanWeaponryAPI.createDagger(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			daggerVoidmetal = SpartanWeaponryAPI.createDagger(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			daggerDawnstone = new ItemDaggerSWA("dagger_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(daggerManasteel, daggerTerrasteel, daggerElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(daggerThaumium, daggerVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(daggerDawnstone);
			}
		}
		if (!ConfigHandler.disableLongsword) {
			longswordManasteel = new ItemLongswordSWA("longsword_manasteel", materialManasteel);
			longswordTerrasteel = new ItemLongswordSWA("longsword_terrasteel", materialTerrasteel);
			longswordElementium = new ItemLongswordSWA("longsword_elementium", materialElementium);
			longswordThaumium = SpartanWeaponryAPI.createLongsword(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			longswordVoidmetal = SpartanWeaponryAPI.createLongsword(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			longswordDawnstone = new ItemLongswordSWA("longsword_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(longswordManasteel, longswordTerrasteel, longswordElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(longswordThaumium, longswordVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(longswordDawnstone);
			}
		}
		if (!ConfigHandler.disableKatana) {
			katanaManasteel = new ItemKatanaSWA("katana_manasteel", materialManasteel);
			katanaTerrasteel = new ItemKatanaSWA("katana_terrasteel", materialTerrasteel);
			katanaElementium = new ItemKatanaSWA("katana_elementium", materialElementium);
			katanaThaumium = SpartanWeaponryAPI.createKatana(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			katanaVoidmetal = SpartanWeaponryAPI.createKatana(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			katanaDawnstone = new ItemKatanaSWA("katana_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(katanaManasteel, katanaTerrasteel, katanaElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(katanaThaumium, katanaVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(katanaDawnstone);
			}
		}
		if (!ConfigHandler.disableSaber) {
			saberManasteel = new ItemSaberSWA("saber_manasteel", materialManasteel);
			saberTerrasteel = new ItemSaberSWA("saber_terrasteel", materialTerrasteel);
			saberElementium = new ItemSaberSWA("saber_elementium", materialElementium);
			saberThaumium = SpartanWeaponryAPI.createSaber(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			saberVoidmetal = SpartanWeaponryAPI.createSaber(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			saberDawnstone = new ItemSaberSWA("saber_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(saberManasteel, saberTerrasteel, saberElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(saberThaumium, saberVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(saberDawnstone);
			}
		}
		if (!ConfigHandler.disableRapier) {
			rapierManasteel = new ItemRapierSWA("rapier_manasteel", materialManasteel);
			rapierTerrasteel = new ItemRapierSWA("rapier_terrasteel", materialTerrasteel);
			rapierElementium = new ItemRapierSWA("rapier_elementium", materialElementium);
			rapierThaumium = SpartanWeaponryAPI.createRapier(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			rapierVoidmetal = SpartanWeaponryAPI.createRapier(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			rapierDawnstone = new ItemRapierSWA("rapier_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(rapierManasteel, rapierTerrasteel, rapierElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(rapierThaumium, rapierVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(rapierDawnstone);
			}
		}
		if (!ConfigHandler.disableGreatsword) {
			greatswordManasteel = new ItemGreatswordSWA("greatsword_manasteel", materialManasteel);
			greatswordTerrasteel = new ItemGreatswordSWA("greatsword_terrasteel", materialTerrasteel);
			greatswordElementium = new ItemGreatswordSWA("greatsword_elementium", materialElementium);
			greatswordThaumium = SpartanWeaponryAPI.createGreatsword(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			greatswordVoidmetal = SpartanWeaponryAPI.createGreatsword(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA, WeaponPropertySWA.Warped);
			greatswordDawnstone = new ItemGreatswordSWA("greatsword_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(greatswordManasteel, greatswordTerrasteel, greatswordElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(greatswordThaumium, greatswordVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(greatswordDawnstone);
			}
		}
		if (!ConfigHandler.disableHammer) {
			hammerManasteel = new ItemHammerSWA("hammer_manasteel", materialManasteel);
			hammerTerrasteel = new ItemHammerSWA("hammer_terrasteel", materialTerrasteel);
			hammerElementium = new ItemHammerSWA("hammer_elementium", materialElementium);
			hammerThaumium = SpartanWeaponryAPI.createHammer(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			hammerVoidmetal = SpartanWeaponryAPI.createHammer(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			hammerDawnstone = new ItemHammerSWA("hammer_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(hammerManasteel, hammerTerrasteel, hammerElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(hammerThaumium, hammerVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(hammerDawnstone);
			}
		}
		if (!ConfigHandler.disableWarhammer) {
			warhammerManasteel = new ItemWarhammerSWA("warhammer_manasteel", materialManasteel);
			warhammerTerrasteel = new ItemWarhammerSWA("warhammer_terrasteel", materialTerrasteel);
			warhammerElementium = new ItemWarhammerSWA("warhammer_elementium", materialElementium);
			warhammerThaumium = SpartanWeaponryAPI.createWarhammer(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			warhammerVoidmetal = SpartanWeaponryAPI.createWarhammer(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			warhammerDawnstone = new ItemWarhammerSWA("warhammer_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(warhammerManasteel, warhammerTerrasteel, warhammerElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(warhammerThaumium, warhammerVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(warhammerDawnstone);
			}
		}
		if (!ConfigHandler.disableSpear) {
			spearManasteel = new ItemSpearSWA("spear_manasteel", materialManasteel);
			spearTerrasteel = new ItemSpearSWA("spear_terrasteel", materialTerrasteel);
			spearElementium = new ItemSpearSWA("spear_elementium", materialElementium);
			spearThaumium = SpartanWeaponryAPI.createSpear(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			spearVoidmetal = SpartanWeaponryAPI.createSpear(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			spearDawnstone = new ItemSpearSWA("spear_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(spearManasteel, spearTerrasteel, spearElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(spearThaumium, spearVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(spearDawnstone);
			}
		}
		if (!ConfigHandler.disableHalberd) {
			halberdManasteel = new ItemHalberdSWA("halberd_manasteel", materialManasteel);
			halberdTerrasteel = new ItemHalberdSWA("halberd_terrasteel", materialTerrasteel);
			halberdElementium = new ItemHalberdSWA("halberd_elementium", materialElementium);
			halberdThaumium = SpartanWeaponryAPI.createHalberd(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			halberdVoidmetal = SpartanWeaponryAPI.createHalberd(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			halberdDawnstone = new ItemHalberdSWA("halberd_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(halberdManasteel, halberdTerrasteel, halberdElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(halberdThaumium, halberdVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(halberdDawnstone);
			}
		}
		if (!ConfigHandler.disablePike) {
			pikeManasteel = new ItemPikeSWA("pike_manasteel", materialManasteel);
			pikeTerrasteel = new ItemPikeSWA("pike_terrasteel", materialTerrasteel);
			pikeElementium = new ItemPikeSWA("pike_elementium", materialElementium);
			pikeThaumium = SpartanWeaponryAPI.createPike(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			pikeVoidmetal = SpartanWeaponryAPI.createPike(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			pikeDawnstone = new ItemPikeSWA("pike_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(pikeManasteel, pikeTerrasteel, pikeElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(pikeThaumium, pikeVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(pikeDawnstone);
			}
		}
		if (!ConfigHandler.disableLance) {
			lanceManasteel = new ItemLanceSWA("lance_manasteel", materialManasteel);
			lanceTerrasteel = new ItemLanceSWA("lance_terrasteel", materialTerrasteel);
			lanceElementium = new ItemLanceSWA("lance_elementium", materialElementium);
			lanceThaumium = SpartanWeaponryAPI.createLance(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			lanceVoidmetal = SpartanWeaponryAPI.createLance(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			lanceDawnstone = new ItemLance("lance_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(lanceManasteel, lanceTerrasteel, lanceElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(lanceThaumium, lanceVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(lanceDawnstone);
			}
		}
		if (!ConfigHandler.disableLongbow && !ConfigHandler.woodenLongbowOnly) {
			longbowManasteel = new ItemLongbowSWA("longbow_manasteel", materialManasteel, new WeaponCallbackManaRegen(60.0f));
			longbowTerrasteel = new ItemLongbowSWA("longbow_terrasteel", materialTerrasteel, new WeaponCallbackManaRegen(100.0f));
			longbowElementium = new ItemLongbowSWA("longbow_elementium", materialElementium, new WeaponCallbackElementium(60.0f));
			longbowThaumium = SpartanWeaponryAPI.createLongbow(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA, null);
			longbowVoidmetal = SpartanWeaponryAPI.createLongbow(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA, new WeaponCallbackWarped());
			longbowDawnstone = new ItemLongbowSWA("longbow_dawnstone", materialDawnstone, new WeaponCallbackClockwork());
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(longbowManasteel, longbowTerrasteel, longbowElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(longbowThaumium, longbowVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(longbowDawnstone);
			}
		}
		if (!ConfigHandler.disableCrossbow && !ConfigHandler.woodenCrossbowOnly) {
			crossbowManasteel = new ItemCrossbowSWA("crossbow_manasteel", materialManasteel, new WeaponCallbackManaRegen(60.0f));
			crossbowTerrasteel = new ItemCrossbowSWA("crossbow_terrasteel", materialTerrasteel, new WeaponCallbackManaRegen(100.0f));
			crossbowElementium = new ItemCrossbowSWA("crossbow_elementium", materialElementium, new WeaponCallbackElementium(60.0f));
			crossbowThaumium = SpartanWeaponryAPI.createCrossbow(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA, null);
			crossbowVoidmetal = SpartanWeaponryAPI.createCrossbow(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA, new WeaponCallbackWarped());
			crossbowDawnstone = new ItemCrossbowSWA("crossbow_dawnstone", materialDawnstone, new WeaponCallbackClockwork());
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(crossbowManasteel, crossbowTerrasteel, crossbowElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(crossbowThaumium, crossbowVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(crossbowDawnstone);
			}
		}
		if (!ConfigHandler.disableThrowingKnife) {
			throwingKnifeManasteel = new ItemThrowingKnifeSWA("throwing_knife_manasteel", materialManasteel);
			throwingKnifeTerrasteel = new ItemThrowingKnifeSWA("throwing_knife_terrasteel", materialTerrasteel);
			throwingKnifeElementium = new ItemThrowingKnifeSWA("throwing_knife_elementium", materialElementium);
			throwingKnifeThaumium = SpartanWeaponryAPI.createThrowingKnife(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			throwingKnifeVoidmetal = SpartanWeaponryAPI.createThrowingKnife(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			throwingKnifeDawnstone = new ItemThrowingKnifeSWA("throwing_knife_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(throwingKnifeManasteel, throwingKnifeTerrasteel, throwingKnifeElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(throwingKnifeThaumium, throwingKnifeVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(throwingKnifeDawnstone);
			}
		}
		if (!ConfigHandler.disableThrowingAxe) {
			throwingAxeManasteel = new ItemThrowingAxeSWA("throwing_axe_manasteel", materialManasteel);
			throwingAxeTerrasteel = new ItemThrowingAxeSWA("throwing_axe_terrasteel", materialTerrasteel);
			throwingAxeElementium = new ItemThrowingAxeSWA("throwing_axe_elementium", materialElementium);
			throwingAxeThaumium = SpartanWeaponryAPI.createThrowingAxe(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			throwingAxeVoidmetal = SpartanWeaponryAPI.createThrowingAxe(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			throwingAxeDawnstone = new ItemThrowingAxeSWA("throwing_axe_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(throwingAxeManasteel, throwingAxeTerrasteel, throwingAxeElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(throwingAxeThaumium, throwingAxeVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(throwingAxeDawnstone);
			}
		}
		if (!ConfigHandler.disableJavelin) {
			javelinManasteel = new ItemJavelinSWA("javelin_manasteel", materialManasteel);
			javelinTerrasteel = new ItemJavelinSWA("javelin_terrasteel", materialTerrasteel);
			javelinElementium = new ItemJavelinSWA("javelin_elementium", materialElementium);
			javelinThaumium = SpartanWeaponryAPI.createJavelin(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			javelinVoidmetal = SpartanWeaponryAPI.createJavelin(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			javelinDawnstone = new ItemJavelinSWA("javelin_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(javelinManasteel, javelinTerrasteel, javelinElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(javelinThaumium, javelinVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(javelinDawnstone);
			}
		}
		if (!ConfigHandler.disableBoomerang && !ConfigHandler.woodenBoomerangOnly) {
			boomerangManasteel = new ItemBoomerangSWA("boomerang_manasteel", materialManasteel);
			boomerangTerrasteel = new ItemBoomerangSWA("boomerang_terrasteel", materialTerrasteel);
			boomerangElementium = new ItemBoomerangSWA("boomerang_elementium", materialElementium);
			boomerangThaumium = SpartanWeaponryAPI.createBoomerang(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			boomerangVoidmetal = SpartanWeaponryAPI.createBoomerang(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			boomerangDawnstone = new ItemBoomerangSWA("boomerang_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(boomerangManasteel, boomerangTerrasteel, boomerangElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(boomerangThaumium, boomerangVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(boomerangDawnstone);
			}
		}
		if (!ConfigHandler.disableBattleaxe) {
			battleaxeManasteel = new ItemBattleaxeSWA("battleaxe_manasteel", materialManasteel);
			battleaxeTerrasteel = new ItemBattleaxeSWA("battleaxe_terrasteel", materialTerrasteel);
			battleaxeElementium = new ItemBattleaxeSWA("battleaxe_elementium", materialElementium);
			battleaxeThaumium = SpartanWeaponryAPI.createBattleaxe(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			battleaxeVoidmetal = SpartanWeaponryAPI.createBattleaxe(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			battleaxeDawnstone = new ItemBattleaxeSWA("battleaxe_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(battleaxeManasteel, battleaxeTerrasteel, battleaxeElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(battleaxeThaumium, battleaxeVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(battleaxeDawnstone);
			}
		}
		if (!ConfigHandler.disableMace) {
			maceManasteel = new ItemMaceSWA("mace_manasteel", materialManasteel);
			maceTerrasteel = new ItemMaceSWA("mace_terrasteel", materialTerrasteel);
			maceElementium = new ItemMaceSWA("mace_elementium", materialElementium);
			maceThaumium = SpartanWeaponryAPI.createMace(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			maceVoidmetal = SpartanWeaponryAPI.createMace(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			maceDawnstone = new ItemMaceSWA("mace_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(maceManasteel, maceTerrasteel, maceElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(maceThaumium, maceVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(maceDawnstone);
			}
		}
		if (!ConfigHandler.disableGlaive) {
			glaiveManasteel = new ItemGlaiveSWA("glaive_manasteel", materialManasteel);
			glaiveTerrasteel = new ItemGlaiveSWA("glaive_terrasteel", materialTerrasteel);
			glaiveElementium = new ItemGlaiveSWA("glaive_elementium", materialElementium);
			glaiveThaumium = SpartanWeaponryAPI.createGlaive(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			glaiveVoidmetal = SpartanWeaponryAPI.createGlaive(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			glaiveDawnstone = new ItemGlaiveSWA("glaive_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(glaiveManasteel, glaiveTerrasteel, glaiveElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(glaiveThaumium, glaiveVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(glaiveDawnstone);
			}
		}
		if (!ConfigHandler.disableQuarterstaff) {
			staffManasteel = new ItemQuarterstaffSWA("staff_manasteel", materialManasteel);
			staffTerrasteel = new ItemQuarterstaffSWA("staff_terrasteel", materialTerrasteel);
			staffElementium = new ItemQuarterstaffSWA("staff_elementium", materialElementium);
			staffThaumium = SpartanWeaponryAPI.createQuarterstaff(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			staffVoidmetal = SpartanWeaponryAPI.createQuarterstaff(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			staffDawnstone = new ItemQuarterstaffSWA("staff_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(staffManasteel, staffTerrasteel, staffElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(staffThaumium, staffVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(staffDawnstone);
			}
		}
		if (!ConfigHandler.disableParryingDagger) {
			parryManasteel = new ItemParryingDaggerSWA("parrying_dagger_manasteel", materialManasteel);
			parryTerrasteel = new ItemParryingDaggerSWA("parrying_dagger_terrasteel", materialTerrasteel);
			parryElementium = new ItemParryingDaggerSWA("parrying_dagger_elementium", materialElementium);
			parryThaumium = SpartanWeaponryAPI.createParryingDagger(materialThaumium, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			parryVoidmetal = SpartanWeaponryAPI.createParryingDagger(materialVoidmetal, SpartanWeaponryArcana.MOD_ID, CreativeTabsSWA.TAB_SWA);
			parryDawnstone = new ItemParryingDaggerSWA("parrying_dagger_dawnstone", materialDawnstone);
			if (ModHelper.isBotaniaLoaded()) {
				addWeaponsToRegister(parryManasteel, parryTerrasteel, parryElementium);
			}
			if (ModHelper.isThaumcraftLoaded()) {
				addWeaponsToRegister(parryThaumium, parryVoidmetal);
			}
			if (ModHelper.isEmbersLoaded()) {
				addWeaponsToRegister(parryDawnstone);
			}
		}
		for(Item weapon : weapons) {
			registry.register(weapon);
			SpartanWeaponryAPI.addItemModelToRegistry(weapon);
		}
		LogHelper.info("Items Registered!");

	}
	
	protected static void addWeaponsToRegister(Item... weaponsToAdd) {
		for(Item weapon : weaponsToAdd) {
			if(weapon != null)
				weapons.add(weapon);
		}
	}

}
