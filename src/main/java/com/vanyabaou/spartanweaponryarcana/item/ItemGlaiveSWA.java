package com.vanyabaou.spartanweaponryarcana.item;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.item.ItemGlaive;
import com.vanyabaou.spartanweaponryarcana.SpartanWeaponryArcana;
import com.vanyabaou.spartanweaponryarcana.client.gui.CreativeTabsSWA;
import com.vanyabaou.spartanweaponryarcana.util.ManaBurstHelper;
import com.vanyabaou.spartanweaponryarcana.util.ModHelper;
import com.vanyabaou.spartanweaponryarcana.weaponproperty.WeaponPropertySWA;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.Optional;
import vazkii.botania.api.internal.IManaBurst;
import vazkii.botania.api.item.IPixieSpawner;
import vazkii.botania.api.mana.BurstProperties;
import vazkii.botania.api.mana.ILensEffect;
import vazkii.botania.api.mana.IManaUsingItem;

@Optional.Interface(iface="vazkii.botania.api.mana.IManaUsingItem", modid=ModHelper.MOD_ID_BOTANIA)
@Optional.Interface(iface="vazkii.botania.api.item.IPixieSpawner", modid=ModHelper.MOD_ID_BOTANIA)
@Optional.Interface(iface="vazkii.botania.api.mana.ILensEffect", modid=ModHelper.MOD_ID_BOTANIA)
public class ItemGlaiveSWA extends ItemGlaive implements IManaUsingItem, IPixieSpawner, ILensEffect {
	protected boolean usesMana = false;
	float pixieChance = 0.0f;

	public ItemGlaiveSWA(String unlocName, ToolMaterialEx material) {
		super(unlocName, SpartanWeaponryArcana.MOD_ID, material);
		this.setCreativeTab(CreativeTabsSWA.TAB_SWA);

		usesMana = this.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_MANA_REGENERATE) != null ? true : this.materialEx.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_MANA_REGENERATE) != null;
		WeaponProperty prop = this.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_PIXIELATED);
		if (prop != null)
			pixieChance = prop.getMagnitude() / 100.0f;
		else {
			prop = this.materialEx.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_PIXIELATED);
			if (prop != null)
				pixieChance = prop.getMagnitude() / 100.0f;
		}
	}

	@Override
	public float getPixieChance(ItemStack stack)
	{
		return pixieChance;
	}

	@Override
	public boolean usesMana(ItemStack stack) 
	{
		return usesMana;
	}

	@Override
	public void apply(ItemStack stack, BurstProperties props) {}

	@Override
	public boolean collideBurst(IManaBurst burst, RayTraceResult pos, boolean isManaBlock, boolean dead, ItemStack stack) { return dead; }

	@Override
	public void updateBurst(IManaBurst burst, ItemStack stack) {
		ManaBurstHelper.updateBurst(burst, stack, this.getDirectAttackDamage() + 1.0f);
	}

	@Override
	public boolean doParticles(IManaBurst burst, ItemStack stack) 
	{
		return true;
	}
}
