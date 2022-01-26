package com.vanyabaou.spartanweaponryarcana.util;

import com.oblivioussp.spartanweaponry.api.IWeaponPropertyContainer;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.item.ItemThrowingWeapon;
import com.vanyabaou.spartanweaponryarcana.item.ItemCrossbowSWA;
import com.vanyabaou.spartanweaponryarcana.item.ItemLongbowSWA;
import com.vanyabaou.spartanweaponryarcana.network.NetworkHandler;
import com.vanyabaou.spartanweaponryarcana.network.PacketManaBurst;
import com.vanyabaou.spartanweaponryarcana.weaponproperty.WeaponPropertySWA;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import teamroots.embers.network.PacketHandler;
import teamroots.embers.network.message.MessageEmberBurstFX;

@Mod.EventBusSubscriber
public class EventHandler 
{
	protected static int tickCounter = 0;
	protected static int tickCounter2 = 0;
	
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent ev)
	{
		if(ev.side == Side.SERVER && ev.phase == Phase.END)
		{
			tickCounter++;
			tickCounter2++;
			if(tickCounter == 20)
			{
				tickCounter = 0;
			}
			if(tickCounter2 == 5)
			{
				tickCounter2 = 0;
			}
		}
	}

	public static int getTickCounter()
	{
		return tickCounter;
	}
	public static int getTickCounter2()
	{
		return tickCounter2;
	}
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void onAttackMiss(PlayerInteractEvent.LeftClickEmpty ev)
	{
		if(ev.getEntityPlayer() != null)
		{
			EntityPlayer player = ev.getEntityPlayer();
			if(!ev.getItemStack().isEmpty() && ev.getItemStack().getItem() instanceof IWeaponPropertyContainer && !(ev.getItemStack().getItem() instanceof ItemThrowingWeapon))
			{
				WeaponProperty prop = ((IWeaponPropertyContainer)ev.getItemStack().getItem()).getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_TERRA_SLASH);
				
				if(prop != null)
				{
					NetworkHandler.sendPacketToServer(new PacketManaBurst());
//					LogHelper.info("Sent Mana Burst Packet!");
				}
//				LogHelper.info(player.getCooledAttackStrength(0.0f));
//				if(prop != null && player.getCooledAttackStrength(0.0f) == 1.0f)
//				{
//					LogHelper.info("Terra Slash spawned! (SOON^TM)");
//				}
			}
		}
	}


	@SubscribeEvent
	public static void onLivingHurtEvent(LivingHurtEvent event) {
		DamageSource source = event.getSource();
		float damageDealt = event.getAmount();
		if (source.getDamageType().equals("arrow") && source.getTrueSource() instanceof EntityLivingBase){
			EntityLivingBase attacker = (EntityLivingBase) source.getTrueSource();
			EntityLivingBase victim = event.getEntityLiving();
			if (damageDealt > 0 && attacker != null && !attacker.getHeldItemMainhand().isEmpty()){
				ItemStack attackStack = attacker.getHeldItemMainhand();
				if (attackStack.getItem() instanceof ItemLongbowSWA || attackStack.getItem() instanceof ItemCrossbowSWA){
					boolean doEmberEffects = false;
					boolean isEmbersBow = false;
					if (attackStack.getItem() instanceof ItemLongbowSWA) {
						if (((ItemLongbowSWA) attackStack.getItem()).usesEmbers(attackStack)){
							isEmbersBow = true;
							if (((ItemLongbowSWA) attackStack.getItem()).hasEmber(attackStack)){
								doEmberEffects = true;
							}
						}
					}else if (attackStack.getItem() instanceof ItemCrossbowSWA){
						if (((ItemCrossbowSWA) attackStack.getItem()).usesEmbers(attackStack)){
							isEmbersBow = true;
							if (((ItemCrossbowSWA) attackStack.getItem()).hasEmber(attackStack)){
								doEmberEffects = true;
							}
						}
					}
					if (isEmbersBow){
						if (doEmberEffects){
							victim.setFire(1);
							if (!victim.getEntityWorld().isRemote) {
								PacketHandler.INSTANCE.sendToAll(new MessageEmberBurstFX(victim.posX, victim.posY + (double)victim.getEyeHeight() / 1.5D, victim.posZ));
							}
						}else{
							event.setCanceled(true);
						}
					}
				}
			}
		}
	}


}
