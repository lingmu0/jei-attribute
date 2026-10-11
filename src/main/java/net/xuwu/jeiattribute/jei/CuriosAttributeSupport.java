package net.xuwu.jeiattribute.jei;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosSlotTypes;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.Set;
import java.util.TreeSet;

final class CuriosAttributeSupport {
    private CuriosAttributeSupport() {
    }

    static Set<Identifier> getAttributeIds(ItemStack stack) {
        Set<Identifier> result = new TreeSet<>();
        var slotTypes = CuriosSlotTypes.getItemSlotTypes(stack, true).values();
        if (slotTypes.isEmpty()) {
            return result;
        }
        var modifiers = ICurioItem.getAttributeModifiers(stack);
        for (var slotType : slotTypes) {
            modifiers.forEach(slotType, (attribute, modifier) -> addId(result, attribute));
        }
        return result;
    }

    private static void addId(Set<Identifier> result, Holder<Attribute> attribute) {
        Identifier id = BuiltInRegistries.ATTRIBUTE.getKey(attribute.value());
        if (id != null) {
            result.add(id);
        }
    }
}
