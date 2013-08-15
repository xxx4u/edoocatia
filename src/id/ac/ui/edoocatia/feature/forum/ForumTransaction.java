package id.ac.ui.edoocatia.feature.forum;

import id.ac.ui.edoocatia.feature.Connector;
import id.ac.ui.edoocatia.util.Log;

import java.util.Hashtable;

public class ForumTransaction extends Connector {

	private static ForumTransaction ftrans;
	public static final String KEY_TOPIC_ID = "topic_id";
	public static final String KEY_OFFSET = "offset";
	public static final String KEY_LIMIT = "limit";
	public static final String KEY_AUTHOR = "author";
	public static final String KEY_TYPE = "type";
	public static final String KEY_TAG = "tag";
	public static final String KEY_CONTENT = "content";
	public static final String KEY_ID = "post_at";
	public static final String KEY_TIME = "time";
	private final String URI = BASE_URL + "forum/";
	private final String POST_GET = URI + "post";
	private final String POST_NEW = URI + "new_post";
	
	public static ForumTransaction getInstance() {
		if (ftrans == null) {
			ftrans = new ForumTransaction();
		}
		return ftrans;
	}
	
	public String getTopicList() {
		return null;
	}
	
	public String getPost(String topicId, int offset, int limit) {
		params = new Hashtable<String, String>();
		params.put(KEY_TOPIC_ID, topicId);
		params.put(KEY_OFFSET, "" + offset);
		params.put(KEY_LIMIT, "" + limit);
		String json = getPage(POST_GET, params);
		Log.d(json);
		return json;
	}
	
	public String newPost(SinglePost newPost) {
		params = new Hashtable<String, String>();
		params.put(KEY_TOPIC_ID, newPost.getTopicId());
		params.put(KEY_AUTHOR, newPost.getAuthorID());
		params.put(KEY_TYPE, newPost.getType());
		params.put(KEY_TAG, newPost.getTags().toString());
		params.put(KEY_CONTENT, newPost.getContent());
		String json = getPage(POST_NEW, params);
		Log.d(json);
		return json;
	}
}
