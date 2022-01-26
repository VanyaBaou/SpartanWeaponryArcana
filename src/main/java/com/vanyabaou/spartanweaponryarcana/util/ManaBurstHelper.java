package com.vanyabaou.spartanweaponryarcana.util;

/**
 * The Following code contains code taken from the Botania mod by Vazkii.<br>
 * It is licensed as GNU GPL v3, a copyleft license, as dictated in the "Usage of Botania Code or Assets" clause of the Botania License.<br>
 * See here: https://botaniamod.net/license.php
 */

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.FMLCommonHandler;
import vazkii.botania.api.internal.IManaBurst;
import vazkii.botania.common.core.handler.ModSounds;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.entity.EntityManaBurst;
import vazkii.botania.common.item.equipment.tool.ToolCommons;

import java.util.List;
public class ManaBurstHelper 
{
	public static final String TAG_ATTACKER_USERNAME = "attackerUsername";
	public static final int MANA_PER_DAMAGE = 100;

	// The following code is taken from the Botania mod by Vazkii
	// From "ItemTerraSword.java", method "trySpawnBurst()"
	
	// Alteration: Removed the item checking on main hand because it is redundant.
	public static void trySpawnBurst(EntityPlayer player)
	{
		if(player.getCooledAttackStrength(0.0f) == 1)
		{
			EntityManaBurst burst = ManaBurstHelper.getBurst(player, player.getHeldItemMainhand());
			player.world.spawnEntity(burst);
			ToolCommons.damageItem(player.getHeldItemMainhand(), 1, player, ManaBurstHelper.MANA_PER_DAMAGE);
			player.world.playSound(null, player.posX, player.posY, player.posZ, ModSounds.terraBlade, SoundCategory.PLAYERS, 0.4F, 1.4F);
		}
	}

	// From "ItemTerraSword.java", method "updateBurst()"
	// ALTERATION: Added damage parameter to alter damage from a mana burst.
	public static void updateBurst(IManaBurst burst, ItemStack stack, float weaponDamage)
	{
		EntityThrowable entity = (EntityThrowable) burst;
		AxisAlignedBB axis = new AxisAlignedBB(entity.posX, entity.posY, entity.posZ, entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ).grow(1);
		List<EntityLivingBase> entities = entity.world.getEntitiesWithinAABB(EntityLivingBase.class, axis);
		String attacker = ItemNBTHelper.getString(burst.getSourceLens(), ManaBurstHelper.TAG_ATTACKER_USERNAME, "");

		for(EntityLivingBase living : entities) {
			if(living instanceof EntityPlayer && (living.getName().equals(attacker) || FMLCommonHandler.instance().getMinecraftServerInstance() != null && !FMLCommonHandler.instance().getMinecraftServerInstance().isPVPEnabled()))
				continue;

			if(living.hurtTime == 0) {
				int cost = ManaBurstHelper.MANA_PER_DAMAGE / 3;
				int mana = burst.getMana();
				if(mana >= cost) {
					burst.setMana(mana - cost);
					float damage = weaponDamage /*4F + BotaniaAPI.terrasteelToolMaterial.getAttackDamage()*/;
					if(!burst.isFake() && !entity.world.isRemote) {
						EntityPlayer player = living.world.getPlayerEntityByName(attacker);
						living.attackEntityFrom(player == null ? DamageSource.MAGIC : DamageSource.causePlayerDamage(player), damage);
						entity.setDead();
						break;
					}
				}
			}
		}
	}
	
	// The following code is taken from the Botania mod by Vazkii
	// From "ItemTerraSword.java", method "getBurst()"
	public static EntityManaBurst getBurst(EntityPlayer player, ItemStack stack)
	{
		EntityManaBurst burst = new EntityManaBurst(player, EnumHand.MAIN_HAND);

		float motionModifier = 7F;

		burst.setColor(0x20FF20);
		burst.setMana(ManaBurstHelper.MANA_PER_DAMAGE);
		burst.setStartingMana(ManaBurstHelper.MANA_PER_DAMAGE);
		burst.setMinManaLoss(40);
		burst.setManaLossPerTick(4F);
		burst.setGravity(0F);
		burst.setMotion(burst.motionX * motionModifier, burst.motionY * motionModifier, burst.motionZ * motionModifier);

		ItemStack lens = stack.copy();
		ItemNBTHelper.setString(lens, ManaBurstHelper.TAG_ATTACKER_USERNAME, player.getName());
		burst.setSourceLens(lens);
		return burst;
	}
}
