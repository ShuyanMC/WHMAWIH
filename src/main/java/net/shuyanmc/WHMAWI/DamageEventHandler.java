package net.shuyanmc.WHMAWI;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "who_hurt_me_and_who_i_hurt", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DamageEventHandler {

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        LivingEntity victim = event.getEntity();
        DamageSource source = event.getSource();

        if (source.getEntity() instanceof LivingEntity) {
            LivingEntity attacker = (LivingEntity) source.getEntity();
            Component message = getDamageMessage(attacker, victim);

            // 如果受害者是玩家，直接发送消息给玩家
            if (victim instanceof Player) {
                victim.sendSystemMessage(message);
            }
            // 否则，向所有玩家广播消息
            else {
                for (Player player : victim.level().players()) {
                    player.sendSystemMessage(message);
                }
            }
        }
    }

    private static Component getDamageMessage(LivingEntity attacker, LivingEntity victim) {
        String attackerName = getEntityName(attacker);
        String victimName = getEntityName(victim);

        return Component.literal(attackerName + " 伤害了 " + victimName)
                .withStyle(victim instanceof Player ?
                        ChatFormatting.RED :
                        ChatFormatting.GRAY);
    }

    private static String getEntityName(LivingEntity entity) {
        if (entity instanceof Player) {
            return "玩家" + entity.getName().getString();
        }
        return entity.getType().getDescription().getString();
    }
}