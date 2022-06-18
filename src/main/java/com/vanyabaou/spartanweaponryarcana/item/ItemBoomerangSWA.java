package com.vanyabaou.spartanweaponryarcana.item;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.item.ItemBoomerang;
import com.oblivioussp.spartanweaponry.util.NBTHelper;
import com.vanyabaou.spartanweaponryarcana.SpartanWeaponryArcana;
import com.vanyabaou.spartanweaponryarcana.client.gui.CreativeTabsSWA;
import com.vanyabaou.spartanweaponryarcana.util.ModHelper;
import com.vanyabaou.spartanweaponryarcana.weaponproperty.WeaponPropertySWA;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import teamroots.embers.RegistryManager;
import teamroots.embers.api.item.IEmberChargedTool;
import teamroots.embers.util.EmberInventoryUtil;
import vazkii.botania.api.item.IPixieSpawner;
import vazkii.botania.api.mana.IManaUsingItem;

@Optional.Interface(iface="vazkii.botania.api.mana.IManaUsingItem", modid=ModHelper.MOD_ID_BOTANIA)
@Optional.Interface(iface="vazkii.botania.api.item.IPixieSpawner", modid=ModHelper.MOD_ID_BOTANIA)
public class ItemBoomerangSWA extends ItemBoomerang implements IManaUsingItem, IPixieSpawner {
	protected boolean usesMana = false;
	protected boolean usesEmbers = false;
	float pixieChance = 0.0f;

	public ItemBoomerangSWA(String unlocName, ToolMaterialEx material) {
		super(unlocName, SpartanWeaponryArcana.MOD_ID, material);
		this.setCreativeTab(CreativeTabsSWA.TAB_SWA);
		
		usesMana = this.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_MANA_REGENERATE) != null ? true : this.materialEx.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_MANA_REGENERATE) != null;
		WeaponProperty prop = this.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_PIXIELATED);
		if (prop != null)
			pixieChance = prop.getMagnitude() / 100.0f;
		else {
			prop = this.materialEx.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_PIXIELATED);
			if(prop != null)
				pixieChance = prop.getMagnitude() / 100.0f;
		}

		WeaponProperty prop2 = this.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_CLOCKWORK);
		if (prop2 != null)
			usesEmbers = true;
		else {
			prop2 = this.materialEx.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_CLOCKWORK);
			if(prop2 != null)
				usesEmbers = true;
		}
		if (usesEmbers) {
			this.setMaxDamage(100);
		}
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		if (this.usesEmbers && stack.getItemDamage() > 0 && NBTHelper.getInteger(stack,"AmmoUsed") != this.getMaxAmmo(stack)){
			stack.setItemDamage(0);
		}
		super.onUpdate(stack, world, entity, itemSlot, isSelected);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		if (usesEmbers){
			if (hasEmber(stack)){
				return EnumAction.BOW;
			}else{
				return EnumAction.NONE;
			}
		}else{
			return EnumAction.BOW;
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		if (stack.hasTagCompound() && NBTHelper.getInteger(stack,"AmmoUsed") == this.getMaxAmmo(stack)) {
			return new ActionResult(EnumActionResult.FAIL, stack);
		} else {
			if (usesEmbers){
				if (EmberInventoryUtil.getEmberTotal(playerIn) < 5){
					return new ActionResult(EnumActionResult.FAIL, stack);
				}
			}
			playerIn.setActiveHand(hand);
			return new ActionResult(EnumActionResult.SUCCESS, stack);
		}
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		if (usesEmbers){
			if (EmberInventoryUtil.getEmberTotal((EntityPlayer) entityLiving) >= 5){
				EmberInventoryUtil.removeEmber((EntityPlayer) entityLiving,5);
				NBTHelper.setBoolean(stack,"didUse", true);
				super.onPlayerStoppedUsing(stack, worldIn, entityLiving, timeLeft);
			}
		}else{
			super.onPlayerStoppedUsing(stack, worldIn, entityLiving, timeLeft);
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

	public boolean hasEmber(ItemStack stack) {return stack.hasTagCompound() ? NBTHelper.getBoolean(stack,"poweredOn") : false;}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		if (usesEmbers){
			if (oldStack.hasTagCompound() && newStack.hasTagCompound()) {
				return NBTHelper.getBoolean(oldStack,"poweredOn") != NBTHelper.getBoolean(newStack,"poweredOn");
			} else {
				return false;
			}
		}else{
			return super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged);
		}
	}


}
