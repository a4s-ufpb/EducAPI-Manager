package br.ufpb.dcx.apps4society.educapimanager.model.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.ufpb.dcx.apps4society.educapimanager.model.dto.NewContextDTO;
import br.ufpb.dcx.apps4society.educapimanager.model.dto.UserDTO;

/**
 * This class represents a set of related challenges.
 * 
 * @author Ayla Dantas
 * @author Emerson Dantas
 *
 */

public class Context implements Serializable {
	private Long id;
	private String name;

	private UserDTO creator;
	private String imageUrl;
	private String soundUrl;
	private String videoUrl;

	private Set<Challenge> challenges = new HashSet<>();
	
	/**
	 * Empty Constructor.
	 */
	public Context() {}
	
	/**
	 * Constructor
	 * @param id The id of this Context.
	 * @param name The Context name.
	 * @param creator The creator of this Context.
	 * @param imageUrl The image for this Context.
	 * @param soundUrl The sound for this Context.
	 * @param videoUrl The URL of a video for this Context.
	 */
	public Context(Long id, String name, UserDTO creator, String imageUrl, String soundUrl, String videoUrl) {
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.imageUrl = imageUrl;
		this.soundUrl = soundUrl;
		this.videoUrl = videoUrl;
	}

	public NewContextDTO toNewContextDto(Context context){
		return new NewContextDTO(context.name, context.imageUrl, context.soundUrl, context.videoUrl);
	}

	/**
	 * Gets the name of this Context.
	 * 
	 * @return the name of this Context.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name of this Context.
	 * 
	 * @param name
	 *            The new name of this Context.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the id of this Context.
	 * 
	 * @return the if of this Context.
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Changes the if of this Context.
	 * 
	 * @param id
	 *            The new value of the id for this Context.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the user that created this Context.
	 * 
	 * @return The user that created this Context.
	 */
	public UserDTO getCreator() {
		return this.creator;
	}

	/**
	 * Changes user that owns this Context.
	 * 
	 * @param creator
	 *            The user creator.
	 */
	public void setCreator(UserDTO creator) {
		this.creator = creator;
	}

	/**
	 * Gets a String representing the byte[] of a sound for this Context.
	 * 
	 * @return a String representing the byte[] of a sound for this Context.
	 */
	public String getSoundUrl() {
		return soundUrl;
	}

	/**
	 * Changes the sound of this Context.
	 * 
	 * @param soundUrl
	 *            The sound of this Context, represented by a byte[].
	 */
	public void setSoundUrl(String soundUrl) {
		this.soundUrl = soundUrl;
	}

	/**
	 * Gets the URL of a video representing this Context.
	 * 
	 * @return the URL of a video representing this Context.
	 */
	public String getVideoUrl() {
		return videoUrl;
	}

	/**
	 * Changes the URL of a video representing this Context.
	 * 
	 * @param videoUrl
	 *            the new URL of a video representing this Context.
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}


	/**
	 * Gets a String representing the byte[] of an image for this Context.
	 * 
	 * @return a String representing the byte[] of an image for this Context.
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Sets the String representing the byte[] of an image for this Context.
	 * 
	 * @param imageUrl
	 *            String representing the byte[] of an image for this Context.
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	/**
	 * Gets the HashSet that contains the challenges from this Context.
	 * 
	 * @return a HashSet that contains the challenges from this Context.
	 */
	public Set<Challenge> getChallenges() {
		return challenges;
	}
	
	/**
	 * Sets the HashSet that contains the challenges from this Context.
	 * 
	 * @param challenges
	 *            HashSet that contains the challenges from this Context.
	 */
	public void setChallenges(Set<Challenge> challenges) {
		this.challenges = challenges;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Context other = (Context) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Context [id=" + id + ", name=" + name + ", creator=" + creator + ", imageUrl=" + imageUrl
				+ ", soundUrl=" + soundUrl + ", videoUrl=" + videoUrl + ", challenges=" + challenges + "]";
	}
	
}
