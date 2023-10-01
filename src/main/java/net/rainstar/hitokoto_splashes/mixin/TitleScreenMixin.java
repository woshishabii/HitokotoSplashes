package net.rainstar.hitokoto_splashes.mixin;

import com.google.gson.Gson;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.SplashTextRenderer;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import net.rainstar.hitokoto_splashes.HitokotoSplashes;
import net.rainstar.hitokoto_splashes.util.Hitokoto;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

@Mixin({TitleScreen.class})
public class TitleScreenMixin extends Screen {
    @Shadow private @Nullable SplashTextRenderer splashText;
    Hitokoto res = new Hitokoto();

    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(
            at = {@At("HEAD")},
            method = {"init"}
    )
    private void init(CallbackInfo info) {
        Gson gson = new Gson();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("https://v1.hitokoto.cn/");
        try {
            HttpResponse response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                res = gson.fromJson(EntityUtils.toString(response.getEntity()), Hitokoto.class);
                HitokotoSplashes.LOGGER.info(res.getHitokoto());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Inject(
            at = {@At("HEAD")},
            method = {"render"}
    )
    private void render(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo info) {
        splashText = new SplashTextRenderer(res.getHitokoto());
    }
}