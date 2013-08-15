package id.ac.ui.edoocatia.feature.forum;

import id.ac.ui.edoocatia.util.Log;

import java.util.Vector;

public class ForumController {

	protected final String[] TOPIC_ID = {"1"};
	protected ForumTransaction ftrans;
	
	public ForumController() {
		ftrans = ForumTransaction.getInstance();
	}
	
	public String[] getTopicIdList() {
		return TOPIC_ID;
	}
	
	public Vector<SinglePost> getPosts(String topicId) {
		return getPosts(topicId, 0, 10);
	}
	
	public Vector<SinglePost> getPosts(String topicId, int offset, int limit) {
		String json = ftrans.getPost(topicId, offset, limit);
		Vector<SinglePost> allPost = new Vector<SinglePost>();
		SinglePost post;
		/*try {
			JSONArray jarr = new JSONArray(json);
			JSONObject job;
			for (int i=0; i < jarr.length(); i++) {
				job = jarr.getJSONObject(i);
				post = new SinglePost();
				post.setId(job.getString(ForumTransaction.KEY_ID));
				post.setAuthorID(job.getString("user_id"));
				post.setTopicId(job.getString(ForumTransaction.KEY_TOPIC_ID));
				post.setType(job.getString(ForumTransaction.KEY_TYPE));
				post.setTags(new HashSet<String>());
				post.setContent(job.getString(ForumTransaction.KEY_CONTENT));
				post.setTime(job.getString(ForumTransaction.KEY_TIME));
				allPost.add(post);
			}
		} catch (JSONException e) {
			Log.d("EdoocatiaApps", "error: " + e.getMessage());
			e.printStackTrace();
		}*/
		Log.d("size: " +allPost.size());
		return allPost;
	}
}
