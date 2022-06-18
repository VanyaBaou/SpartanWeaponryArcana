package com.vanyabaou.spartanweaponryarcana.weaponproperty;

import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithMagnitude;
import com.vanyabaou.spartanweaponryarcana.SpartanWeaponryArcana;

public class WeaponPropertySWA {
	public static final String TYPE_MANA_REGENERATE = "mana_regenerate";
	public static final String TYPE_TERRA_SLASH = "terra_slash";
	public static final String TYPE_PIXIELATED = "pixielated";
	public static final String TYPE_WARPED = "warped";
	public static final String TYPE_CLOCKWORK = "clockwork";
	
	public static final WeaponProperty ManaRegenerate = new WeaponPropertyManaRegen(TYPE_MANA_REGENERATE, SpartanWeaponryArcana.MOD_ID, 60.0f);
	public static final WeaponProperty ManaRegenerateTerra = new WeaponPropertyManaRegen(TYPE_MANA_REGENERATE, SpartanWeaponryArcana.MOD_ID, 100.0f);
	public static final WeaponProperty TerraSlash = new WeaponProperty(TYPE_TERRA_SLASH, SpartanWeaponryArcana.MOD_ID);
	public static final WeaponProperty Pixielated5P = new WeaponPropertyWithMagnitude(TYPE_PIXIELATED, SpartanWeaponryArcana.MOD_ID, 5.0f);
	public static final WeaponProperty Warped = new WeaponPropertyWarped(TYPE_WARPED, SpartanWeaponryArcana.MOD_ID);
	public static final WeaponProperty Clockwork = new WeaponPropertyClockwork(TYPE_CLOCKWORK, SpartanWeaponryArcana.MOD_ID);
}
