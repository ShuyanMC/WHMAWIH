package net.shuyanmc.WHMAWI;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("who_hurt_me_and_who_i_hurt")
public class MOD {
    public static final Logger LOGGER = LogManager.getLogger();

    public MOD() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("WHMAWIH模组加载完成!");
        //谁懂一直打这名字的痛苦！
    }
}