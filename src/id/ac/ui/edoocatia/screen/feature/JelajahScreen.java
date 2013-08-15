package id.ac.ui.edoocatia.screen.feature;

import id.ac.ui.edoocatia.AbstractScreen;
import id.ac.ui.edoocatia.EdoocatiaGame;
import id.ac.ui.edoocatia.FetchUrl;
import id.ac.ui.edoocatia.screen.MenuScreen;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class JelajahScreen extends AbstractScreen {

	private Label label;
	public JelajahScreen() {
		super(EdoocatiaGame.JELAJAH);
		label = new Label(null, skin);
		stage = new Stage() {
			@Override
			public boolean keyDown(int keyCode) {
				if (keyCode == Keys.BACK) {
					pause();
					return true;
				}
				return super.keyDown(keyCode);
			}
		};
	}

	@Override
	public void pause() {
		super.pause();
		startScreen(SCREEN_CUSTOM, new MenuScreen());
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		stage.setViewport(width, height, true);
		Table table = new Table(skin);
        //table.debugCell();
		table.setFillParent(true);
 
        Label welcomeLabel = new Label("Materi IPA SD Kelas 4", skin );
        table.row();
        table.add(welcomeLabel).padBottom(50).left();

        label = new Label("Apa itu benda padat?\n apa bedanya dengan benda cair dan gas?\n" +
        		"Temukan jawabnnya di sini!", skin);
        table.row();
        table.add(label).padBottom(5).left();
        
        TextButton button = new TextButton("Buka", skin);
        button.addListener(new ClickListener() {
        	@Override
			public void clicked(InputEvent event, float x, float y) {
				//FetchUrl fetch = EdoocatiaGame.actionResolver.getFetcher();
				//fetch.openURL("http://www.preceptorial.com/materi-ipa-sd-kelas-iv-semester-i/");
			}
        });
        table.row();
        table.add(button).padBottom(5).center();
                
		ScrollPane scrollPane = new ScrollPane(table);
		scrollPane.setSize(stage.getWidth(), stage.getHeight());
		stage.addActor(scrollPane);
	}

}
