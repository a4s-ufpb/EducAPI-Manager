package br.ufpb.dcx.apps4society.educapimanager.model.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.ufpb.dcx.apps4society.educapimanager.model.dto.ContextDTO;
import br.ufpb.dcx.apps4society.educapimanager.model.dto.NewChallengeDTO;
import br.ufpb.dcx.apps4society.educapimanager.model.dto.UserDTO;


/**
 * Represents a Challenge for exercises or games based on words.
 *
 * @author Ayla Dantas
 * @author Emerson Dantas
 *
 */

public class Challenge implements Serializable {

	private Long id;
	private String word;
	private UserDTO creator;
	private String soundUrl;
	private String videoUrl;
	private String imageUrl;
	private Set<Context> contexts = new HashSet<>();
	
	/**
	 * Empty Constructor.
	 */
	public Challenge() { }
	/**
	 * Constructor
	 * @param id The id of this Challenge.
	 * @param word The word.
	 * @param creator The creator of this Challenge.
	 * @param soundUrl The soundUrl representing this Challenge.
	 * @param videoUrl The URL of a video representing this Challenge.
	 * @param imageUrl The imageUrl representing this Challenge.
	 */
	public Challenge(Long id, String word, UserDTO creator, String imageUrl, String soundUrl, String videoUrl,HashSet<Context> contexts) {
		this.id = id;
		this.word = word;
		this.creator = creator;
		this.soundUrl = soundUrl;
		this.videoUrl = videoUrl;
		this.imageUrl = imageUrl;
		this.contexts = contexts;
	}

	public NewChallengeDTO challengeDTO(Challenge challenge){
		return new NewChallengeDTO(challenge.getWord(), challenge.getSoundUrl(), challenge.getVideoUrl(), challenge.getImageUrl());
	}
	
	/**
	 * Gets the word of this Challenge.
	 * 
	 * @return the word of this Challenge.
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Changes the word of this Challenge.
	 * 
	 * @param word
	 *            The new word for this Challenge.
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * Gets the id of this Challenge.
	 * 
	 * @return the id of this Challenge.
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Changes the id of this Challenge.
	 * 
	 * @param id
	 *            The new id for this Challenge.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * The creator that owns this Challenge.
	 * 
	 * @return the creator that owns this Challenge.
	 */
	public UserDTO getCreator() {
		return this.creator;
	}

	/**
	 * Changes creator that owns this Challenge.
	 * 
	 * @param creator
	 *            the new creator that owns this Challenge.
	 */
	public void setCreator(UserDTO creator) {
		this.creator = creator;
	}

	/**
	 * Returns the Contexts related to this Challenge.
	 *
	 * @return the Contexts related to this Challenge.
	 */
	public Set<Context> getContexts() {
		return this.contexts;
		}

	/**
	 * Changes the Contexts related to this Challenge.
	 * 
	 * @param contexts
	 *            the Contexts related to this Challenge.
	 */
	public void setContexts(Set<Context> contexts) {
		this.contexts = contexts;
	}

	/**
	 * Returns the soundUrl for this Challenge.
	 * 
	 * @return the soundUrl for this Challenge.
	 */
	public String getSoundUrl() {
		return soundUrl;
	}

	/**
	 * Changes the soundUrl for this Challenge.
	 * 
	 * @param soundUrl
	 *            the new soundUrl for this Challenge.
	 */
	public void setSoundUrl(String soundUrl) {
		this.soundUrl = soundUrl;
	}

	/**
	 * Gets the URL of a video for this Challenge.
	 * 
	 * @return the URL of a video for this Challenge.
	 */
	public String getVideoUrl() {
		return videoUrl;
	}

	/**
	 * Sets the URL of a video for this Challenge.
	 * 
	 * @param videoUrl
	 *            The new video URL.
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	/**
	 * Returns the URL of a image  for this Challenge.
	 * 
	 * @return the URL of a image for this Challenge.
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Changes the imageUrl of this Challenge.
	 * 
	 * @param imageUrl
	 *            The new imageUrl for this Challenge.
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
		Challenge other = (Challenge) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Challenge [id=" + id + ", word=" + word + ", creator=" + creator + ", soundUrl=" + soundUrl
				+ ", videoUrl=" + videoUrl + ", imageUrl=" + imageUrl +"]";
	}


}
