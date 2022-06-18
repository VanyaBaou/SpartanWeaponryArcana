package com.vanyabaou.spartanweaponryarcana.weaponproperty;

import java.util.List;

import com.oblivioussp.spartanweaponry.api.IWeaponCallback;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.vanyabaou.spartanweaponryarcana.SpartanWeaponryArcana;
import com.vanyabaou.spartanweaponryarcana.util.ModHelper;
import com.vanyabaou.spartanweaponryarcana.util.StringHelper;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import vazkii.botania.api.mana.ManaItemHandler;

public class WeaponCallbackElementium implements IWeaponCallback {
	protected float manaCost;
	
	public WeaponCallbackElementium(float manaCostPerDurability)
	{
		manaCost = manaCostPerDurability;
	}

	@Override
	public void onTooltip(ToolMaterialEx material, ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		tooltip.add(TextFormatting.DARK_AQUA + StringHelper.translateString("mana_regenerate", "tooltip", SpartanWeaponryArcana.MOD_ID));
		if (GuiScreen.isShiftKeyDown()) {
			tooltip.add(TextFormatting.ITALIC + " " + StringHelper.translateString("mana_regenerate.desc", "tooltip", SpartanWeaponryArcana.MOD_ID));
		}
		tooltip.add(TextFormatting.LIGHT_PURPLE + StringHelper.translateString("pixielated", "tooltip", SpartanWeaponryArcana.MOD_ID));
		if (GuiScreen.isShiftKeyDown()) {
			tooltip.add(TextFormatting.ITALIC + " " + StringHelper.translateFormattedString("pixielated.desc", "tooltip", SpartanWeaponryArcana.MOD_ID, WeaponPropertySWA.Pixielated5P.getMagnitude()));
		}
	}

	@Override
	public void onItemUpdate(ToolMaterialEx material, ItemStack stack, World world, EntityLivingBase entity, int itemSlot, boolean isSelected) {
		if (!world.isRemote && ModHelper.isBotaniaLoaded() && stack.isItemDamaged() && entity instanceof EntityPlayer && requestManaForRepair(stack, (EntityPlayer)entity, MathHelper.floor(manaCost * 2))) {
			stack.setItemDamage(stack.getItem().getDamage(stack) - 1);
		}
	}
	
	@Optional.Method(modid = ModHelper.MOD_ID_BOTANIA)
	protected boolean requestManaForRepair(ItemStack stack, EntityPlayer player, int manaRequested) {
		return ManaItemHandler.requestManaExactForTool(stack, player, manaRequested, true);
	}
}
