package com.vanyabaou.spartanweaponryarcana.util;

import com.vanyabaou.spartanweaponryarcana.SpartanWeaponryArcana;
import net.minecraft.client.resources.I18n;

public class StringHelper
{
	public static String getItemUnlocalizedName(String locName)
	{
		return getItemUnlocalizedName(locName, SpartanWeaponryArcana.MOD_ID);
	}
	
	public static String getItemUnlocalizedName(String locName, String modId)
	{
		return String.format("item.%s:%s", modId.toLowerCase(), stripUnlocalizedName(locName));
	}
	
	public static String stripUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	public static String translateString(String unlocalizedStr, String type)
	{
		return translateString(unlocalizedStr, type, SpartanWeaponryArcana.MOD_ID);
	}

	public static String translateString(String unlocalizedStr, String type, String modIdStr)
	{
		String modId = modIdStr;
		if(modId == null || modId == "")
			modId = SpartanWeaponryArcana.MOD_ID;
		if (type == null || type == "")
			return I18n.format(modId.toLowerCase() + ":" + unlocalizedStr);
		return I18n.format(String.format("%s.%s:%s", type, modId.toLowerCase(),
				unlocalizedStr));
	}
	
	public static String translateFormattedString(String unlocalizedStr, String type, String modIdStr, Object... parameters)
	{
		String modId = modIdStr;
		if(modId == null || modId == "")
			modId = SpartanWeaponryArcana.MOD_ID;
		if (type == null || type == "")
			return I18n.format(modId.toLowerCase() + ":" + unlocalizedStr, parameters);
		return I18n.format(String.format("%s.%s:%s", type, modId.toLowerCase(),
				unlocalizedStr), parameters);
	}
}
