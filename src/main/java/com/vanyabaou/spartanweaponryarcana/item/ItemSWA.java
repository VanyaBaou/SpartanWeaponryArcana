package com.vanyabaou.spartanweaponryarcana.item;

import com.vanyabaou.spartanweaponryarcana.client.gui.CreativeTabsSWA;
import com.vanyabaou.spartanweaponryarcana.util.StringHelper;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSWA extends Item
{
	
	public ItemSWA(String unlocName)
	{
		super();
		this.setCreativeTab(CreativeTabsSWA.TAB_SWA);
		this.setRegistryName(unlocName);
		this.setUnlocalizedName(unlocName);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return StringHelper.getItemUnlocalizedName(super.getUnlocalizedName());
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return StringHelper.getItemUnlocalizedName(super.getUnlocalizedName());
	}
}
