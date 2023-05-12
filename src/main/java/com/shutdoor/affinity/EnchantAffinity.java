package com.shutdoor.affinity;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.shutdoor.affinity.Affinity.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class EnchantAffinity extends Enchantment {
    public EnchantAffinity() {
        super(Rarity.RARE, EnchantmentType.ARMOR_HEAD, new EquipmentSlotType[]{
                EquipmentSlotType.HEAD
        });
    }

    @Override
    public int getMinCost(int level) {
        return 20;
    }

    @Override
    public int getMaxLevel() {return 1;}

    @Override
    protected boolean checkCompatibility(Enchantment p_44690_) {
        return super.checkCompatibility(p_44690_) && !(p_44690_.getFullname(0).toString().toLowerCase().contains("affinity"));
    }

    @SubscribeEvent
    public static void breakSpeed(PlayerEvent.BreakSpeed e) {
         Entity p = e.getPlayer();

        if(EnchantmentHelper.getEnchantmentLevel(EnchantmentReg.AFFINITY.get(), (LivingEntity) p) > 0){
//        if(EnchantmentHelper.getEnchantmentLevel(EnchantmentReg.AFFINITY.get(),  ))

        if(!(p.isOnGround()) && !(p.isUnderWater())){
            float oldSpeed = e.getOriginalSpeed();

            e.setNewSpeed(oldSpeed * 5);
        }

        if(p.isUnderWater()){
            float oldSpeed = e.getOriginalSpeed();

            e.setNewSpeed(oldSpeed * 5);
        }
        }
    }
}
