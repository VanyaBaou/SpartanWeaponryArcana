package com.vanyabaou.spartanweaponryarcana;

import com.vanyabaou.spartanweaponryarcana.network.NetworkHandler;
import com.vanyabaou.spartanweaponryarcana.proxy.CommonProxy;
import com.vanyabaou.spartanweaponryarcana.util.LexiconEntries;
import com.vanyabaou.spartanweaponryarcana.util.LogHelper;
import com.vanyabaou.spartanweaponryarcana.util.ModHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(
        modid = SpartanWeaponryArcana.MOD_ID,
        name = SpartanWeaponryArcana.MOD_NAME,
        version = SpartanWeaponryArcana.VERSION,
        dependencies = SpartanWeaponryArcana.DEPENDENCIES,
        acceptedMinecraftVersions = SpartanWeaponryArcana.MCVERSION
)
public class SpartanWeaponryArcana {

    public static final String MOD_ID = "spartanweaponryarcana";
    public static final String MOD_NAME = "SpartanWeaponryArcana";
    public static final String VERSION = "1.4.1-1.1a";
    public static final String DEPENDENCIES = "required-after:spartanweaponry@[1.4.0,);after:baubles;after:botania;after:thaumcraft;after:embers";
    public static final String MCVERSION = "[1.12.2]";
    public static final String NETWORKCHANNEL = "swarcana";

    public static final String ProxyClientClass = "com.vanyabaou.spartanweaponryarcana.proxy.ClientProxy";
    public static final String ProxyServerClass = "com.vanyabaou.spartanweaponryarcana.proxy.CommonProxy";

    @Mod.Instance(MOD_ID)
    public static SpartanWeaponryArcana INSTANCE;

    @SidedProxy(clientSide = ProxyClientClass, serverSide = ProxyServerClass)
    public static CommonProxy proxy;



    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        LogHelper.info("Starting up Spartan Weaponry Arcana!");
        ModHelper.preInit();
        proxy.preInit(event);
        LogHelper.debug("Finished preInit phase!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        NetworkHandler.init();
        proxy.init(event);
        LogHelper.debug("Finished init phase!");
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        if (ModHelper.isBotaniaLoaded())
            LexiconEntries.postInit();
        proxy.postInit(event);
        LogHelper.debug("Finished postInit phase!");
    }
}
