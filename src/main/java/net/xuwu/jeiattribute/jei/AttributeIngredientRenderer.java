package net.xuwu.jeiattribute.jei;

import mezz.jei.api.ingredients.IIngredientRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public final class AttributeIngredientRenderer implements IIngredientRenderer<AttributeIngredient> {
    @Override
    public void render(GuiGraphicsExtractor graphics, AttributeIngredient ingredient) {
        graphics.fill(0, 0, 16, 16, 0xFF302A3A);
        String name = ingredient.name().getString();
        String initial = name.isEmpty() ? "A" : name.substring(0, name.offsetByCodePoints(0, 1));
        var font = Minecraft.getInstance().font;
        graphics.text(font, initial, (16 - font.width(initial)) / 2, 4, 0xFFFFD45C, false);
    }

    @Override
    @SuppressWarnings("removal") // JEI 29 still requires this abstract tooltip method.
    public List<Component> getTooltip(AttributeIngredient ingredient, TooltipFlag tooltipFlag) {
        if (tooltipFlag.isAdvanced()) {
            return List.of(ingredient.name(), Component.literal(ingredient.id().toString()));
        }
        return List.of(ingredient.name());
    }

    @Override
    public int getWidth() {
        return 16;
    }

    @Override
    public int getHeight() {
        return 16;
    }
}
