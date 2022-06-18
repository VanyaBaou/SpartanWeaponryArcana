package com.vanyabaou.spartanweaponryarcana.weaponproperty;

import com.oblivioussp.spartanweaponry.api.IWeaponCallback;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.util.NBTHelper;
import com.vanyabaou.spartanweaponryarcana.SpartanWeaponryArcana;
import com.vanyabaou.spartanweaponryarcana.util.EventHandler;
import com.vanyabaou.spartanweaponryarcana.util.StringHelper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import teamroots.embers.util.EmberInventoryUtil;

import java.util.List;

public class WeaponCallbackClockwork implements IWeaponCallback {

	@Override
	public void onTooltip(ToolMaterialEx material, ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		tooltip.add(TextFormatting.GOLD + StringHelper.translateString("clockwork", "tooltip", SpartanWeaponryArcana.MOD_ID));
		if (GuiScreen.isShiftKeyDown()) {
			tooltip.add(TextFormatting.ITALIC + " " + StringHelper.translateString("clockwork.desc", "tooltip", SpartanWeaponryArcana.MOD_ID));
		}
	}
	
	@Override
	public void onCreateItem(ToolMaterialEx material, ItemStack stack) {
		if (stack.getTagCompound() == null) {
			stack.setTagCompound(new NBTTagCompound());
		}
	}

	@Override
	public void onItemUpdate(ToolMaterialEx material, ItemStack stack, World world, EntityLivingBase entity, int itemSlot, boolean isSelected) {
		if (stack.hasTagCompound()){
			if (entity instanceof EntityPlayer) {
				if (EventHandler.getTickCounter2() == 0) {
					if (EmberInventoryUtil.getEmberTotal((EntityPlayer)entity) > 5.0D) {
						NBTHelper.setBoolean(stack,"poweredOn", true);
					} else {
						NBTHelper.setBoolean(stack,"poweredOn", false);
					}
				}
				if (NBTHelper.getBoolean(stack,"didUse")) {
					NBTHelper.setBoolean(stack,"didUse", false);
					if (EmberInventoryUtil.getEmberTotal((EntityPlayer)entity) < 5.0D) {
						NBTHelper.setBoolean(stack,"poweredOn", false);
					}
				}
			}
		}
	}
}
