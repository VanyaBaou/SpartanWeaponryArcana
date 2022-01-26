package com.vanyabaou.spartanweaponryarcana.weaponproperty;

import java.util.List;

import com.oblivioussp.spartanweaponry.api.IWeaponCallback;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.vanyabaou.spartanweaponryarcana.SpartanWeaponryArcana;
import com.vanyabaou.spartanweaponryarcana.util.EventHandler;
import com.vanyabaou.spartanweaponryarcana.util.StringHelper;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class WeaponCallbackWarped implements IWeaponCallback {

	@Override
	public void onTooltip(ToolMaterialEx material, ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag)
	{
		tooltip.add(TextFormatting.DARK_PURPLE + StringHelper.translateString("warped", "tooltip", SpartanWeaponryArcana.MOD_ID));
		if(GuiScreen.isShiftKeyDown())
		{
			tooltip.add(TextFormatting.ITALIC + " " + StringHelper.translateString("warped.desc", "tooltip", SpartanWeaponryArcana.MOD_ID));
		}
	}
	
	@Override
	public void onCreateItem(ToolMaterialEx material, ItemStack stack)
	{
		if(!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		
		// Set this for Warping
		stack.getTagCompound().setByte("TC.WARP", (byte)1);
	}

	@Override
	public void onItemUpdate(ToolMaterialEx material, ItemStack stack, World world, EntityLivingBase entity,
			int itemSlot, boolean isSelected) 
	{
		if(EventHandler.getTickCounter() == 0)
		{
			if(stack.getItemDamage() >= 0)
				stack.setItemDamage(stack.getItemDamage() - 1);
		}
	}
}
