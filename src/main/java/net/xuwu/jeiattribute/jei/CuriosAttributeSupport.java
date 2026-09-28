package net.xuwu.jeiattribute.jei;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

final class CuriosAttributeSupport {
    private static final ResourceLocation VIEWER_ID = ResourceLocation.fromNamespaceAndPath("jei_attribute", "attribute_viewer");

    private CuriosAttributeSupport() {
    }

    @SuppressWarnings("removal")
    static Set<ResourceLocation> getAttributeIds(ItemStack stack) {
        Set<ResourceLocation> result = new TreeSet<>();
        Map<String, ?> slots = CuriosApi.getItemStackSlots(stack);
        for (String slotId : slots.keySet()) {
            SlotContext context = new SlotContext(slotId, null, -1, false, true);
            CuriosApi.getAttributeModifiers(context, VIEWER_ID, stack).keySet().forEach(holder -> addId(result, holder));
        }
        return result;
    }

    private static void addId(Set<ResourceLocation> result, Holder<Attribute> attribute) {
        ResourceLocation id = BuiltInRegistries.ATTRIBUTE.getKey(attribute.value());
        if (id != null) {
            result.add(id);
        }
    }
}
