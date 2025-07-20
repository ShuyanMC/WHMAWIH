package net.shuyanmc.WHMAWI;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;

@Mod.EventBusSubscriber(modid = "who_hurt_me_and_who_i_hurt", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class ServerSetup {
    @SubscribeEvent
    public static void doServerStuff(final FMLDedicatedServerSetupEvent event) {

    }
}