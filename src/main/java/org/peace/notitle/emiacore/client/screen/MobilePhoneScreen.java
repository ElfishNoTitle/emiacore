package org.peace.notitle.emiacore.client.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.peace.notitle.emiacore.EmiaCore;

@Environment(EnvType.CLIENT)
public class MobilePhoneScreen extends Screen {
    public MobilePhoneScreen() {
        super(Text.literal("通讯设备"));
    }
    public ButtonWidget testButton;

    @Override
    protected void init(){
        testButton = ButtonWidget.builder(Text.literal("按钮"), button ->{

        })
                .dimensions(width / 2 - 205, 20, 200, 20)
                .tooltip(Tooltip.of(Text.literal("好棒好棒")))

                .build();

        this.addDrawableChild(testButton);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawTexture(new Identifier(EmiaCore.NAMESPACE, "textures/gui/emia_mobilephone_main.png"),width / 2 - 200, height / 2 - 100,0, 0,1297,696);
    }



    @Override
    public boolean shouldPause(){
        return false;
    }
}
