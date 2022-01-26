package com.vanyabaou.spartanweaponryarcana.weaponproperty;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponPropertyWithCallback;
import com.oblivioussp.spartanweaponry.entity.projectile.EntityBoomerang;
import com.oblivioussp.spartanweaponry.entity.projectile.EntityThrownWeapon;
import com.oblivioussp.spartanweaponry.item.ItemBoomerang;
import com.oblivioussp.spartanweaponry.item.ItemCrossbow;
import com.oblivioussp.spartanweaponry.item.ItemLongbow;
import com.oblivioussp.spartanweaponry.item.ItemThrowingWeapon;
import com.oblivioussp.spartanweaponry.util.NBTHelper;
import com.vanyabaou.spartanweaponryarcana.SpartanWeaponryArcana;
import com.vanyabaou.spartanweaponryarcana.util.EventHandler;
import com.vanyabaou.spartanweaponryarcana.util.StringHelper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import teamroots.embers.network.PacketHandler;
import teamroots.embers.network.message.MessageEmberBurstFX;
import teamroots.embers.util.EmberInventoryUtil;

import java.util.List;

public class WeaponPropertyClockwork extends WeaponPropertyWithCallback {

    public WeaponPropertyClockwork(String propType, String propModId) {
        super(propType, propModId);
    }

    @Override
    protected void addTooltipDescription(ItemStack stack, List<String> tooltip)
    {
        tooltip.add(TextFormatting.GOLD + StringHelper.translateFormattedString("clockwork", "tooltip", SpartanWeaponryArcana.MOD_ID));
        if(GuiScreen.isShiftKeyDown())
        {
            tooltip.add(TextFormatting.ITALIC + " " + StringHelper.translateString("clockwork.desc", "tooltip", SpartanWeaponryArcana.MOD_ID));
        }
    }

    @Override
    public float modifyDamageDealt(ToolMaterialEx material, float baseDamage, DamageSource source, EntityLivingBase attacker, EntityLivingBase victim) {
        ItemStack heldItem = attacker.getHeldItemMainhand();
        if (attacker instanceof EntityPlayer){
            if (EmberInventoryUtil.getEmberTotal((EntityPlayer)attacker) < 5.0D) {
//                LogHelper.info("No embers for " + attacker.getName());
                return 0;
            }
        }else{
            return super.modifyDamageDealt(material, baseDamage, source, attacker, victim);
        }
        EntityPlayer player = (EntityPlayer)attacker;
        if (heldItem.hasTagCompound() && !source.isProjectile() && !(heldItem.getItem() instanceof ItemBoomerang)){
            if (heldItem.getItem() instanceof ItemThrowingWeapon){
                if (NBTHelper.getInteger(heldItem,"AmmoUsed") == ((ItemThrowingWeapon) heldItem.getItem()).getMaxAmmo(heldItem)){
//                    LogHelper.info("No ammo for " + heldItem.getDisplayName());
                    return 0;
                }
            }
//            LogHelper.info("Using embers from " + heldItem.getDisplayName());
            victim.setFire(1);
            if (!victim.getEntityWorld().isRemote) {
                PacketHandler.INSTANCE.sendToAll(new MessageEmberBurstFX(victim.posX, victim.posY + (double)victim.getEyeHeight() / 1.5D, victim.posZ));
                NBTHelper.setBoolean(heldItem,"didUse", true);
            }

        }
        if (source.isProjectile() && source.getImmediateSource() instanceof EntityThrownWeapon){
//            LogHelper.info("Using embers from ThrownWeapon " + source.getImmediateSource().getDisplayName());
            victim.setFire(1);
            if (!(source.getImmediateSource() instanceof EntityBoomerang)){
                EmberInventoryUtil.removeEmber(player, 5.0D);
            }
            if (!victim.getEntityWorld().isRemote) {
                PacketHandler.INSTANCE.sendToAll(new MessageEmberBurstFX(victim.posX, victim.posY + (double)victim.getEyeHeight() / 1.5D, victim.posZ));
            }
        }
//        LogHelper.info("Defaulting damage for " + heldItem.getDisplayName());
        return super.modifyDamageDealt(material, baseDamage, source, attacker, victim);
    }

    @Override
    public void onCreateItem(ToolMaterialEx material, ItemStack stack) {
        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }
        NBTHelper.setBoolean(stack, "poweredOn", false);
        NBTHelper.setBoolean(stack, "didUse", false);
    }

    @Override
    public void onItemUpdate(ToolMaterialEx material, ItemStack stack, World world, EntityLivingBase entity, int itemSlot, boolean isSelected)
    {
        if (stack.hasTagCompound()){
            if (entity instanceof EntityPlayer) {
                if (EventHandler.getTickCounter2() == 0) {
                    if (EmberInventoryUtil.getEmberTotal((EntityPlayer)entity) > 5.0D) {
                        NBTHelper.setBoolean(stack,"poweredOn", true);
                    } else {
                        NBTHelper.setBoolean(stack,"poweredOn", false);
                    }
                }
                if (NBTHelper.getBoolean(stack,"didUse")) {
                    NBTHelper.setBoolean(stack,"didUse", false);
                    if (stack.getItem() instanceof ItemBoomerang ||
                            stack.getItem() instanceof ItemCrossbow ||
                            stack.getItem() instanceof ItemLongbow){
                    }else{
//                        LogHelper.info("spending 5 ember");
                        EmberInventoryUtil.removeEmber((EntityPlayer)entity, 5.0D);
                    }
                    if (EmberInventoryUtil.getEmberTotal((EntityPlayer)entity) < 5.0D) {
                        NBTHelper.setBoolean(stack,"poweredOn", false);
                    }
                }
            }
        }
    }

}
