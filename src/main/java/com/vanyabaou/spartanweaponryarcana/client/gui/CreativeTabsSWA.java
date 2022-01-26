package com.vanyabaou.spartanweaponryarcana.client.gui;

import com.vanyabaou.spartanweaponryarcana.SpartanWeaponryArcana;
import com.vanyabaou.spartanweaponryarcana.util.ModHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsSWA 
{


	public static final CreativeTabs TAB_SWA = new CreativeTabs(SpartanWeaponryArcana.MOD_ID + ":tabBasic.name") {

		@Override
		public ItemStack getTabIconItem() {
			return ModHelper.getTerrasteelStack();
		}
	};

}
