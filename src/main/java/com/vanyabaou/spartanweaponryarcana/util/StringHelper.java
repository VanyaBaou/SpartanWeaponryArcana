package com.vanyabaou.spartanweaponryarcana.util;

import com.vanyabaou.spartanweaponryarcana.SpartanWeaponryArcana;
import net.minecraft.util.text.TextComponentTranslation;

public class StringHelper {
	public static String getItemUnlocalizedName(String locName) {
		return getItemUnlocalizedName(locName, SpartanWeaponryArcana.MOD_ID);
	}
	
	public static String getItemUnlocalizedName(String locName, String modId) {
		return new TextComponentTranslation(String.format("item.%s:%s", modId.toLowerCase(), stripUnlocalizedName(locName))).getFormattedText();
	}
	
	public static String stripUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	public static String translateString(String unlocalizedStr, String type) {
		return translateString(unlocalizedStr, type, SpartanWeaponryArcana.MOD_ID);
	}

	public static String translateString(String unlocalizedStr, String type, String modIdStr) {
		String modId = modIdStr;
		if (modId == null || modId.equals(""))
			modId = SpartanWeaponryArcana.MOD_ID;
		if (type == null || type.equals(""))
			return new TextComponentTranslation(modId.toLowerCase() + ":" + unlocalizedStr).getFormattedText();
		return new TextComponentTranslation(String.format("%s.%s:%s", type, modId.toLowerCase(),
				unlocalizedStr)).getFormattedText();
	}
	
	public static String translateFormattedString(String unlocalizedStr, String type, String modIdStr, Object... parameters) {
		String modId = modIdStr;
		if (modId == null || modId.equals(""))
			modId = SpartanWeaponryArcana.MOD_ID;
		if (type == null || type.equals(""))
			return new TextComponentTranslation(String.format(modId.toLowerCase() + ":" + unlocalizedStr, parameters)).getFormattedText();
		return new TextComponentTranslation(String.format(String.format("%s.%s:%s", type, modId.toLowerCase(),
				unlocalizedStr), parameters)).getFormattedText();
	}
}
