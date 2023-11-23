package net.aadi.mccourse.item;

import net.aadi.mccourse.MCCourseMod;
import net.aadi.mccourse.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.aadi.mccourse.block.ModBlocks.*;

public class ModItems {
    public static final Item ABYSSAL_INGOT = registerItem("abyssal_ingot",
            new Item(new FabricItemSettings()));
    public static final Item RAW_ABYSSAL_INGOT = registerItem("raw_abyssal_ingot",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MCCourseMod.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        entries.add(ABYSSAL_INGOT);
        entries.add(RAW_ABYSSAL_INGOT);

        entries.add(ModBlocks.ABYSSAL_BLOCK);
    }

    public static void registerModItems() {
        MCCourseMod.LOGGER.info("Registering Mod Items for " + MCCourseMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
