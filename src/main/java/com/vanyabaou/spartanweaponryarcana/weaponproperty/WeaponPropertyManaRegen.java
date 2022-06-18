package com.vanyabaou.spartanweaponryarcana.weaponproperty;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.vanyabaou.spartanweaponryarcana.util.ModHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import vazkii.botania.api.mana.ManaItemHandler;

public class WeaponPropertyManaRegen extends WeaponPropertyWithCallback {
	public WeaponPropertyManaRegen(String propType, String propModId, float magnitude) {
		super(propType, propModId);
		this.magnitude = magnitude;
	}

	@Override
	public void onItemUpdate(ToolMaterialEx material, ItemStack stack, World world, EntityLivingBase entity, int itemSlot, boolean isSelected) {
		if (!world.isRemote && ModHelper.isBotaniaLoaded() && stack.isItemDamaged() && entity instanceof EntityPlayer && requestManaForRepair(stack, (EntityPlayer)entity, MathHelper.floor(this.magnitude * 2))) {
			stack.setItemDamage(stack.getItem().getDamage(stack) - 1);
		}
	}
	
	@Optional.Method(modid = ModHelper.MOD_ID_BOTANIA)
	protected boolean requestManaForRepair(ItemStack stack, EntityPlayer player, int manaRequested) {
		return ManaItemHandler.requestManaExactForTool(stack, player, manaRequested, true);
	}
}
