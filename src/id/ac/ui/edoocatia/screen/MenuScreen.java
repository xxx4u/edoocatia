package id.ac.ui.edoocatia.screen;

import id.ac.ui.edoocatia.AbstractScreen;
import id.ac.ui.edoocatia.EdoocatiaGame;
import id.ac.ui.edoocatia.util.Log;
import id.ac.ui.edoocatia.util.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.matsemann.libgdxloadingscreen.screen.IntroLoadingScreen;

public class MenuScreen extends AbstractScreen {
	
	private Sound touch;
	private TextureAtlas menuAtlas;
	private Image bgImage;
	private Image titleImage;
	private Image charImage;
	private Button playButton;
	private Button scoreButton;
	private Button forumButton;
	private Button webButton;
	private Button soundButton;
	private Button musicButton;
	
	public MenuScreen() {
	    super(EdoocatiaGame.MODULE1);
	    
	    menuAtlas = asset.get("img/menu.pack", TextureAtlas.class);
	    touch = asset.get("sound/touch.mp3", Sound.class);
	    
	    TextureRegion splashRegion = menuAtlas.findRegion("menu-bg");
        TextureRegionDrawable textureDraw = new TextureRegionDrawable(splashRegion);
        //background
        bgImage = new Image(textureDraw, Scaling.fill, Align.center);
        //game title
        splashRegion = menuAtlas.findRegion("game title revisi");
        textureDraw = new TextureRegionDrawable(splashRegion);
        titleImage = new Image(textureDraw, Scaling.fill, Align.center);
                
        //button menu
        TextureRegionDrawable trdUp = new TextureRegionDrawable(menuAtlas.findRegion("play"));
        TextureRegionDrawable trdDown = new TextureRegionDrawable(menuAtlas.findRegion("play-alt"));
        playButton = new Button(new ButtonStyle(trdUp, trdDown, trdUp));
        playButton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (profile.isSoundEnable())
					touch.play();
				startScreen(SCREEN_CUSTOM, new IntroLoadingScreen());
			}
        });
        
        trdUp = new TextureRegionDrawable(menuAtlas.findRegion("score"));
        trdDown = new TextureRegionDrawable(menuAtlas.findRegion("score-alt"));
        scoreButton = new Button(new ButtonStyle(trdUp, trdDown, trdUp));
        scoreButton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (profile.isSoundEnable())
					touch.play();
				//startScreen(SCREEN_CUSTOM, new IntroLoadingScreen());
			}			
        });
        
        trdUp = new TextureRegionDrawable(menuAtlas.findRegion("forum"));
        trdDown = new TextureRegionDrawable(menuAtlas.findRegion("forum-alt"));
        forumButton = new Button(new ButtonStyle(trdUp, trdDown, trdUp));
        forumButton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (profile.isSoundEnable())
					touch.play();
				//startScreen(SCREEN_CUSTOM, new IntroLoadingScreen());
			}			
        });
        
        trdUp = new TextureRegionDrawable(menuAtlas.findRegion("jelajah"));
        trdDown = new TextureRegionDrawable(menuAtlas.findRegion("jelajah-alt"));
        webButton = new Button(new ButtonStyle(trdUp, trdDown, trdUp));
        webButton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (profile.isSoundEnable())
					touch.play();
				//startScreen(SCREEN_CUSTOM, new IntroLoadingScreen());
			}			
        });
	}
	
	@Override
	public void show() {
		super.show();
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		Log.d("menu show, width-height: " + width + "-" + height);
		
		bgImage.setHeight(height);
	    bgImage.setWidth(width);
	    stage.addActor(bgImage);
	    
	    titleImage.setHeight(height / 4);
        titleImage.setWidth(width * 4 / 5);
        titleImage.setX(width / 10);
        titleImage.setY(height * 5 / 8);
        stage.addActor(titleImage);
        
        float buttonWidth = width / 3;
        float buttonHeight = Util.properHeight(playButton.getWidth(), playButton.getHeight(), buttonWidth);
        
        playButton.setWidth(buttonWidth);
        playButton.setHeight(buttonHeight);
        playButton.setX((width - buttonWidth) / 2);
        playButton.setY(height / 8);
        stage.addActor(playButton);
        
        buttonWidth = buttonWidth / 3;
        buttonHeight = Util.properHeight(scoreButton.getWidth(), scoreButton.getHeight(), buttonWidth);
        float offset = playButton.getY() + playButton.getHeight();
        int newWidth = (width * 3 / 4) - 10;
        
        scoreButton.setWidth(buttonWidth);
        scoreButton.setHeight(buttonHeight);
        scoreButton.setX(newWidth);
        scoreButton.setY(offset - scoreButton.getHeight());
        offset -= (scoreButton.getHeight() + 1);
        stage.addActor(scoreButton);
        
        forumButton.setWidth(buttonWidth);
        forumButton.setHeight(buttonHeight);
        forumButton.setX(width - forumButton.getWidth() - 10);
        forumButton.setY(offset - forumButton.getHeight());
        offset -= (forumButton.getHeight() + 1);
        stage.addActor(forumButton);
        
        webButton.setWidth(buttonWidth);
        webButton.setHeight(buttonHeight);
        webButton.setX(newWidth);
        webButton.setY(offset - webButton.getHeight());
        //offset -= webButton.getHeight() - 20;
        stage.addActor(webButton);
	}
	
	@Override
	public void hide() {
		super.hide();
		stage.clear();
	}
}