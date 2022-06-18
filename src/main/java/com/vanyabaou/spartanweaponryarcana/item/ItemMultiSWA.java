package com.vanyabaou.spartanweaponryarcana.item;

import com.vanyabaou.spartanweaponryarcana.util.StringHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class ItemMultiSWA extends ItemSWA {
	protected String[] unlocNames;
	
	public ItemMultiSWA(String registryName, String... unlocalizedNames) {
		super(registryName);
		this.unlocNames = unlocalizedNames;
		this.hasSubtypes = true;
	}
	
	public String[] getAllUnlocalizedNames()
	{
		return unlocNames;
	}

	/**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @SideOnly(Side.CLIENT)
    @Override @ParametersAreNonnullByDefault
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
    	if (tab == this.getCreativeTab()) {
	    	if (unlocNames == null) {
	    		super.getSubItems(tab, subItems);
	    		return;
	    	}
	    	for (int i = 0; i < unlocNames.length; i++) {
	    		subItems.add(new ItemStack(this, 1, i));
	    	}
    	}
    }
    
    @Override @Nonnull
    public String getItemStackDisplayName(ItemStack stack) {
    	if(stack.getItemDamage() >= unlocNames.length)
    		return super.getItemStackDisplayName(stack);
    	String unlocName = unlocNames[stack.getItemDamage()];
        return StringHelper.translateString(unlocName + ".name", "item");
    }
}
