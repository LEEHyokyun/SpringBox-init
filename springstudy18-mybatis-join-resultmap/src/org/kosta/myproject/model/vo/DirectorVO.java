package org.kosta.myproject.model.vo;

public class DirectorVO {
	private int directorId;
	private String directorName;
	private String intro;

	public DirectorVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDirectorId() {
		return directorId;
	}

	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public DirectorVO(int directorId, String directorName, String intro) {
		super();
		this.directorId = directorId;
		this.directorName = directorName;
		this.intro = intro;
	}

	public DirectorVO(String directorName, String intro) {
		super();
		this.directorName = directorName;
		this.intro = intro;
	}

	@Override
	public String toString() {
		return "DirectorVO [directorId=" + directorId + ", directorName=" + directorName + ", intro=" + intro + "]";
	}

}
