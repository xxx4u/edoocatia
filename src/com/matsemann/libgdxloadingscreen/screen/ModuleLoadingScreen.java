package com.matsemann.libgdxloadingscreen.screen;

import id.ac.ui.edoocatia.EdoocatiaGame;
import id.ac.ui.edoocatia.screen.feature.ChooseCharacter;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * @author Mats Svensson
 */
public class ModuleLoadingScreen extends LoadingScreen {

    public ModuleLoadingScreen() {
        super(EdoocatiaGame.MODULE1, new ChooseCharacter());
    }

    @Override
    public void show() {
        super.show();
        // Add everything to be loaded, for instance:
        // game.manager.load("data/assets1.pack", TextureAtlas.class);
        // game.manager.load("data/assets2.pack", TextureAtlas.class);
        // game.manager.load("data/assets3.pack", TextureAtlas.class);
        /*asset.load("sound/applause.mp3", Sound.class);
        asset.load("sound/disappoint.mp3", Sound.class);
        asset.load("sound/hammer-hit.mp3", Sound.class);
        asset.load("sound/tada.mp3", Sound.class);
        asset.load("sound/touch.mp3", Sound.class);*/
        asset.load("sound/transisi1.mp3", Sound.class);
        asset.load("sound/transisi2.mp3", Sound.class);
        //asset.load("sound/warning.mp3", Sound.class);
        asset.load("char/momo.pack", TextureAtlas.class);
        asset.load("char/alta.atlas", TextureAtlas.class);
        asset.load("char/azmo.atlas", TextureAtlas.class);
        asset.load("char/tsarina.atlas", TextureAtlas.class);
    }
}
