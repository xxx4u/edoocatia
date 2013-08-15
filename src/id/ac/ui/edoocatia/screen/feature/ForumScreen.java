package id.ac.ui.edoocatia.screen.feature;

import id.ac.ui.edoocatia.AbstractScreen;
import id.ac.ui.edoocatia.EdoocatiaGame;
import id.ac.ui.edoocatia.feature.forum.ForumController;
import id.ac.ui.edoocatia.feature.forum.SinglePost;
import id.ac.ui.edoocatia.screen.MenuScreen;

import java.util.Vector;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class ForumScreen extends AbstractScreen {

	protected ForumController forum;
	private Table mainTable;
	private ScrollPane mainPane;
	public ForumScreen() {
		super(EdoocatiaGame.FORUM);
		mainTable = new Table();
		mainTable.setClip(true);
		forum = new ForumController();
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
	public void resize(int width, int height) {
		super.resize(width, height);
		stage.setViewport(width, height, true);
		mainTable.debugCell();
		mainTable.debugTable();
		mainTable.setWidth(width);
		mainTable.add(new Label("Forum Diskusi",skin)).expandX().center().top();
		Thread trit = new Thread(new Runnable() {
			@Override
			public void run() {
				Vector<SinglePost> allPost = forum.getPosts(forum.getTopicIdList()[0]);
				String header, content;
				for (SinglePost post : allPost) {
					header = "#" + post.getId() + " " + post.getAuthorID() + ":";
					mainTable.row();
					mainTable.add(new Label(header,skin)).padTop(10);
					mainTable.row();
					content = post.getContent();
					mainTable.add(new Label(content,skin)).padTop(3);
				}
				mainPane = new ScrollPane(mainTable);
				mainPane.setSize(stage.getWidth(), stage.getHeight());
				stage.addActor(mainPane);
			}
		});
		trit.start();
	}
	
	@Override
	public void pause() {
		super.pause();
		startScreen(SCREEN_CUSTOM, new MenuScreen());
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		Table.drawDebug(stage);
	}
}
