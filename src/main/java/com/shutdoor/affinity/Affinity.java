package com.shutdoor.affinity;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;
import static com.shutdoor.affinity.Affinity.MODID;


@Mod(MODID)
public class Affinity
{
    public static final String MODID = "affinity";

    @ObjectHolder(MODID +":"+ MODID)
    public static final Enchantment affinity = null;

    public Affinity()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Enchantment.class, this::registerEnchantments);
    }

    @SubscribeEvent
    public void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().register(new EnchantAffinity().setRegistryName(MODID));
    }
}
