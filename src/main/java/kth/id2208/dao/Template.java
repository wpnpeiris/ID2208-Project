/**
 * 
 */
package kth.id2208.dao;

/**
 * @author pradeeppeiris
 *
 */
public class Template implements Comparable<Template> {
	private String id;
	private String name;
	private String description;
	private Double score;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(id);

		return sb.toString();
	}

	public boolean equals(Object obj) {
		boolean flag = false;
		Template template = (Template) obj;
		if (template.getId() == this.id)
			flag = true;
		return flag;
	}

	@Override
	public int compareTo(Template o) {
		double delta = o.getScore() - this.score;
		if (delta > 0)
			return 1;
		if (delta < 0)
			return -1;
		return 0;
	}

}
