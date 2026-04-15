package lu.kolja.expandedgt.widgets

import com.gregtechceu.gtceu.api.gui.GuiTextures
import com.lowdragmc.lowdraglib.gui.texture.GuiTextureGroup
import com.lowdragmc.lowdraglib.gui.widget.SwitchWidget

class SimpleToggleButtonWidget(
    x: Int,
    y: Int,
    width: Int,
    height: Int,
    isPressed: () -> Boolean,
    onChanged: (Boolean) -> Unit
) : SwitchWidget(x, y, width, height, null) {
    init {
        setTexture(
            GuiTextures.VANILLA_BUTTON,
            GuiTextureGroup(GuiTextures.VANILLA_BUTTON, GuiTextures.BUTTON_CHECK)
        )
        setSupplier { isPressed() }
        setPressed(isPressed())
        setOnPressCallback { _, pressed -> onChanged(pressed) }
        setHoverBorderTexture(1, -1)
    }
}