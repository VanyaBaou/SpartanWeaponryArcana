package com.vanyabaou.spartanweaponryarcana.weaponproperty;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.spartanweaponryarcana.util.EventHandler;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class WeaponPropertyWarped extends WeaponPropertyWithCallback {
	public WeaponPropertyWarped(String propType, String propModId) 
	{
		super(propType, propModId);
	}

	@Override
	public void onCreateItem(ToolMaterialEx material, ItemStack stack) {
		if (!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		// Set this for Warping
		stack.getTagCompound().setByte("TC.WARP", (byte)1);
	}

	@Override
	public void onItemUpdate(ToolMaterialEx material, ItemStack stack, World world, EntityLivingBase entity, int itemSlot, boolean isSelected) {
		super.onItemUpdate(material, stack, world, entity, itemSlot, isSelected);
		if (EventHandler.getTickCounter() == 0) {
			if (stack.getItemDamage() >= 0)
				stack.setItemDamage(stack.getItemDamage() - 1);
		}
	}
	
}
