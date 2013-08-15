package id.ac.ui.edoocatia.feature.forum;

import java.util.HashSet;

public class SinglePost {
	
	public static final String GENERAL = "umum";
	public static final String QUESTION = "tanya";
	public static final String ANSWER = "jawab";
	
	private String id;
	private String topicId;
	private String content;
	private String authorID;
	private String type;
	private String time;
	private HashSet<String> tags;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthorID() {
		return authorID;
	}

	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public HashSet<String> getTags() {
		return tags;
	}

	public void setTags(HashSet<String> tags) {
		this.tags = tags;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
