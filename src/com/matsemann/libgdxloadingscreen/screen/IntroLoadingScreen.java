package com.matsemann.libgdxloadingscreen.screen;

import id.ac.ui.edoocatia.EdoocatiaGame;
import id.ac.ui.edoocatia.screen.IntroScreen;
import id.ac.ui.edoocatia.screen.intro.IntroScene;

import com.badlogic.gdx.graphics.Texture;

/**
 * @author Mats Svensson
 */
public class IntroLoadingScreen extends LoadingScreen {

    public IntroLoadingScreen() {
        super(EdoocatiaGame.MODULE1, new IntroScreen(asset));
    }

    @Override
    public void show() {
        // Add everything to be loaded, for instance:
        // game.manager.load("data/assets1.pack", TextureAtlas.class);
        // game.manager.load("data/assets2.pack", TextureAtlas.class);
        // game.manager.load("data/assets3.pack", TextureAtlas.class);
        asset.load(IntroScene.INTRO1, Texture.class);
        asset.load(IntroScene.INTRO2, Texture.class);
        asset.load(IntroScene.INTRO3, Texture.class);
        asset.load(IntroScene.INTRO4, Texture.class);
        asset.load(IntroScene.INTRO4B, Texture.class);
        asset.load(IntroScene.INTRO5, Texture.class);
        asset.load(IntroScene.INTRO5B, Texture.class);
        asset.load(IntroScene.INTRO_CHAR, Texture.class);
    }
}
