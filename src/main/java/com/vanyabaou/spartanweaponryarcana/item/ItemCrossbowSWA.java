package com.vanyabaou.spartanweaponryarcana.item;

import com.oblivioussp.spartanweaponry.api.IWeaponCallback;
import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.item.ItemCrossbow;
import com.oblivioussp.spartanweaponry.util.NBTHelper;
import com.vanyabaou.spartanweaponryarcana.SpartanWeaponryArcana;
import com.vanyabaou.spartanweaponryarcana.client.gui.CreativeTabsSWA;
import com.vanyabaou.spartanweaponryarcana.util.ModHelper;
import com.vanyabaou.spartanweaponryarcana.weaponproperty.WeaponPropertySWA;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import teamroots.embers.util.EmberInventoryUtil;
import vazkii.botania.api.item.IPixieSpawner;
import vazkii.botania.api.mana.IManaUsingItem;

@Optional.Interface(iface="vazkii.botania.api.mana.IManaUsingItem", modid=ModHelper.MOD_ID_BOTANIA)
@Optional.Interface(iface="vazkii.botania.api.item.IPixieSpawner", modid=ModHelper.MOD_ID_BOTANIA)
public class ItemCrossbowSWA extends ItemCrossbow implements IManaUsingItem, IPixieSpawner {
	protected boolean usesMana;
	protected boolean usesEmbers = false;
	float pixieChance = 0.0f;
	
	public ItemCrossbowSWA(String unlocName, ToolMaterialEx material, IWeaponCallback weaponCallback) {
		super(unlocName, SpartanWeaponryArcana.MOD_ID, material);
		this.setCreativeTab(CreativeTabsSWA.TAB_SWA);
		
		usesMana = this.material.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_MANA_REGENERATE) != null;
		WeaponProperty prop = this.material.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_PIXIELATED);
		if (prop != null)
			pixieChance = prop.getMagnitude() / 100.0f;
		else {
			prop = this.material.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_PIXIELATED);
			if (prop != null)
				pixieChance = prop.getMagnitude() / 100.0f;
		}

		WeaponProperty prop2 = this.material.getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_CLOCKWORK);
		if (prop2 != null) {
			System.out.println(unlocName + " uses Embers");
			usesEmbers = true;
		}

		this.callback = weaponCallback;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		if (usesEmbers) {
			if (hasEmber(stack)) {
				return !NBTHelper.getBoolean(stack, "isLoaded") ? EnumAction.NONE : EnumAction.BOW;
			} else {
				return EnumAction.NONE;
			}
		} else {
			return !NBTHelper.getBoolean(stack, "isLoaded") ? EnumAction.NONE : EnumAction.BOW;
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		ItemStack stack = playerIn.getHeldItem(hand);
		boolean flag;
		flag = !this.findAmmo(playerIn).isEmpty();
		if (!playerIn.capabilities.isCreativeMode && !NBTHelper.getBoolean(stack, "isLoaded") && !flag && EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) <= 0) {
			return !flag ? new ActionResult(EnumActionResult.FAIL, stack) : new ActionResult(EnumActionResult.PASS, stack);
		} else {
			if (usesEmbers) {
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
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer)entityLiving;
			if (usesEmbers) {
				//check crossbow is shootable
				boolean flag = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
				ItemStack itemstack = ItemStack.EMPTY;
				NBTTagCompound tag = NBTHelper.getTagCompound(stack, "ammoStack");
				if (tag != null)
					itemstack = new ItemStack(tag);
				int i = this.getMaxItemUseDuration(stack) - timeLeft;
				if (i < 0 || !NBTHelper.getBoolean(stack, "isLoaded"))
					return;
				if (!itemstack.isEmpty() || flag) {
					if (EmberInventoryUtil.getEmberTotal((EntityPlayer) entityLiving) >= 5) {
						EmberInventoryUtil.removeEmber((EntityPlayer) entityLiving, 5);
						NBTHelper.setBoolean(stack,"didUse",true);
						super.onPlayerStoppedUsing(stack, worldIn, entityLiving, timeLeft);
					}
				}
			} else {
				super.onPlayerStoppedUsing(stack, worldIn, entityLiving, timeLeft);
			}
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

	public boolean usesEmbers() { return usesEmbers; }

	public boolean hasEmber(ItemStack stack) { return stack.hasTagCompound() && stack.getTagCompound().getBoolean("poweredOn"); }

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		if (usesEmbers) {
			if (oldStack.hasTagCompound() && newStack.hasTagCompound()) {
				return NBTHelper.getBoolean(oldStack,"poweredOn") != NBTHelper.getBoolean(newStack,"poweredOn");
			} else {
				return false;
			}
		} else {
			return super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged);
		}
	}

}
